package persistence;

import exceptions.CompanyException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import model.CompanyObj;


public class codeDynamixDAO {
    
    public HashMap<String, CompanyObj> allCompanies() throws SQLException {
        Connection c = conectar();
        HashMap<String, CompanyObj> companies = new HashMap<>();
        String query = "select * from company;";
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            String cif = rs.getString("CIF");
            String nom = rs.getString("name");
            companies.put(cif, new CompanyObj(nom, cif));
        }
        rs.close();
        st.close();
        desconectar(c);
        return companies;
    }
    
    public void insertCompany(CompanyObj p) throws SQLException {
        Connection c = conectar();
        PreparedStatement ps = c.prepareStatement("insert into company values (?,?);");
        ps.setString(1, p.getCif());
        ps.setString(2, p.getNombre());
        ps.executeUpdate();
        ps.close();
        desconectar(c);
    }
    
    /*
    private boolean existCompany(String cif) throws SQLException {
        Connection c = conectar();
        Statement st = c.createStatement();
        String query = "select * from company where CIF = '" + cif + "';";
        ResultSet rs = st.executeQuery(query);
        boolean existe = false;
        if (rs.next()) {
            existe = true;
        }
        rs.close();
        st.close();
        desconectar(c);
        return existe;
        
    }
*/
    
    private Connection conectar() throws SQLException {
    String url = "jdbc:mysql://localhost:3306/erp-compras";
    String user = "root";
    String pass = "";
    Connection c = DriverManager.getConnection(url, user, pass);
    return c;
    }
    
    private void desconectar(Connection c) throws SQLException {
        c.close();
    }
}