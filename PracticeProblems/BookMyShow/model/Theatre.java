package model;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public class Theatre {
    private final String id;
    private final String name;
    private final Map<String, Screen> screens;

    public Theatre(String id, String name){
        this.id = id;
        this.name = name;
        screens = new HashMap<>();
    }

    public void addScreen(Screen screen){
       screens.put(screen.getId(), screen);
    }

    public Screen getScreen(String screenID){
        return screens.get(screenID);
    }
}
