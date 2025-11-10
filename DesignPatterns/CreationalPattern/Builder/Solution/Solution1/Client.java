package CreationalPattern.Builder.Solution.Solution1;

public class Client {
    public static void main(String[] args) {
        // Create builder
        HouseBuilder builder = new ConcreteHouseBuilder();

        // Use Director
        HouseDirector director = new HouseDirector(builder);
        House luxuryHouse = director.constructLuxuryHouse();
        System.out.println("Luxury: " + luxuryHouse);

        // Or build manually (fluent)
        House customHouse = builder
                .setDoors(3)
                .setWindows(5)
                .setGarage(true)
                .setGarden(false)
                .build();
        System.out.println("Custom: " + customHouse);
    }

}
