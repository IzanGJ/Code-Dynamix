package model;

public abstract class ProductObj {
    private int code;
    private String description;
    private float price;
    private int weight;
    private String color;

    public ProductObj(int code, String description, float price, int weight, String color) {
        this.code = code;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.color = color;
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

    public void setColor(String color) {
        this.color = color;
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

    public String getColor() {
        return color;
    }
    
}