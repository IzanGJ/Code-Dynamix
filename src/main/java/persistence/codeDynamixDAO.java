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
    
    public HashMap<String, CompanyObj> allCompanies() throws SQLException, CompanyException {
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
    
    public void insertCompany(CompanyObj comp) throws SQLException, CompanyException {
        if (existCompany(comp.getCif())) {
            throw new CompanyException(CompanyException.EMPRESA_REPEAT);
        }
        Connection c = conectar();
        PreparedStatement ps = c.prepareStatement("insert into company values (?,?);");
        ps.setString(1, comp.getCif());
        ps.setString(2, comp.getNombre());
        ps.executeUpdate();
        ps.close();
        desconectar(c);
    }
    
    public void remCompany(CompanyObj comp) throws SQLException, CompanyException {
        if (!existCompany(comp.getCif())) {
            throw new CompanyException(CompanyException.EMPRESA_NOT_FOUND);
        }
        if(companyOrder(comp.getCif())) {
            throw new CompanyException(CompanyException.COMPANY_RECEIPT);
        }
        Connection c = conectar();
        PreparedStatement ps = c.prepareStatement("DELETE FROM company WHERE CIF = '" + comp.getCif() + "';");
        ps.executeUpdate();
        ps.close();
        desconectar(c);
    }
    
    public void updateCompany(String cif, String name) throws SQLException, CompanyException {
        if (!existCompany(cif)) {
            throw new CompanyException(CompanyException.EMPRESA_NOT_FOUND);
        }
        Connection c = conectar();
        PreparedStatement ps = c.prepareStatement("update company set name = '" + name + "' WHERE CIF = '" + cif + "';");
        ps.executeUpdate();
        ps.close();
        desconectar(c);
    }
    
    public HashMap<Integer, OrderObj> getCompanyReceipt(CompanyObj comp) throws SQLException, CompanyException {
        Connection c = conectar();
        Statement st = c.createStatement();
        String query = "SELECT b.delivery_ID, c.prod_ID, c.quantity, c.price FROM company AS a JOIN delivery_note AS b ON a.CIF = b.company_ID JOIN delivery_note_prod AS c ON b.delivery_ID = c.delivery_ID WHERE a.CIF = '" + comp.getCif() + "';";
        ResultSet rs = st.executeQuery(query);
        HashMap<Integer, OrderObj> receipt = new HashMap<>();
        ArrayList<ProductObj> productes = new ArrayList<>();
        int placeHolder = 0;
        while (rs.next()) {
            int del_id = rs.getInt("delivery_ID");
            int prod_id = rs.getInt("prod_ID");
            Float price = rs.getFloat("price");
            int qty = rs.getInt("quantity");
            if(placeHolder == 0) {
               placeHolder = del_id;
            }
            productes.add(new ProductObj(prod_id, price, qty));
            if(del_id != placeHolder) {
                receipt.put(placeHolder, new OrderObj(productes));
                productes.clear();
                placeHolder = del_id;
            } else if(rs.isLast()) {
                receipt.put(del_id, new OrderObj(productes));
            }
        }
        rs.close();
        st.close();
        desconectar(c);
        return receipt;
    }
    
    public HashMap<Integer, ProductObj> allProducts() throws SQLException {
        Connection c = conectar();
        HashMap<Integer, ProductObj> products = new HashMap<>();
        String query = "SELECT product.*, keyboard.type AS kb_type, keyboard.language AS kb_language, keyboard.lenght AS kb_lenght, keyboard.wireless AS kb_wireless, chair.backrest AS ch_backrest, chair.wheels AS ch_wheels, chair.armrest AS ch_armrest, mouse.handDexterity AS ms_handDexterity, mouse.lateralButtons AS ms_lateralButtons, mouse.wireless AS ms_wireless, taula.wheels AS tb_wheels, taula.legs AS tb_legs, taula.adjutableHeight AS tb_adjustableHeight, taula.material AS tb_material from product\n" +
                        " LEFT JOIN keyboard ON keyboard.ID = product.ID" +
                        " LEFT JOIN chair ON chair.ID = product.ID" +
                        " LEFT JOIN mouse ON mouse.ID = product.ID" +
                        " LEFT JOIN taula ON taula.ID = product.ID" +
                        " GROUP BY product.ID;";
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
                        products.put(id, new ErgonomicKeyboard(rs.getString("kb_type"), rs.getString("kb_language"), rs.getInt("kb_lenght"), wireless, rs.getString("name"), id, rs.getString("description"), rs.getInt("weight"), rs.getInt("color")));
                        break;
                        
                    case "mouse":
                        boolean handDexterity;
                        if (rs.getInt("ms_handDexterity") == 1) {
                            handDexterity = true;
                        } else {
                            handDexterity = false;
                        }
                        
                        if (rs.getInt("ms_wireless") == 1) {
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
    
    public void insertProduct(ProductObj pr, String type) throws SQLException, CompanyException {
        if (existProduct(pr.getCode())) {
            throw new CompanyException(CompanyException.PRODUCT_REPEAT);
        }
        Connection c = conectar();
        PreparedStatement ps = c.prepareStatement("insert into product (ID, name, description, weight, color, type) values (?,?,?,?,?,?);");
        ps.setInt(1, pr.getCode());
        ps.setString(2, pr.getName());
        ps.setString(3, pr.getDescription());
        ps.setInt(4, pr.getWeight());
        ps.setString(5, String.valueOf(pr.getColor()));
        ps.setString(6, type);
        ps.executeUpdate();
        ps.close();
        desconectar(c);
    }
    
    public void insertTable(ErgonomicTable t) throws SQLException, CompanyException {
        insertProduct(t, "table");
        Connection c = conectar();
        PreparedStatement ps = c.prepareStatement("insert into taula (ID, wheels, legs, adjutableHeight, material) values (?,?,?,?,?);");
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
    
    public void insertChair(ErgonomicChair ch) throws SQLException, CompanyException {
        insertProduct(ch, "chair");
        Connection c = conectar();
        PreparedStatement ps = c.prepareStatement("insert into chair (ID, backrest, wheels, armrest) values (?,?,?,?);");
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
    
    public void insertKeyboard(ErgonomicKeyboard ky) throws SQLException, CompanyException {
        insertProduct(ky, "keyboard");
        Connection c = conectar();
        PreparedStatement ps =  c.prepareStatement("insert into keyboard (ID, type, language, lenght, wireless) values (?,?,?,?,?);");  
        ps.setInt(1, ky.getCode());
        ps.setString(2, ky.getType());
        ps.setString(3, ky.getLanguage());
        ps.setInt(4, ky.getLenght());
        if (ky.isWireless()) {
            ps.setInt(5, 1);
        } else {
            ps.setInt(5, 0);
        }
        ps.executeUpdate();
        ps.close();
        desconectar(c);
    }
    
    public void insertMouse(ErgonomicMouse ms) throws SQLException, CompanyException {
        insertProduct(ms, "mouse");
        Connection c = conectar();
        PreparedStatement ps = c.prepareStatement("insert into mouse (ID, handDexterity, lateralButtons, wireless) values (?,?,?,?);");
        ps.setInt(1, ms.getCode());
        if (ms.isHandDexterity()) {
            ps.setInt(2, 1);
        } else {
            ps.setInt(2, 0);
        }
        ps.setInt(3, ms.getLateralButtons());
        if (ms.isWireless()) {
            ps.setInt(4, 1);
        } else {
            ps.setInt(4, 0);
        }
        ps.executeUpdate();
        ps.close();
        desconectar(c);
    }
       
    public void remProduct(ProductObj product) throws SQLException, CompanyException {
        if (!existProduct(product.getCode())) {
            throw new CompanyException(CompanyException.PRODUCT_NOT_FOUND);
        }
        if(productOrder(product.getCode())) {
            throw new CompanyException(CompanyException.PRODUCT_RECEIPT);
        }
        Connection c = conectar();
        PreparedStatement ps = c.prepareStatement("DELETE FROM product WHERE ID = " + product.getCode() + ";");
        ps.executeUpdate();
        ps.close();
        desconectar(c);
    }
    
    public void insertOrder(OrderObj order) throws SQLException, CompanyException {
        Connection c = conectar();
        PreparedStatement ps = c.prepareStatement("INSERT INTO delivery_note VALUES(null, '" + order.getCompany().getCif() + "');");
        ps.executeUpdate();
        ps.close();
        int col = getOrderNum();
        for(ProductObj product : order.getProducts()) {
            ps = c.prepareStatement("INSERT INTO delivery_note_prod VALUES("+col+", " + product.getCode() + ", "+ product.getQty() + ", "+ product.getPrice() + ");");
            ps.executeUpdate();
            ps.close();
        }
        desconectar(c);
    }
      
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
    
    private boolean companyOrder(String cif) throws SQLException {
        Connection c = conectar();
        Statement st = c.createStatement();
        String query = "select * from company AS a JOIN delivery_note AS b ON a.CIF = b.company_ID where a.CIF = '" + cif + "';";
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
    
    private boolean existProduct(int code) throws SQLException {
        Connection c = conectar();
        Statement st = c.createStatement();
        String query = "select * from product where ID = '" + code + "';";
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
    
    private boolean productOrder(int code) throws SQLException {
        Connection c = conectar();
        Statement st = c.createStatement();
        String query = "select * from product AS a JOIN delivery_note_prod AS b ON a.ID = b.prod_ID where a.ID = " + code + ";";
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
    
    private int getOrderNum() throws SQLException {
        Connection c = conectar();
        Statement st = c.createStatement();
        String query = "select COUNT(*) from delivery_note;";
        ResultSet rs = st.executeQuery(query);
        int col = 0;
        rs.next();
        col = rs.getInt("COUNT(*)");
        rs.close();
        st.close();
        desconectar(c);
        return col;  
    }
    
    public CompanyOrderTO getCompanyOrder(CompanyObj comp) throws SQLException {
        Connection c = conectar();
        String query = "SELECT COUNT(*) FROM company AS a JOIN delivery_note AS b ON a.CIF = b.company_ID WHERE a.cif = '" + comp.getCif() + "';";
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        CompanyOrderTO obj = new CompanyOrderTO(comp, rs.getInt("COUNT(*)"));
        rs.close();
        st.close();
        desconectar(c);
        return obj;
    }

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