package CreationalPattern.Prototype.Solution;

interface EnemyPrototype extends Cloneable{
    EnemyPrototype clone();
}

public class Enemy implements EnemyPrototype {
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
    public EnemyPrototype clone(){
        return new Enemy(type, health, speed, armored, weapon);
    }

    @Override
    public String toString(){
        return type + " [Health: " + health +
                           ", Speed: " + speed +
                           ", Armored: " + armored +
                           ", Weapon: " + weapon + "]";
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
