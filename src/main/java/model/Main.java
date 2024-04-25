package model;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            VentanaLogin ventanaLogin = new VentanaLogin(frame);
            ventanaLogin.setVisible(true);
        });
    }
}