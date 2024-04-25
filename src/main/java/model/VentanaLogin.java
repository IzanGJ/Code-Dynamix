package model;

import javax.swing.*;
import java.awt.*;

public class VentanaLogin extends JDialog {

    private JTextField campoUsuario;
    private JPasswordField campoContraseña;

    public VentanaLogin(JFrame parent) {
        super(parent, "Inicio de Sesión", true); // true para que sea modal

        // Configurar el panel principal con un GridLayout para alinear los componentes
        JPanel panelPrincipal = new JPanel(new GridLayout(0, 1, 10, 10)); // 10 de espacio horizontal y vertical entre componentes
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Margen de 20 píxeles en todos los lados

        // Configurar el color de fondo azul pastel
        panelPrincipal.setBackground(new Color(173, 216, 230));

        campoUsuario = new JTextField(20);
        campoContraseña = new JPasswordField(20);
        JButton botonIniciarSesion = new JButton("Iniciar Sesión");

        panelPrincipal.add(new JLabel("Usuario:"));
        panelPrincipal.add(campoUsuario);
        panelPrincipal.add(new JLabel("Contraseña:"));
        panelPrincipal.add(campoContraseña);
        panelPrincipal.add(botonIniciarSesion);

        // Crear un panel para colocar el mensaje
        JPanel panelMensaje = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Alinear el mensaje al centro
        panelMensaje.setBackground(new Color(173, 216, 230)); // Asegurarse de que el panel tenga el mismo color de fondo
        JLabel mensaje = new JLabel("Bienvenido al programa");
        panelMensaje.add(mensaje);

        // Agregar el panel con el mensaje encima del panel de inicio de sesión
        add(panelMensaje, BorderLayout.NORTH);
        add(panelPrincipal);

        setSize(400, 250); // Tamaño más grande
        setLocationRelativeTo(parent);

        botonIniciarSesion.addActionListener(e -> {
            String usuario = campoUsuario.getText();
            String contraseña = new String(campoContraseña.getPassword());
            // Aquí puedes validar el usuario y la contraseña
            if (usuario.equals("admin") && contraseña.equals("1234")) {
                setVisible(false);
                abrirVentanaPrincipal();
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
            }
        });
    }

    private void abrirVentanaPrincipal() {
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaLogin ventanaLogin = new VentanaLogin(null);
            ventanaLogin.setVisible(true);
        });
    }
}
