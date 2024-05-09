package view;

import exceptions.CompanyException;
import model.*;
import java.util.HashMap;

public class Interprete {
    private static Interprete instancia;
    private static ValidarDatos validador;
    private HashMap<String, CompanyObj> companies;
    private HashMap<Integer, ProductObj> products;
    
    public static Interprete obtenerInstancia() {
        if (instancia == null) {
            instancia = new Interprete();
        }
        return instancia;
    }
    
    
    public Interprete() {
        companies = new HashMap<String, CompanyObj>();
        products = new HashMap<Integer, ProductObj>();
        validador = new ValidarDatos();
    }
    
    
    public boolean registrarEmpresa(String nombre, String cif) throws CompanyException {
        if (!nombre.equals("")) {
            if (!cif.equals("")) {
                if (!companies.containsKey(cif.toUpperCase())) {
                    if (validador.esCifValido(cif)) {
                        companies.put(cif, new CompanyObj(nombre, cif.toUpperCase()));
                        return true;
                    } else {
                        throw new CompanyException(CompanyException.WRONG_CIF);
                    }
                } else {
                    throw new CompanyException(CompanyException.EMPRESA_REPEAT);
                }
            } else {
                throw new CompanyException(CompanyException.CIF_EMPTY);
            }
        } else {
            throw new CompanyException(CompanyException.NAME_EMPTY);
        }
    }
    
    
    public boolean modificarEmpresa(String nombre, String cif, String anterior) throws CompanyException {
        if (!nombre.equals("")) {
            if (!cif.equals("")) {
                if (validador.esCifValido(cif)) {
                    companies.remove(anterior);
                    if (!companies.containsKey(cif.toUpperCase())) {
                        companies.put(cif, new CompanyObj(nombre, cif.toUpperCase()));
                        return true;
                    } else {
                        throw new CompanyException(CompanyException.EMPRESA_REPEAT);
                    }
                } else {
                    throw new CompanyException(CompanyException.WRONG_CIF);
                }
            } else {
                throw new CompanyException(CompanyException.CIF_EMPTY);
            }
        } else {
            throw new CompanyException(CompanyException.NAME_EMPTY);
        }
    }
    
    
    public boolean bajaEmpresa(String cif) throws CompanyException {
        if (companies.containsKey(cif.toUpperCase())) {
            if (validador.esCifValido(cif)) {
                companies.remove(cif);
                return true;
            }
        } else {
            throw new CompanyException(CompanyException.EMPRESA_NOT_FOUND);
        }
        return true;
    }

    public HashMap<String, CompanyObj> getCompanies() {
        return companies;
    }

}

