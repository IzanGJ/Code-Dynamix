package model;

public class CompanyObj {
    private String name;
    private String cif;

public CompanyObj(String name, String cif) {
        this.name = name;
        this.cif = cif;
    }  

    public void setNombre(String name) {
        this.name = name;
    }

    public void setCif(String cif) {
      this.cif = cif;
    }

    public String getNombre() {
        return this.name;
    }

    
    public String getCif() {
        return this.cif;
    }
}