package model;

import exceptions.*;

public class ErgonomicChair extends ProductObj {
    private boolean backrest;
    private int wheels;
    private boolean armrest;

    public ErgonomicChair(boolean backrest, int wheels, boolean armrest, String name, int code, String description, int weight, int color) throws CompanyException{
        super(name, code, description, weight, color);
        if (wheels < 0) {
            throw new CompanyException(CompanyException.WHEELS_ERROR);
        }
        this.backrest = backrest;
        this.wheels = wheels;
        this.armrest = armrest;
    }

    public void setBackrest(boolean backrest) {
        this.backrest = backrest;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public void setArmrest(boolean armrest) {
        this.armrest = armrest;
    }

    public boolean isBackrest() {
        return backrest;
    }

    public int getWheels() {
        return wheels;
    }

    public boolean isArmrest() {
        return armrest;
    }
    
    
    
}
