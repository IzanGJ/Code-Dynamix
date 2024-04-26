package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import model.*;
import persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        String menuMain = "************* Menú d'Opcions *************\n 1. Companyies\n 2. Productes\n 3. Rebuts\n 4. Contacta amb nosaltres!\n 5. Sortir\n******************************************\n";
        String menuCompany = "************* Menú de Companyies *************\n 1. Donar d'alta\n 2. Donar de baixa\n 3. Modificar empresa\n 4. Tornar\n**********************************************\n";
        String menuProducts = "************* Menú de Productes *************\n 1. Registrar producte\n 2. Esborrar producte\n 3. Modificar producte\n 4. Tornar\n*********************************************\n";

          
        Persistence persistenceCompany = new Persistence("company.txt");
        Persistence persistenceProduct = new Persistence("products.txt");
        HashMap<String, CompanyObj> company = persistenceCompany.readCompany();
        HashMap<Integer, ProductObj> product = persistenceProduct.readProduct();
          
        AskData askData = new AskData();
        String opcion = "";
        String name;
        String code;
        String random;
        String price;
    
        do {
            System.out.println(menuMain);
            opcion = askData.askStr("Escull una opció:");
            switch(opcion) {
            case "1":
                do {
                    System.out.println(menuCompany);
                    opcion = askData.askStr("Escull una opció:");
                    switch(opcion) {
                        case "1":
                          name = askData.askStr("Nom de l'empresa:");
                          code = askData.askStr("CIF:");
                          if (ValidarDatos.esCifValido(code) == true) {
                              if (company.containsKey(code) == false){
                                  CompanyObj companyObj = new CompanyObj(name, code);
                                  company.put(code, companyObj);
                                  persistenceCompany.writeCompany(company);
                                  System.out.println("¡Empresa donada d'alta correctament!\n");
                              } else{
                                  System.out.println("Ja existeix una empresa amb aquest CIF\n");
                              }
                          } else {
                              System.out.println("El CIF introduït no és vàlid!\n");
                          }
                          break;
    
                        case "2":
                            code = askData.askStr("CIF:");
                            if (company.containsKey(code)) {
                                random = askData.askStr("¿Estàs segur que vols donar de baixa l'empresa? [S/N]:");
                                if (random.equals("S") == true) {
                                    company.remove(code);
                                    persistenceCompany.writeCompany(company);
                                    System.out.println("¡Empresa donada de baixa correctament!\n");
                                } else {
                                    System.out.println("La empresa no s'ha donat de baixa\n");
                                }
    
                            } else {
                                System.out.println("No tenim una empresa registrada amb aquest CIF\n");
                            }
                            break;
    
                        case "3":
                            code = askData.askStr("CIF:");
                            if (company.containsKey(code)) {
                                name = askData.askStr("Escribe el nuevo nombre para la empresa:");
                                CompanyObj companyObj = new CompanyObj(name, code);
                                company.put(code, companyObj);
                                persistenceCompany.writeCompany(company);
                                System.out.println("¡Empresa modificada correctament!\n");
                            } else {
                                System.out.println("No tenim una empresa registrada amb aquest CIF\n");
                            }
                            break;
    
                        case "4":
                            break;
    
                        // Caso de prueba para nosotros
                        case "33":
                            for (String clave : company.keySet()) {
                                System.out.println("Code: " + clave + " | Nom: " + company.get(clave).getNombre());
                            }
                            break;
    
                            default:
                                System.out.println("Opció no vàlida\n");
                                break;
                        }
                    } while (opcion.equals("4") == false);
                    break;

            case "2":
                do {
                    System.out.println(menuProducts);
                    opcion = askData.askStr("Escull una opció:");
                    switch(opcion) {
                    case "1":
                        code = askData.askStr("Codi del producte:");
                        random = askData.askStr("Descricpió del producte:");
                        price = askData.askStr("Preu del producte:");
                        if (product.containsKey(code) == false){
                            ProductObj productObj = new ProductObj(Integer.parseInt(code), random, Float.parseFloat(price));
                            product.put(Integer.parseInt(code), productObj);
                            persistenceProduct.writeProduct(product);
                            System.out.println("Producte donat d'alta correctament!\n");
                        } else {
                            System.out.println("Ja existeix un producte amb aquest codi");
                        }
                        break;

                      case "2":
                        code = askData.askStr("Codi del producte a esborrar:");
                        if (product.containsKey(Integer.parseInt(code))) {
                            random = askData.askStr("Estàs segur que vols esborrar el producte? [S/N]:");
                            if (random.equals("S") == true) {
                                product.remove(code);
                                persistenceProduct.writeProduct(product);
                                System.out.println("El producte s'ha esborrat correctament!\n");
                            } else {
                                System.out.println("El producte no s'ha esborrat\n");
                            }

                        } else {
                            System.out.println("No tenim un producte registrat amb aquest codi\n");
                        }
                        break;
                      case "3":
                        code = askData.askStr("Codi del producte a modificar:");
                        
                          
                    // Caso de prueba para nosotros
                    case "33":
                        for (int clave : product.keySet()) {
                            System.out.println("Code: " + clave + " | Price: " + product.get(clave).getPrice() + " | Description: " + product.get(clave).getDescription());
                        }
                        break;

                    default:
                        System.out.println("Opció no vàlida\n");
                        break;
                    }
                } while (opcion.equals("4") == false);

            case "4":
              System.out.println("Teléfono: 936 542 333");
              System.out.println("Correo: contacto@codedynamix.com");
              System.out.println("Dirección: Pg. de Gràcia, 120, Gràcia, 08008 Barcelona\n\n");
              break;
    
            default:
                System.out.println("Opció no vàlida\n");
                break;
            }
        } while (opcion.equals("5") == false);
    }
}
