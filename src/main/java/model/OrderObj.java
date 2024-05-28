package model;

import java.util.ArrayList;

public class OrderObj {
    private CompanyObj company;
    private ArrayList<ProductObj> products;

    public OrderObj(CompanyObj company, ArrayList<ProductObj> products) {
        this.company = company;
        this.products = products;
    }

    public CompanyObj getCompany() {
        return company;
    }

    public ArrayList<ProductObj> getProducts() {
        return products;
    }
    
    
    
    public void setProducts(ArrayList<ProductObj> products) {
        this.products = products;
    }

    public void setCompany(CompanyObj company) {
        this.company = company;
    }
}