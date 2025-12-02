import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* ============================
   ENUMS
   ============================ */
enum SeatType { REGULAR, PREMIUM, RECLINER }
enum SeatStatus { AVAILABLE, LOCKED, BOOKED }
enum BookingStatus { PENDING, CONFIRMED, CANCELLED, EXPIRED }

/* ============================
   User
   ============================ */
class User {
    String id;
    String name;

    User(String id, String name) { this.id = id; this.name = name; }
}

/* ============================
   Movie
   ============================ */
class Movie {
    String id;
    String title;
    String language;
    int duration;

    Movie(String id, String title, String lang, int duration) {
        this.id = id; 
        this.title = title; 
        this.language = lang; 
        this.duration = duration;
    }
}

/* ============================
   Seat
   ============================ */
class Seat {
    String seatId;
    SeatType type;
    int row, col;

    Seat(String id, SeatType type, int row, int col) {
        this.seatId = id;
        this.type = type;
        this.row = row;
        this.col = col;
    }
}

/* ============================
   Screen
   ============================ */
class Screen {
    String screenId;
    List<Seat> seats;

    Screen(String id, List<Seat> seats) {
        this.screenId = id;
        this.seats = seats;
    }
}

/* ============================
   Theatre
   ============================ */
class Theatre {
    String theatreId;
    String name;
    String city;
    List<Screen> screens;
    List<Show> shows;

    Theatre(String id, String name, String city) {
        this.theatreId = id;
        this.name = name;
        this.city = city;
        this.screens = new ArrayList<>();
        this.shows = new ArrayList<>();
    }

    void addScreen(Screen s) {screens.add(s);}
    void addShow(Show s) {shows.add(s);}
}

/* ============================
   Show
   ============================ */
class Show {
    String showId;
    Movie movie;
    Screen screen;
    Date startTime;

    // Thread-safe seat status map
    ConcurrentHashMap<String, SeatStatus> seatStatus = new ConcurrentHashMap<>();
    Map<SeatType, Double> pricing = new HashMap<>();

    Show(String id, Movie movie, Screen screen, Date time) {
        this.showId = id;
        this.movie = movie;
        this.screen = screen;
        this.startTime = time;

        // initialize all seats as AVAILABLE
        for (Seat s : screen.seats) {
            seatStatus.put(s.seatId, SeatStatus.AVAILABLE);
        }

        pricing.put(SeatType.REGULAR, 200.0);
        pricing.put(SeatType.PREMIUM, 300.0);
        pricing.put(SeatType.RECLINER, 500.0);
    }
}

/* ============================
   Payment
   ============================ */
class Payment {
    String id;
    boolean success;

    Payment(String id, boolean success) {
        this.id = id;
        this.success = success;
    }
}

/* ============================
   Booking
   ============================ */
class Booking {
    String bookingId;
    User user;
    Show show;
    List<Seat> seats;
    BookingStatus status;
    Payment payment;

    Booking(String id, User user, Show show, List<Seat> seats) {
        this.bookingId = id;
        this.user = user;
        this.show = show;
        this.seats = seats;
        this.status = BookingStatus.PENDING;
    }
}

/* ============================
   Seat Lock Service (Singleton)
   ============================ */
class SeatLockService {

    private SeatLockService() {}

    // Bill-Pugh Singleton
    public static class Holder {
        private static final SeatLockService INSTANCE = new SeatLockService();
    }
    public static SeatLockService getInstance() {
        return Holder.INSTANCE;
    }

    // Thread-safe
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, Long>> locks = new ConcurrentHashMap<>();
    // {showId : {seatId: lockExpiryTimestamp }}
    // example: locks["Show123"] = {
    //              "S1" -> 1738800000000 (expiry time),
    //              "S2" -> 1738800000000
    //          }

    //Lock duration = 5 minutes.
    private final long lockDurationMs = 5 * 60 * 1000;

    synchronized boolean lockSeats(Show show, List<Seat> seats, User user) {
        locks.putIfAbsent(show.showId, new ConcurrentHashMap<>());
        ConcurrentHashMap<String, Long> showLocks = locks.get(show.showId);

        // Check all seats are free
        for (Seat s : seats) {
            SeatStatus status = show.seatStatus.get(s.seatId);
            if (status != SeatStatus.AVAILABLE) return false;
        }

        // Lock all seats
        long expiry = System.currentTimeMillis() + lockDurationMs;
        for (Seat s : seats) {
            show.seatStatus.put(s.seatId, SeatStatus.LOCKED);
            showLocks.put(s.seatId, expiry);
        }
        return true;
    }

