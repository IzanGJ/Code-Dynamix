package model;

/**
 *
 * @author loren
 */
public class ergonomicTable extends ProductObj{
    private int wheels;
    private int legs;
    private boolean adjustableHeight;
    private String material;

    public ergonomicTable(int wheels, int legs, boolean adjustableHeight, String material, String name, int code, String description, float price, int weight, String color) {
        super(name, code, description, price, weight, color);
        this.wheels = wheels;
        this.legs = legs;
        this.adjustableHeight = adjustableHeight;
        this.material = material;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public void setAdjustableHeight(boolean adjustableHeight) {
        this.adjustableHeight = adjustableHeight;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getWheels() {
        return wheels;
    }

    public int getLegs() {
        return legs;
    }

    public boolean isAdjustableHeight() {
        return adjustableHeight;
    }

    public String getMaterial() {
        return material;
    }
    
    
}
