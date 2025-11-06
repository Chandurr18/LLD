package ClassRelationships.Association.Uni_Directional;

/**
 * Uni-directional Association:
 * Car has a long-term association with Driver.
 * Car knows its Driver, but Driver has no reference back to Car.
 */
public class Car {

    private Driver driver;

    public Car(Driver driver) {
        this.driver = driver;
        System.out.println("Car assigned to driver: " + driver.getDriverName());
    }

    public void driveCar() {
        System.out.println("Car is starting...");
        driver.drive();
    }

    public Driver getDriver() {
        return driver;
    }
}
