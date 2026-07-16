package PracticeProblems.TrafficSignalSystem;

import PracticeProblems.TrafficSignalSystem.controller.EmergencyController;
import PracticeProblems.TrafficSignalSystem.controller.IntersectionController;
import PracticeProblems.TrafficSignalSystem.controller.TimingController;
import PracticeProblems.TrafficSignalSystem.controller.TrafficController;
import PracticeProblems.TrafficSignalSystem.domain.enums.Direction;
import PracticeProblems.TrafficSignalSystem.respository.IntersectionRepository;
import PracticeProblems.TrafficSignalSystem.services.EmergencyService;
import PracticeProblems.TrafficSignalSystem.services.IntersectionService;
import PracticeProblems.TrafficSignalSystem.services.TimingService;
import PracticeProblems.TrafficSignalSystem.services.TrafficService;

public class TrafficSystem {

    public static void main(String[] args) {

        // Repository
        IntersectionRepository repository = new IntersectionRepository();

        // Services
        IntersectionService intersectionService = new IntersectionService(repository);
        TimingService timingService = new TimingService();
        TrafficService trafficService = new TrafficService();
        EmergencyService emergencyService = new EmergencyService(intersectionService);

        // Controllers
        IntersectionController intersectionController =
                new IntersectionController(intersectionService);

        TimingController timingController =
                new TimingController(timingService);

        TrafficController trafficController =
                new TrafficController(trafficService);

        EmergencyController emergencyController =
                new EmergencyController(emergencyService);

        System.out.println("\n========== CREATE INTERSECTION ==========");
        intersectionController.createIntersection(1, "Central Junction");

        System.out.println("\n========== CONFIGURE SIGNAL TIMINGS ==========");
        timingController.setSignalTiming(1, Direction.NORTH, 40);
        timingController.setSignalTiming(1, Direction.EAST, 35);
        timingController.setSignalTiming(1, Direction.SOUTH, 45);
        timingController.setSignalTiming(1, Direction.WEST, 30);

        System.out.println("North Green Time : "
                + timingController.getSignalTiming(1, Direction.NORTH));

        System.out.println("East Green Time : "
                + timingController.getSignalTiming(1, Direction.EAST));

        System.out.println("\n========== VEHICLE COUNTS ==========");

        trafficController.incrementVehicleCount(Direction.NORTH);
        trafficController.incrementVehicleCount(Direction.NORTH);
        trafficController.incrementVehicleCount(Direction.NORTH);

        trafficController.incrementVehicleCount(Direction.EAST);

        trafficController.incrementVehicleCount(Direction.SOUTH);
        trafficController.incrementVehicleCount(Direction.SOUTH);

        System.out.println("North Vehicles : "
                + trafficController.getVehileCount(Direction.NORTH));

        System.out.println("East Vehicles : "
                + trafficController.getVehileCount(Direction.EAST));

        System.out.println("South Vehicles : "
                + trafficController.getVehileCount(Direction.SOUTH));

        System.out.println("\n========== START TRAFFIC CYCLE ==========");
        intersectionController.startCycle(1);

        System.out.println("\n========== EMERGENCY REQUEST ==========");
        emergencyController.requestEmergency(
                1,
                Direction.NORTH,
                30
        );

        System.out.println("\n========== EMERGENCY CLEARED ==========");
        emergencyController.endEmergency(1);

        System.out.println("\n========== RESET VEHICLE COUNT ==========");
        trafficController.resetVehicleCount(Direction.NORTH);

        System.out.println("North Vehicles After Reset : "
                + trafficController.getVehileCount(Direction.NORTH));

        System.out.println("\n========== DEMO COMPLETED ==========");
    }
}