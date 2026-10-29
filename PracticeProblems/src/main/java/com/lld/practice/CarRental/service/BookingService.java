package com.lld.practice.CarRental.service;

import com.lld.practice.CarRental.enums.BookingStatus;
import com.lld.practice.CarRental.enums.VehicleStatus;
import com.lld.practice.CarRental.enums.VehicleType;
import com.lld.practice.CarRental.exceptions.BookingNotFoundException;
import com.lld.practice.CarRental.exceptions.NoBranchFoundException;
import com.lld.practice.CarRental.exceptions.NoVehiclesFoundException;
import com.lld.practice.CarRental.exceptions.VehicleNotBookedException;
import com.lld.practice.CarRental.model.Booking;
import com.lld.practice.CarRental.model.Branch;
import com.lld.practice.CarRental.model.User;
import com.lld.practice.CarRental.model.Vehicle;
import com.lld.practice.CarRental.repository.BookingRepository;
import com.lld.practice.CarRental.repository.BranchRepository;
import com.lld.practice.CarRental.strategy.booking.BookingStrategy;
import com.lld.practice.CarRental.strategy.payment.PaymentStrategy;
import com.lld.practice.CarRental.strategy.pricing.PricingStrategy;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.UUID;

public class BookingService {
    private static volatile BookingService instance;

    private final BranchRepository branchRepo;
    private final BookingRepository bookingRepo;

    @Setter
    private BookingStrategy bookingStrategy;

    @Setter
    private  PricingStrategy pricingStrategy;

    private BookingService(BranchRepository branchRepo,
                           BookingRepository bookingRepo,
                           BookingStrategy bookingStrategy,
                           PricingStrategy pricingStrategy) {
        this.bookingRepo = bookingRepo;
        this.branchRepo = branchRepo;
        this.bookingStrategy = bookingStrategy;
        this.pricingStrategy = pricingStrategy;
    }

    public static BookingService getInstance(BranchRepository branchRepo,
                                             BookingRepository bookingRepo,
                                             BookingStrategy bookingStrategy,
                                             PricingStrategy pricingStrategy){
        instance = new BookingService(branchRepo, bookingRepo, bookingStrategy, pricingStrategy);
        return instance;
    }

    public Optional<Booking> bookVehicle(String branchId,
                                         VehicleType vehicleType,
                                         LocalDateTime start,
                                         LocalDateTime end,
                                         User user,
                                         PaymentStrategy paymentStrategy,
                                         Branch pickUpBranch,
                                         Branch dropBranch,
                                         double distanceKm) throws NoBranchFoundException, NoVehiclesFoundException {
        Optional<Branch> branch = branchRepo.getBranchById(branchId);
        if(branch.isEmpty()) {
            throw new NoBranchFoundException("Branch not found");
        }

        List<Vehicle> activeVehicles = branch.get().getVehiclesByType(vehicleType).stream()
                .filter(v -> v.getStatus() == VehicleStatus.AVAILABLE)
                .filter(v -> !v.getIsBooked().get())
                .toList();

        if(activeVehicles.isEmpty()) {
            throw new NoVehiclesFoundException("No Active " + vehicleType.name() + " vehicles available.");
        }

        // Booking strategy try to book vehicle

        Vehicle vehicle = bookingStrategy.bookVehicle(activeVehicles);

        if(vehicle == null) {
            throw new NoVehiclesFoundException("No Active " + vehicleType.name() + " vehicles available.");
        }

        double amount = pricingStrategy.calculatePrice(vehicle, start, end, distanceKm);

        Booking booking = Booking.builder()
                .bookingId(UUID.randomUUID().toString())
                .user(user)
                .vehicle(vehicle)
                .pickupBranch(pickUpBranch)
                .dropBranch(dropBranch)
                .startTime(start)
                .endTime(end).amount(amount).build();

        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentStrategy);

        if(!paymentProcessor.pay(booking)) {
            System.out.println("Payment failed");

            // rollback booking if payment fails
            vehicle.getIsBooked().set(false);
            return Optional.empty();
        }

        booking.setStatus(BookingStatus.CONFIRMED);
        bookingRepo.addBooking(booking);

        vehicle.incrementBookingCount();
        vehicle.setStatus(VehicleStatus.BOOKED);

        pickUpBranch.removeVehicle(vehicle);
        System.out.println(booking);

        return  Optional.of(booking);
    }

    public void returnVehicle(String bookingId) throws BookingNotFoundException, VehicleNotBookedException {
        Optional<Booking> bookingOpt = bookingRepo.getBookingById(bookingId);

        if(bookingOpt.isEmpty()) {
            throw  new BookingNotFoundException("Booking not found !!!");
        }

        Booking booking = bookingOpt.get();

        if(booking.getStatus() != BookingStatus.CONFIRMED) {
            throw  new VehicleNotBookedException("Vehicle is not currently Booked!!!");
        }

        booking.setStatus(BookingStatus.COMPLETED);
        booking.getVehicle().getIsBooked().set(false);

        Branch dropBranch = booking.getDropBranch();
        dropBranch.addVehicle(booking.getVehicle());

        System.out.println("Vehicle return to branch "  + dropBranch.getCity() + " : " + bookingId);
    }
}
