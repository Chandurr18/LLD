package ClassRelationships.Association.Uni_Directional;

/**
 * Uni-directional Association:
 * Driver exists independently and does not know about Car.
 * Car references Driver, but Driver does not reference Car.
 */
public class Driver {

    private String driverName;

    public Driver(String name) {
        this.driverName = name;
        System.out.println("Driver created: " + driverName);
    }

    public String getDriverName() {
        return driverName;
    }

    public void drive() {
        System.out.println(driverName + " is driving the car...");
    }
}
