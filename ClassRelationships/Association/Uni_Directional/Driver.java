package ClassRelationships.Association.Uni_Directional;

public class Driver {
    private String driverName;

    public Driver(String name){
        this.driverName = name;
    }

    public void drive(){
        System.out.println(driverName + " is driving");
    }
}
