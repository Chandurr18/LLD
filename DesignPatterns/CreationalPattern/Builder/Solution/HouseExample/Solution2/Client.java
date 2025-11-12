package CreationalPattern.Builder.Solution.HouseExample.Solution2;

/**
 * Demonstrates modern nested static Builder style (Solution - 2).
 */
public class Client {
    public static void main(String[] args) {
        House cottage = new House.Builder()
                .garage(true)
                .garden(true)
                .floors(1)
                .roof("Wooden")
                .pool(false)
                .build();

        House mansion = new House.Builder()
                .garage(true)
                .garden(true)
                .floors(3)
                .roof("Marble Tile")
                .pool(true)
                .basement(true)
                .build();

        System.out.println(cottage);
        System.out.println(mansion);
    }
}
