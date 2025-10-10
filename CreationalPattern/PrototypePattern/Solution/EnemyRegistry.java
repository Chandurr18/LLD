package CreationalPattern.PrototypePattern.Solution;

import java.util.HashMap;

public class EnemyRegistry {
    HashMap<String, Enemy> prototypes = new HashMap<>();
     
    public void register(String key, Enemy enemy){
        prototypes.put(key, enemy);
    }

    public Enemy get(String key){
        Enemy prototype = prototypes.get(key);
        if(prototype != null) return (Enemy) prototype.clone();

        throw new IllegalArgumentException("No prototype found with " + key);
    }
}
