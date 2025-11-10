package CreationalPattern.Prototype.Solution;

public class Client {
    public static void main(String[] args) {
        EnemyRegistry registry = new EnemyRegistry();

        // Register prototype enemies
        registry.register("Flying", new Enemy("Flying", 20, 100, false, null));
        registry.register("Armored", new Enemy("Armored", 100, 20, true, "cannon"));

        // Clone from registry
        Enemy e1 = registry.get("Flying");
        Enemy e2 = registry.get("Flying");
        Enemy e3 = registry.get("Armored");
        Enemy e4 = registry.get("Armored");

        // Maybe this one was spawned with less HP, so set health to 50
        e4.setHealth(50);

        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
        System.out.println(e4);
    }
}
