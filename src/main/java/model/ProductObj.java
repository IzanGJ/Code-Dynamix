package model;

public abstract class ProductObj {
    private String name;
    private int code;
    private String description;
    private float price;
    private int weight;
    private String color;

    public ProductObj(String name, int code, String description, int weight, String color) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.weight = weight;
        this.color = color;
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
