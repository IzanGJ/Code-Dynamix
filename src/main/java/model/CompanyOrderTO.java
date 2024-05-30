package model;

public class CompanyOrderTO {
    private CompanyObj comp;
    private int order;

    public CompanyOrderTO(CompanyObj comp, int order) {
        this.comp = comp;
        this.order = order;
    }

    public CompanyObj getComp() {
        return comp;
    }

    public int getOrder() {
        return order;
    }
    
}
