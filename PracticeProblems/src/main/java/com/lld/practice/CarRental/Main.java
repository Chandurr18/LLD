package com.lld.practice.CarRental;

import com.lld.practice.CarRental.enums.VehicleType;
import com.lld.practice.CarRental.exceptions.NoBranchFoundException;
import com.lld.practice.CarRental.exceptions.NoVehiclesFoundException;
import com.lld.practice.CarRental.factory.VehicleFactory;
import com.lld.practice.CarRental.model.Booking;
import com.lld.practice.CarRental.model.Branch;
import com.lld.practice.CarRental.model.User;
import com.lld.practice.CarRental.repository.BookingRepository;
import com.lld.practice.CarRental.repository.BranchRepository;
import com.lld.practice.CarRental.service.BookingService;
import com.lld.practice.CarRental.strategy.booking.LeastBookedVehicleStrategy;
import com.lld.practice.CarRental.strategy.payment.CreditCardPayment;
import com.lld.practice.CarRental.strategy.payment.UPIPayment;
import com.lld.practice.CarRental.strategy.pricing.HourlyPricingStrategy;
import com.lld.practice.CarRental.utils.DateTimeParser;


import java.time.LocalDateTime;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws NoBranchFoundException, NoVehiclesFoundException {
        BranchRepository branchRepo = new BranchRepository();
        BookingRepository bookingRepo = new BookingRepository();

        Branch branch1 = new Branch("B1", "Hyderabad");
        Branch branch2 = new Branch("B2", "Delhi");

        branchRepo.addBranch(branch1);
        branchRepo.addBranch(branch2);

        branch1.addVehicle(VehicleFactory.create(VehicleType.SEDAN, "TG123", 10, 20));
        branch1.addVehicle(VehicleFactory.create(VehicleType.SEDAN, "TG234", 11, 21));
        branch1.addVehicle(VehicleFactory.create(VehicleType.SUV, "TG345", 12, 22));

        branch2.addVehicle(VehicleFactory.create(VehicleType.SEDAN, "DH123", 10, 20));

        User user1 = new User("U1", "Alice", "alice@gmail.com");
        User user2 = new User("U2", "Bob", "bob@gmail.com");

        LocalDateTime start = DateTimeParser.parse("21 May 7:30 AM 2025");
        LocalDateTime end = DateTimeParser.parse("21 May 12:30 AM 2025");

        BookingService bookingService = BookingService.getInstance(
                branchRepo,
                bookingRepo,
                new LeastBookedVehicleStrategy(),
                new HourlyPricingStrategy()
        );

        System.out.println("-----------------");

        Optional<Booking> booking1 = bookingService.bookVehicle(
                "B1",
                VehicleType.SEDAN,
                start,
                end,
                user1,
                new CreditCardPayment(),
                branch1,
                branch2,
                100.0
        );

        System.out.println("-----------------");

        Optional<Booking> booking2 = bookingService.bookVehicle(
                "B1",
                VehicleType.SEDAN,
                start,
                end,
                user2,
                new UPIPayment(),
                branch1,
                branch2,
                100.0
        );



        // MULTI-THREADED BOOKING ON ONE SUV, T1, T2;

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " started!");
            try {
                bookingService.bookVehicle(
                        "B1",
                        VehicleType.SUV,
                        start,
                        end,
                        user1,
                        new CreditCardPayment(),
                        branch1,
                        branch2,
                        100.0
                );
            } catch (NoBranchFoundException | NoVehiclesFoundException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " started!");
            try {
                bookingService.bookVehicle(
                        "B1",
                        VehicleType.SUV,
                        start,
                        end,
                        user2,
                        new CreditCardPayment(),
                        branch1,
                        branch2,
                        100.0
                );
            } catch (NoBranchFoundException | NoVehiclesFoundException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();

        System.out.println("------------------");

    }
}
