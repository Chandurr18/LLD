// Association (knows-a) is a long-term relationship where one object simply knows or references another, with both able to exist independently.
// Association → knows

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
