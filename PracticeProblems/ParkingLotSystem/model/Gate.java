package model;

import enums.GateType;

public abstract class Gate {
    protected final String id;

    public Gate(String id){
        this.id = id;
    }

    public abstract GateType getType();

    public String getId(){
        return this.id;
    }

}
