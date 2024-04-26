/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author loren
 */
public class ComprasExceptions extends Exception {
    
    private static final int EMPRESA_REPEAT = 0;
    private static final int NEGATIVE_NUM = 1;
    private static final int PRODUCT_REPEAT = 2;
    private static final int EMPRESAS_NOT_FOUND= 3;
    private static final int PRODUCT_NOT_FOUND= 4;
    
    private final List<String> missatges = Arrays.asList(
            "< ERROR 001: Empresa ja registrada >",
            "< ERROR 002: Número fora de rang>",
            "< ERROR 003: Ja existeix un producte amb aquest nom >",
            "< ERROR 004: No hi han empreses registrades>",
            "< ERROR 005: No hi han productes regitrats>"
            );
     private final int code;
     
     public ComprasExceptions (int code) {
         this.code = code;
     } 
    
     @Override
     public String getMessage() {
         return missatges.get(code);
     }  
    
}
