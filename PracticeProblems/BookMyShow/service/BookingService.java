package service;

import Exceptions.SeatNotAvailableExeception;
import enums.BookingStatus;
import enums.PaymentType;
import lombok.AllArgsConstructor;
import model.Booking;
import model.Seat;
import model.Show;
import repository.BookingRepository;
import strategy.locking.LockProvider;
import strategy.payment.PaymentStrategy;
import strategy.payment.PaymentStrategyFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
public class BookingService {
    private final LockProvider lockProvider;
    private final BookingRepository bookingRepo;

    private static final long TTL = 4 * 1000L; // 5mins

    public Booking createBooking(String userId, List<String> seatIds, Show show) throws SeatNotAvailableExeception {

        // try lock seats
        for(String seatId: seatIds){
            String key = show.getId() + ":" + seatId;
            if( !lockProvider.tryLock(key, userId, TTL)){
                throw new SeatNotAvailableExeception("Seat " + seatId + " is temporarily unavailable");
            }
        }

        double totalPrice = 0.0;
        for(Seat seat: show.getSeats()){
            if(seatIds.contains(seat.getId())){
                totalPrice += seat.getAmount();
            }
        }


        Booking booking = new Booking(
                UUID.randomUUID().toString(),
                userId,
                seatIds,
                totalPrice,
                BookingStatus.CREATED,
                null,
                show.getId()
        );

        bookingRepo.save(booking);

        System.out.println("Booking created: " + booking.getBookingId());

        return booking;
    }

    public boolean confirmBooking(Booking booking, PaymentType paymentType) throws SeatNotAvailableExeception {
        if(booking.getStatus() != BookingStatus.CREATED){
            throw  new IllegalStateException("Booking is not in a  valid state for a confirmation");
        }

        for(String seatId: booking.getSeatIds()){
            String key = booking.getShowId() + ":" + seatId;

            if(lockProvider.isLockExpired(key) || !lockProvider.isLockedBy(key, booking.getUserId())){
                throw new SeatNotAvailableExeception("Seat " + seatId + " is temporarily unavailable");
            }
        }

        booking.setPaymentType(paymentType);
        PaymentStrategy paymentStrategy = PaymentStrategyFactory.getStrategy(booking.getPaymentType());
        paymentStrategy.pay(booking);

        for(String seatId: booking.getSeatIds()){
            String key = booking.getShowId() +":" + seatId;
            lockProvider.unlock(key);
        }

        booking.setStatus(BookingStatus.CONFIRMED);

        System.out.println("Booking confimed: " + booking.getBookingId());
        return true;
    }

    public Booking getBooking(String bookingId){
        return bookingRepo.get(bookingId);
    }
}
