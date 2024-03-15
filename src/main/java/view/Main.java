package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import model.*;
import persistence.Persistence;


public class Main {
  public static void main(String[] args) throws IOException  {
    String menu = "************** Menú de opciones **************\n 1. Darse de Alta\n 2. Darse de baja\n 3. ¡Contacta con nosostros!\n 4. Salir\n**********************************************\n";

    Persistence persistence = new Persistence();
    HashMap<String, CompanyObj> company = persistence.readCompany();
      
    AskData askData = new AskData();
    String opcion = "";
    String name;
    String random;
    String cif;

    do {
        System.out.println(menu);
        opcion = askData.askStr("Escoge una opción:");
        switch(opcion) {
            case "1":
                name = askData.askStr("Nombre de la empresa: ");
                cif = askData.askStr("CIF:");
                if (ValidarDatos.esCifValido(cif) == true) {
                    CompanyObj companyObj = new CompanyObj(name, cif);
                    company.put(cif, companyObj);
                    persistence.writeCompany(company);
                    System.out.println("¡Empresa dada de alta correctamente!\n");
                } else {
                    System.out.println("¡El CIF introducido no es válido!\n");
                }
                break;

        case "2":
            cif = askData.askStr("CIF:");
            if (company.containsKey(cif)) {
                random = askData.askStr("¿Estás seguro que quieres dar de baja la empresa? [S/N]: ");
                if (random.equals("S") == true) {
                    company.remove(cif);
                    persistence.writeCompany(company);
                    System.out.println("¡Empresa dada de baja correctamente!\n");
                } else {
                    System.out.println("La empresa no se ha dado de baja\n");
                }

            } else {
                System.out.println("No tenemos una empresa registrada con ese nombre\n");
            }
            break;

        case "3":
          System.out.println("Teléfono: 936 542 333");
          System.out.println("Correo: contacto@codedynamix.com");
          System.out.println("Dirección: Pg. de Gràcia, 120, Gràcia, 08008 Barcelona\n\n");
          break;

        case "4":
          System.out.println("¡Hasta pronto!");
          break;

        case "33":
          for (String clave : company.keySet()) {
              System.out.println("CIF: " + clave + " | Nombre: " + company.get(clave).getNombre());
          }
            break;

        default:
          System.out.println("Opción no válida\n");
          break;
        }
    } while (opcion.equals("4") == false);}
    
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
    
}
