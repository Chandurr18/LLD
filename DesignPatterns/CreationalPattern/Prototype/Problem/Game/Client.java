package CreationalPattern.Prototype.Problem.Game;

import CreationalPattern.Prototype.Solution.Game.Enemy;

public class Client {
    public static void main(String[] args) {
        Enemy e1 = new Enemy("Flying", 20, 100, true, "laser");
        Enemy e2 = new Enemy("Flying", 20, 100, true, "laser");
        Enemy e3 = new Enemy("Armored", 100, 20, true, "cannon");

        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
    }
}
