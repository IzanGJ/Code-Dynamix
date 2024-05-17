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
import model.*;


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
            try {
                companies.put(cif, new CompanyObj(nom, cif));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
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
    
    
    
    
    public HashMap<Integer, ProductObj> allProducts() throws SQLException {
        Connection c = conectar();
        HashMap<Integer, ProductObj> products = new HashMap<>();
        String query = "SELECT product.*, keyboard.type AS kb_type, keyboard.language AS kb_language, keyboard.lenght AS kb_lenght, keyboard.wireless AS kb_wireless, chair.backrest AS ch_backrest, chair.	wheels AS ch_wheels, chair.armrest AS ch_armrest, mouse.handDexterity AS ms_handDexterity, mouse.lateralButtons AS ms_lateralButtons, mouse.wireless AS ms_wireless, taula.wheels AS tb_wheels, taula.legs AS tb_legs, taula.adjutableHeight AS tb_djutableHeight, taula.material AS tb_material from product\n" +
                        "JOIN keyboard ON keyboard.ID = product.ID\n" +
                        "JOIN chair ON chair.ID = product.ID\n" +
                        "JOIN mouse ON mouse.ID = product.ID\n" +
                        "JOIN taula ON taula.ID = product.ID\n" +
                        "GROUP BY product.ID;";
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("ID");
            String tipo = rs.getString("type");
            try {
                switch (tipo) {
                    case "table":
                        boolean alturaAjustable;
                        if (rs.getInt("tb_adjustableHeight") == 1) {
                            alturaAjustable = true;
                        } else {
                            alturaAjustable = false;
                        }
                        products.put(id, new ErgonomicTable(rs.getInt("tb_wheels"), rs.getInt("tb_legs"), alturaAjustable, rs.getString("tb_material"), rs.getString("name"), id, rs.getString("description"), rs.getInt("weight"), rs.getInt("color")));
                        break;
                        
                    case "chair":
                        boolean respaldo;
                        boolean reposabrazos;
                        if (rs.getInt("ch_backrest") == 1) {
                            respaldo = true;
                        } else {
                            respaldo = false;
                        }
                        
                        if (rs.getInt("ch_armrest") == 1) {
                            reposabrazos = true;
                        } else {
                            reposabrazos = false;
                        }
                        products.put(id, new ErgonomicChair(respaldo,rs.getInt("ch_wheels"),reposabrazos, rs.getString("name"), id, rs.getString("description"), rs.getInt("weight"), rs.getInt("color")));
                        break;
                    
                    case "keyboard":
                        boolean wireless;
                        if (rs.getInt("kb_wireless") == 1) {
                            wireless = true;
                        } else {
                            wireless = false;
                        }
                        products.put(id, new ErgonomicKeyboard(rs.getString("tb_type"), rs.getString("tb_language"), rs.getInt("tb_lenght"), wireless, rs.getString("name"), id, rs.getString("description"), rs.getInt("weight"), rs.getInt("color")));
                        break;
                        
                    case "mouse":
                        boolean handDexterity;
                        if (rs.getInt("ch_backrest") == 1) {
                            handDexterity = true;
                        } else {
                            handDexterity = false;
                        }
                        
                        if (rs.getInt("ch_armrest") == 1) {
                            wireless = true;
                        } else {
                            wireless = false;
                        }
                        products.put(id, new ErgonomicMouse(handDexterity, rs.getInt("ms_lateralButtons"), wireless, rs.getString("name"), id, rs.getString("description"), rs.getInt("weight"), rs.getInt("color")));
                        break;
                }
                
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        rs.close();
        st.close();
        desconectar(c);
        return products;
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
        ps.setString(7, "chair");
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