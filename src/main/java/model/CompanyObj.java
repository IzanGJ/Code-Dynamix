package model;

import exceptions.CompanyException;

public class CompanyObj {
    private String name;
    private String cif;
    
    public CompanyObj(String name, String cif) throws CompanyException {
        if(esCifValido(cif)) {
            this.name = name;
            this.cif = cif;
        }
    }
    
    public CompanyObj(String cif) throws CompanyException {
        if(esCifValido(cif)) {
            this.cif = cif;
        }
    }

    public String getNombre() {
        return this.name;
    }

    
    public String getCif() {
        return this.cif;
    }
    
    public boolean esCifValido(String cif) throws CompanyException {
        boolean val = true;
        if (cif != null && cif.length() == 9) {
            if (Character.isLetter(cif.charAt(0))) {
                for (int i = 1; i < 7; i++) {
                    if (!Character.isDigit(cif.charAt(i))) {
                        val = false;
                    }
                }
                if (!Character.isLetterOrDigit(cif.charAt(8))) {
                    val = false;
                }
                if(val) {
                    return true;
                }
            }
        }
        throw new CompanyException(CompanyException.WRONG_CIF);
    }
}