    synchronized void releaseSeats(Show show, List<Seat> seats) {
        for (Seat s : seats) {
            if (show.seatStatus.get(s.seatId) == SeatStatus.LOCKED)
                show.seatStatus.put(s.seatId, SeatStatus.AVAILABLE);
        }
    }

    synchronized void markSeatsBooked(Show show, List<Seat> seats) {
        for (Seat s : seats) {
            show.seatStatus.put(s.seatId, SeatStatus.BOOKED);
        }
    }
}

/* ============================
   Payment Strategy
   ============================ */
interface PaymentStrategy {
    Payment pay(Booking booking);
}

class DummyPaymentGateway implements PaymentStrategy {
    public Payment pay(Booking booking) {
        return new Payment("PMT-" + booking.bookingId, true); // always success
    }
}

/* ============================
   Booking Service
   ============================ */
class BookingService {
    SeatLockService lockService;
    PaymentStrategy paymentStrategy;

    Map<String, Booking> bookings = new ConcurrentHashMap<>();
    AtomicInteger idGen = new AtomicInteger(1001);

    BookingService(SeatLockService lockService, PaymentStrategy p) {
        this.lockService = lockService;
        this.paymentStrategy = p;
    }

    synchronized Booking createBooking(User user, Show show, List<Seat> seats) throws Exception {
        boolean locked = lockService.lockSeats(show, seats, user);

        if (!locked) 
            throw new Exception("Seats are not available");

        String id = "BKG-" + idGen.getAndIncrement();
        Booking b = new Booking(id, user, show, seats);
        bookings.put(id, b);
        return b;
    }

    synchronized Booking confirmBooking(String bookingId) throws Exception {
        Booking b = bookings.get(bookingId);
        if (b == null) throw new Exception("Invalid booking");

        Payment p = paymentStrategy.pay(b);
        b.payment = p;

        if (p.success) {
            b.status = BookingStatus.CONFIRMED;
            lockService.markSeatsBooked(b.show, b.seats);
        } else {
            b.status = BookingStatus.CANCELLED;
            lockService.releaseSeats(b.show, b.seats);
        }

        return b;
    }
}

/* ============================
   Search Service
   ============================ */
class SearchService {
    List<Movie> movies;
    List<Theatre> theatres;
    List<Show> shows;

    SearchService(List<Movie> m, List<Theatre> t, List<Show> s) {
        movies = m; theatres = t; shows = s;
    }

    List<Show> searchShows(String movieId) {
        List<Show> res = new ArrayList<>();
        for (Show s : shows) {
            if (s.movie.id.equals(movieId)) res.add(s);
        }
        return res;
    }
}

/* ============================
   DEMO
   ============================ */
public class MovieTicketBookingSystem {
    public static void main(String[] args) throws Exception {

        // Create seats
        List<Seat> seats = Arrays.asList(
                new Seat("S1", SeatType.REGULAR, 1, 1),
                new Seat("S2", SeatType.REGULAR, 1, 2),
                new Seat("S3", SeatType.RECLINER, 1, 3)
        );

        Screen screen1 = new Screen("Screen1", seats);
        Theatre theatre = new Theatre("T1", "PVR Koramangala", "Bangalore");
        theatre.addScreen(screen1);

        Movie movie = new Movie("M1", "Inception", "English", 120 );

        // Create a show
        Show show = new Show("SH1", movie, screen1, new Date());
        theatre.addShow(show);

        // System
        SeatLockService lockService = SeatLockService.getInstance();
        BookingService bookingService = new BookingService(lockService, new DummyPaymentGateway());

        // User
        User user = new User("U1", "Alice");

        // Booking
        Booking b = bookingService.createBooking(user, show, Arrays.asList(seats.get(0), seats.get(1)));
        System.out.println("Booking created: " + b.bookingId + " Status: " + b.status);

        // Confirm Booking (payment)
        Booking b2 = bookingService.confirmBooking(b.bookingId);
        System.out.println("Booking status after payment: " + b2.status);

        // Show seat statuses
        System.out.println("Seat S1 status: " + show.seatStatus.get("S1"));
        System.out.println("Seat S2 status: " + show.seatStatus.get("S2"));
    }
}
