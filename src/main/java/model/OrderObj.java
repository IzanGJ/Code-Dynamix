package model;

public class OrderObj {
    private ProductObj product;
    private CompanyObj company;
    private int amount;

    public OrderObj(ProductObj product, CompanyObj company, int amount) {
        this.product = product;
        this.company = company;
        this.amount = amount;
    }

  
    public void setProduct(ProductObj product) {
        this.product = product;
    }

    public void setCompany(CompanyObj company) {
        this.company = company;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}