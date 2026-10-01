import Exceptions.SeatNotAvailableExeception;
import enums.PaymentType;
import model.*;
import repository.BookingRepository;
import repository.MovieRepository;
import repository.ShowRepository;
import repository.TheatreRepository;
import service.BookingService;
import service.MovieService;
import service.ShowService;
import service.TheatreService;
import strategy.locking.InMemoryLockProvider;
import strategy.locking.LockProvider;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // repos
        TheatreRepository theatreRepo = new TheatreRepository();
        MovieRepository movieRepo = new MovieRepository();
        ShowRepository showRepo = new ShowRepository();
        BookingRepository bookingRepo = new BookingRepository();

        // lock provider
        LockProvider lockProvider = new InMemoryLockProvider();

        // services
        TheatreService theatreService = new TheatreService(theatreRepo);
        MovieService movieService = new MovieService(movieRepo);
        ShowService showService = new ShowService(showRepo, theatreRepo, movieRepo);
        BookingService bookingService = new BookingService(lockProvider, bookingRepo);

        // Create theatre and screen
        Theatre pvr = theatreService.createTheatre("t1", "PVR Theatre");
        Screen screen1 = new Screen("s1");
        theatreService.addScreen("t1", screen1);

        // Create movie
        Movie movie1 = movieService.createMovie("movie1", "InterStellar", 180);

        // Regular seats
        theatreService.addSeat("t1", "s1", new RegularSeat("s1-2", 150));
        theatreService.addSeat("t1", "s1", new RegularSeat("s1-3", 150));
        theatreService.addSeat("t1", "s1", new RegularSeat("s1-4", 150));
        theatreService.addSeat("t1", "s1", new RegularSeat("s1-5", 150));
        theatreService.addSeat("t1", "s1", new RegularSeat("s1-6", 150));
        theatreService.addSeat("t1", "s1", new RegularSeat("s1-7", 150));
        theatreService.addSeat("t1", "s1", new RegularSeat("s1-8", 150));

        // Recliner Seats
        theatreService.addSeat("t1", "s1", new ReclinerSeat("s1-9", 300));
        theatreService.addSeat("t1", "s1", new ReclinerSeat("s1-10", 300));

        // Schedule show
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.JULY, 16, 18, 30, 0); // 6:30 on July 17
        Date showStartTime = calendar.getTime();

        Show show1 = showService.createShow("show1", "movie1", "s1", "t1", showStartTime);


        System.out.println("=== Demo 1: Search Shows by Movie ===");
        List<Show> shows = showService.getShowsByMovieTitle("InterStellar");
        shows.forEach(System.out::println);

        System.out.println("\n=== Demo 2: 1 User books seats ===");
        try {
            Booking booking1 = bookingService.createBooking("user1", List.of("s1-1", "s1-2"),show1);
            bookingService.confirmBooking(booking1, PaymentType.CARD);
        } catch (SeatNotAvailableExeception e) {
            System.out.println("User1 failed: " + e.getMessage());
        }

        System.out.println("\n=== Demo 3: 2 users book overlapping seats concurrently ===");
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> {
            try {
                Booking booking2 = bookingService.createBooking("user2", List.of("s1-3", "s1-4"),show1);
                Thread.sleep(1000);
                bookingService.confirmBooking(booking2, PaymentType.CARD);
            } catch (Exception | SeatNotAvailableExeception e) {
                System.out.println("user2 failed: " + e.getMessage());
            }
        });

        executor.submit(() -> {
            try {
                Booking booking3 = bookingService.createBooking("user3", List.of("s1-4", "s1-5"),show1);
                Thread.sleep(1000);
                bookingService.confirmBooking(booking3, PaymentType.UPI);
            } catch (Exception | SeatNotAvailableExeception e) {
                System.out.println("user3 failed: " + e.getMessage());
            }
        });

        Thread.sleep(2000);
        System.out.println("\n=== Demo 4: Booking expires after TTL ===");

        try{
            Booking booking4 = bookingService.createBooking("user4", List.of("s1-6", "s1-7"), show1);
            System.out.println("user 4 created booking but did not pay");

            // TTl = 4s for demo
            Thread.sleep(5000);

            System.out.println("user5 trying to book same seats after TTl");
            Booking booking5 = bookingService.createBooking("user5", List.of("s1-6", "s1-7"), show1);
            System.out.println("user5 booking created");

            System.out.println("user4 trying to pay after TTL");
            try {
                bookingService.confirmBooking(booking4, PaymentType.CARD);
            } catch (SeatNotAvailableExeception e) {
                System.out.println("user4 failed: " + e.getMessage());
            }

            System.out.println("User5 confirming payment");
            bookingService.confirmBooking(booking5, PaymentType.UPI);
            System.out.println("User5 payment successfull");



        } catch (Exception e) {
            System.out.println("User3 failed: " + e.getMessage());

        } catch (SeatNotAvailableExeception e) {
            throw new RuntimeException(e);
        }
    }
}
