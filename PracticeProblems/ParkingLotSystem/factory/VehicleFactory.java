package factory;

import enums.VehicleType;
import model.Bike;
import model.Car;
import model.Truck;
import model.Vehicle;

public class VehicleFactory {
    public static Vehicle create(String number, VehicleType type) {
        return switch (type) {
            case CAR -> new Car(number);
            case BIKE -> new Bike(number);
            case TRUCK -> new Truck(number);
        };
    }
}
