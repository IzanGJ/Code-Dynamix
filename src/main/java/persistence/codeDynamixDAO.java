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
import model.ErgonomicChair;
import model.ErgonomicTable;


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
    
    
    public void insertTable(ErgonomicTable t) throws SQLException {
        Connection c = conectar();
        PreparedStatement ps = c.prepareStatement("insert into product (ID, name, description, price, weight, color, type) values (?,?,?,?,?,?,?);");
        ps.setInt(1, t.getCode());
        ps.setString(2, t.getName());
        ps.setString(3, t.getDescription());
        ps.setFloat(4, t.getPrice());
        ps.setInt(5, t.getWeight());
        ps.setString(6, String.valueOf(t.getColor()));
        ps.setString(7, "table");
        ps.executeUpdate();
        ps.close();
        
        ps = c.prepareStatement("insert into taula (ID, wheels, legs, adjutableHeight, material) values (?,?,?,?,?);");
        
        ps.setInt(1, t.getCode());
        ps.setInt(2, t.getWheels());
        ps.setInt(3, t.getLegs());
        if (t.isAdjustableHeight()) {
            ps.setInt(4, 1);
        } else {
            ps.setInt(4, 0);
        }
        ps.setString(5, t.getMaterial());
        ps.executeUpdate();
        ps.close();
        desconectar(c);
    }
    
    
    public void insertChair(ErgonomicChair ch) throws SQLException {
        Connection c = conectar();
        PreparedStatement ps = c.prepareStatement("insert into product (ID, name, description, price, weight, color, type) values (?,?,?,?,?,?,?);");
        ps.setInt(1, ch.getCode());
        ps.setString(2, ch.getName());
        ps.setString(3, ch.getDescription());
        ps.setFloat(4, ch.getPrice());
        ps.setInt(5, ch.getWeight());
        ps.setString(6, String.valueOf(ch.getColor()));
        ps.setString(7, "CHAIR");
        ps.executeUpdate();
        ps.close();
        
        ps = c.prepareStatement("insert into chair (ID, backrest, wheels, armrest) values (?,?,?,?);");
        
        ps.setInt(1, ch.getCode());
        if (ch.isBackrest()) {
            ps.setInt(2, 1);
        } else {
            ps.setInt(2, 0);
        }
        ps.setInt(3, ch.getWheels());
        if (ch.isArmrest()) {
            ps.setInt(4, 1);
        } else {
            ps.setInt(4, 0);
        }
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