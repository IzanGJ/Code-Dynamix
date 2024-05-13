package model;

/**
 *
 * @author loren
 */
public class ergonomicMouse extends ProductObj {
    private boolean handDexterity;
    private int lateralButtons;
    private boolean wireless;

    public ergonomicMouse(boolean handDexterity, int lateralButtons, boolean wireless, String name, int code, String description, int weight, String color) {
        super(name, code, description, weight, color);
        this.handDexterity = handDexterity;
        this.lateralButtons = lateralButtons;
        this.wireless = wireless;
    }

    public void setHandDexterity(boolean handDexterity) {
        this.handDexterity = handDexterity;
    }

    public void setLateralButtons(int lateralButtons) {
        this.lateralButtons = lateralButtons;
    }

    public void setWireless(boolean wireless) {
        this.wireless = wireless;
    }

    public boolean isHandDexterity() {
        return handDexterity;
    }

    public int getLateralButtons() {
        return lateralButtons;
    }

    public boolean isWireless() {
        return wireless;
    }
    
    
    
}
