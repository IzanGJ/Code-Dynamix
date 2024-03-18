package model;

public class ProductObj {
    private int code;
    private String description;
    private float price;

    public ProductObj(int code, String description, float price) {
        this.code = code;
        this.description = description;
        this.price = price;
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
    
    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }
}