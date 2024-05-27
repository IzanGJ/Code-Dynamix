package view;

import exceptions.CompanyException;
import java.sql.SQLException;
import model.*;
import java.util.HashMap;
import persistence.codeDynamixDAO;

public class Interprete {
    private static Interprete instancia;
    codeDynamixDAO dao;
    
    public static Interprete obtenerInstancia() {
        if (instancia == null) {
            instancia = new Interprete();
        }
        return instancia;
    }
      
    public Interprete() {
        dao = new codeDynamixDAO();
    }
    
    public void registrarEmpresa(String nombre, String cif) throws CompanyException, SQLException {
        CompanyObj obj = new CompanyObj(nombre, cif.toUpperCase());
        dao.insertCompany(obj);
    }
     
    public void bajaEmpresa(String cif) throws CompanyException, SQLException {
        CompanyObj obj = new CompanyObj(cif.toUpperCase());
        dao.remCompany(obj);
        }
}
