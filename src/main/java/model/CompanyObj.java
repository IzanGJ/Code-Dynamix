package model;

import exceptions.CompanyException;
import view.Interprete;

public class CompanyObj {
    private String name;
    private String cif;
    private Interprete interprete = new Interprete();

public CompanyObj(String name, String cif) throws CompanyException {
        try {
            interprete.esCifValido(cif);
        } catch (Exception ex) {
            throw ex;
        }
        
            
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