package model;

/**
 *
 * @author loren
 */
public class ergonomicChair extends ProductObj {
    private boolean backrest;
    private int wheels;
    private boolean armrest;

    public ergonomicChair(boolean backrest, int wheels, boolean armrest, String name, int code, String description, int weight, String color) {
        super(name, code, description, weight, color);
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
