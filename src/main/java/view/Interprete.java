package view;

import exceptions.CompanyException;
import java.sql.SQLException;
import model.*;
import java.util.HashMap;
import persistence.codeDynamixDAO;

public class Interprete {
    private static Interprete instancia;
    private HashMap<String, CompanyObj> companies;
    private HashMap<String, ProductObj> order;
    codeDynamixDAO dao;
    
    public static Interprete obtenerInstancia() {
        if (instancia == null) {
            instancia = new Interprete();
        }
        return instancia;
    }
      
    public Interprete() {
        companies = new HashMap<String, CompanyObj>();
        order = new HashMap<String, ProductObj>();
        dao = new codeDynamixDAO();
    }
    
    public void registrarEmpresa(String nombre, String cif) throws CompanyException, SQLException {
        if (existCompany(cif.toUpperCase())) {
            CompanyObj obj = new CompanyObj(nombre, cif.toUpperCase());
            dao.insertCompany(obj);
        }
    }   
    
    public void modificarEmpresa(String nombre, String cif, String anterior) throws CompanyException {
        if (esCifValido(cif)) {
            if (noExistCompany(cif.toUpperCase())) {
                companies.remove(anterior);
                companies.put(cif, new CompanyObj(nombre, cif.toUpperCase()));
            }
        }
    }
     
    public void bajaEmpresa(String cif) throws CompanyException {
        if (existCompany(cif)) {
            companies.remove(cif);
        }
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
    
    
    public boolean existCompany(String cif) throws CompanyException {
        if (!companies.containsKey(cif)) {
            return true;
        }
        throw new CompanyException(CompanyException.EMPRESA_REPEAT);
    }
    
    
    public boolean noExistCompany(String cif) throws CompanyException {
        companies = getCompanies();
        if (companies.containsKey(cif)) {
            return true;
        }
        throw new CompanyException(CompanyException.EMPRESA_NOT_FOUND);
    }
         
    
    public HashMap<String, CompanyObj> getCompanies() {
        try {
            companies = dao.allCompanies();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return companies;
    }
}
