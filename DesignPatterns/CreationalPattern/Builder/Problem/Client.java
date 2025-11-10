package CreationalPattern.Builder.Problem;

public class Client {
    public static void main(String[] args) {
        House house1 = new House(4, 10, true, false, true);
        House house2 = new House(2, 4, false, false, false);

        System.out.println("House1 :" + house1);
        System.out.println("House2 :" + house2);
    }
}
