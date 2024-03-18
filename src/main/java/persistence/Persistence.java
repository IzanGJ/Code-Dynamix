package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import model.*;

public class Persistence {

    private String folder;
    private String fileName;
    private String pathFile;
    private File folderFile;

    public Persistence(String nameFile) {
        folder = "data";
        fileName = nameFile;
        pathFile = folder + File.separator + fileName;
        folderFile = new File(folder);
    }

    public void writeCompany(HashMap<String, CompanyObj> c) {
        if (folderFile.exists() == false) {
            folderFile.mkdir();
        } else {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(pathFile));
                for (String clave : c.keySet()) {
                    CompanyObj valor = c.get(clave);
                    bw.write(valor.getNombre() + "|" + valor.getCif());
                    bw.newLine();
                }
                bw.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public HashMap<String, CompanyObj> readCompany() {
        HashMap<String, CompanyObj> company = new HashMap<String, CompanyObj>();
        if (folderFile.exists() == false) {
            folderFile.mkdir();
            return company;
        } else {
            File f = new File(pathFile);
            if (f.exists() == false) {
                return company;
            } else {
                try {
                    BufferedReader br = new BufferedReader(new FileReader(f));
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        String[] datos = linea.split("\\|");
                        CompanyObj companyObj = new CompanyObj(datos[0], datos[1]);
                        company.put(datos[1], companyObj);
                    }
                    br.close();
                    return company;
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return company;
    }
    

    public void writeProduct(HashMap<Integer, ProductObj> c) {
        if (folderFile.exists() == false) {
            folderFile.mkdir();
        } else {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(pathFile));
                for (int clave : c.keySet()) {
                    ProductObj valor = c.get(clave);
                    bw.write(valor.getCode() + "|" + valor.getDescription() + "|" + valor.getPrice());
                    bw.newLine();
                }
                bw.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public HashMap<Integer, ProductObj> readProduct() {
        HashMap<Integer, ProductObj> product = new HashMap<Integer, ProductObj>();
        if (folderFile.exists() == false) {
            folderFile.mkdir();
            return product;
        } else {
            File f = new File(pathFile);
            if (f.exists() == false) {
                return product;
            } else {
                try {
                    BufferedReader br = new BufferedReader(new FileReader(f));
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        String[] datos = linea.split("\\|");
                        ProductObj productObj = new ProductObj(Integer.parseInt(datos[0]), datos[1], Float.parseFloat(datos[2]));
                        product.put(Integer.parseInt(datos[0]), productObj);
                    }
                    br.close();
                    return product;
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return product;
    }
}
