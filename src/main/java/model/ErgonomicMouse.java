package model;

import exceptions.CompanyException;

/**
 *
 * @author loren
 */
public class ErgonomicMouse extends ProductObj {
    private boolean handDexterity;
    private int lateralButtons;
    private boolean wireless;

    public ErgonomicMouse(boolean handDexterity, int lateralButtons, boolean wireless, String name, int code, String description, int weight, int color) throws CompanyException {
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
