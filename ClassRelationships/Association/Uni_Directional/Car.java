package ClassRelationships.Association.Uni_Directional;

public class Car {
    private Driver driver;

    public Car(Driver driver){
        this.driver = driver;
    }

    public void driverCar(){
        driver.drive();
    }
}
