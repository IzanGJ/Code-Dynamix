package com.mycompany.codedynamix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
         String menu = "**************** Menú de opciones ****************\n 1. Darse de Alta\n 2. Darse de baja\n 3. Contacto \n 4. Salir\n**************************************************\n";

    String opcion = "";
    String empresa = "";
    String cif = "";
    String direccion = "";
    String telf = "";
    String email = "";

    System.out.println(menu);

    while (opcion != "4") {
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      System.out.print("Elige una opción: ");
      opcion = input.readLine();
      switch(opcion) {
        case "1":
          System.out.print("Empresa: ");
          empresa = input.readLine();
          System.out.print("CIF: ");
          cif = input.readLine();
          System.out.print("Dirección: ");
          direccion = input.readLine();
          System.out.print("Teléfono: ");
          telf = input.readLine();
          while(telf.length() != 9) {
            System.out.print("Teléfono: ");
            telf = input.readLine();}
          System.out.print("Email: ");
          email = input.readLine();
          System.out.println("¡Te has registrado con éxito!");
          break;
          
        case "2":
          System.out.println("¡Te has dado de baja con éxito!");
          break;
          
        case "3":
          System.out.println("*contacto*");
          break;
          
        case "4":
          System.out.println("¡Hasta pronto!");
          break;
          
        default:
          System.out.println("Opción no válida");
          break;
      }
    }
    }
    
}
