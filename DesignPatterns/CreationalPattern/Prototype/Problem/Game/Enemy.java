package CreationalPattern.Prototype.Problem.Game;

public class Enemy {
    private String type;
    private int health;
    private double speed;
    private boolean armored;
    private String weapon;
    public Enemy(String type, int health, double speed, boolean armored, String weapon){
        this.type  = type;
        this.health = health;
        this.speed = speed;
        this.armored  = armored;
        this.weapon = weapon;
    }

    @Override
    public String toString(){
        return type + " [Health: " + health +
                           ", Speed: " + speed +
                           ", Armored: " + armored +
                           ", Weapon: " + weapon + "]";
    }
}
