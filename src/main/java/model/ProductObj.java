package model;

import view.Interprete;
import exceptions.*;
import persistence.codeDynamixDAO;

public class ProductObj {
    private String name;
    private int code;
    private String description;
    private float price;
    private int qty;
    private int weight;
    private int color;
    
    codeDynamixDAO dao;

    public ProductObj(String name, int code, String description, int weight, int color) throws CompanyException {
        if (weight <= 0) {
            throw new CompanyException(CompanyException.WEIGHT_ERROR);
        } 
        if (code < 1){
            throw new CompanyException(CompanyException.PRODUCT_ID_ERROR);
        }
        
        this.name = name;
        this.code = code;
        this.description = description;
        this.weight = weight;
        this.color = color;
    }

    public ProductObj(int code, float price, int qty) {
        this.code = code;
        this.price = price;
        this.qty = qty;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setCode(int code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
      this.price = price;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    
    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }
    
    public int getWeight() {
        return weight;
    }

    public int getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }
    

}
