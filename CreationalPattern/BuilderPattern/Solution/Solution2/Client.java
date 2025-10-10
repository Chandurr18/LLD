package Solution.Solution2;

public class Client {
    public static void main(String[] args) {
        House house  = new House.Builder().doors(5).windows(7).hasGarage(true).hasGarden(true).build();
        System.out.println(house);
    }
}
