/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author loren
 */
public class ergonomicKeyboard extends ProductObj{
    private String type;
    private String language;
    private int lenght;
    private boolean wireless;

    public ergonomicKeyboard(String type, String language, int lenght, boolean wireless, int code, String description, float price, int weight, String color) {
        super(code, description, price, weight, color);
        this.type = type;
        this.language = language;
        this.lenght = lenght;
        this.wireless = wireless;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public void setWireless(boolean wireless) {
        this.wireless = wireless;
    }

    public String getType() {
        return type;
    }

    public String getLanguage() {
        return language;
    }

    public int getLenght() {
        return lenght;
    }

    public boolean isWireless() {
        return wireless;
    }
    
    
}
