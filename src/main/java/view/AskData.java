package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AskData {

    private BufferedReader br;

    public AskData() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public int askInt(String message) {
        System.out.println(message);
        int number = 0;
        boolean error = true;
        while (error) {
            try {
                number = Integer.parseInt(br.readLine());
                error = false;
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } catch (NumberFormatException ex) {
                System.out.println("Error: Debes introducir un número entero");
            }
        }
        return number;
    }
    public String askStr(String message) {
        System.out.print(message + " ");
        String str = "";
        boolean error = true;
        while (error == true) {
            try {
                str = br.readLine();
                error = false;
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return str;
    }
    
}