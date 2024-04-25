package model;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        super("Ventana Principal");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        // Texto superior
        JLabel textoSuperior = new JLabel("Selecciona una opción:");
        textoSuperior.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(textoSuperior);

        // Panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 1));

        JButton botonProductos = new JButton("Productos");
        JButton botonVentas = new JButton("Ventas");
        JButton botonClientes = new JButton("Clientes");
        JButton botonInformacion = new JButton("Información del Usuario");

        // Cambiar el color de fondo de los botones a azul
        botonProductos.setBackground(new Color(0, 102, 204));
        botonVentas.setBackground(new Color(0, 102, 204));
        botonClientes.setBackground(new Color(0, 102, 204));
        botonInformacion.setBackground(new Color(0, 102, 204));

        botonProductos.setForeground(Color.WHITE);
        botonVentas.setForeground(Color.WHITE);
        botonClientes.setForeground(Color.WHITE);
        botonInformacion.setForeground(Color.WHITE);

        botonProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirProductos();
            }
        });

        botonVentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementa la lógica para la sección de ventas aquí
            }
        });

        botonClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirInformacionUsuario();
            }
        });


        panelBotones.add(botonProductos);
        panelBotones.add(botonVentas);
        panelBotones.add(botonClientes);
        panelBotones.add(botonInformacion);

        panel.add(panelBotones);

        // Agregar panel principal al JFrame
        add(panel);

    }

    private void abrirInformacionUsuario() {
        // Crear y mostrar una ventana emergente para la sección de información del usuario
        JFrame frameInformacionUsuario = new JFrame("Información del Usuario");
        frameInformacionUsuario.setSize(600, 300);
        frameInformacionUsuario.setLocationRelativeTo(null);

        JPanel panelInformacionUsuario = new JPanel();
        panelInformacionUsuario.setLayout(new GridLayout(4, 2));

        // Campos de texto para el DNI, número de teléfono y nombre
        JLabel labelDNI = new JLabel("DNI:");
        JTextField textFieldDNI = new JTextField(10);

        JLabel labelTelefono = new JLabel("Teléfono:");
        JTextField textFieldTelefono = new JTextField(10);

        JLabel labelNombre = new JLabel("Nombre:");
        JTextField textFieldNombre = new JTextField(10);

        panelInformacionUsuario.add(labelDNI);
        panelInformacionUsuario.add(textFieldDNI);

        panelInformacionUsuario.add(labelTelefono);
        panelInformacionUsuario.add(textFieldTelefono);

        panelInformacionUsuario.add(labelNombre);
        panelInformacionUsuario.add(textFieldNombre);

        JButton botonGuardar = new JButton("Guardar");
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes obtener los datos introducidos por el usuario y realizar alguna acción, como guardarlos en una base de datos
                String dni = textFieldDNI.getText();
                String telefono = textFieldTelefono.getText();
                String nombre = textFieldNombre.getText();
                // Puedes hacer lo que necesites con los datos (guardar en una base de datos, mostrar en consola, etc.)
                System.out.println("DNI: " + dni);
                System.out.println("Teléfono: " + telefono);
                System.out.println("Nombre: " + nombre);
                // Puedes cerrar la ventana después de guardar los datos
                frameInformacionUsuario.dispose();
            }
        });

        panelInformacionUsuario.add(botonGuardar);

        frameInformacionUsuario.add(panelInformacionUsuario);
        frameInformacionUsuario.setVisible(true);
    }

    private void abrirProductos() {
        // Crear y mostrar una ventana emergente para la sección de productos
        JFrame frameProductos = new JFrame("Productos");
        frameProductos.setSize(300, 200);
        frameProductos.setLocationRelativeTo(null);

        JPanel panelProductos = new JPanel();
        panelProductos.setLayout(new FlowLayout());

        // Crear JComboBox con 10 opciones
        String[] opciones = {"Ratón", "Silla", "Opción 3", "Opción 4", "Opción 5",
                "Opción 6", "Opción 7", "Opción 8", "Opción 9", "Opción 10"};
        JComboBox<String> comboBoxProductos = new JComboBox<>(opciones);

        panelProductos.add(comboBoxProductos);
        frameProductos.add(panelProductos);
        // Agregar un ActionListener para manejar la selección de productos
        comboBoxProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el producto seleccionado
                String productoSeleccionado = (String) comboBoxProductos.getSelectedItem();
                // Aquí puedes realizar la acción deseada con el producto seleccionado, como mostrar información o realizar alguna operación
                System.out.println("Producto seleccionado: " + productoSeleccionado);
            }
        });

        frameProductos.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
            ventanaPrincipal.setVisible(true);
        });
    }
}

class VentanaVentas extends JFrame {

        public VentanaVentas() {
            super("Ventas");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(400, 300);
            setLocationRelativeTo(null);


            // Datos de ejemplo para los productos
            String[] columnas = {"Producto", "Comprados", "Restantes"};
            Object[][] datos = {
                    {"Producto 1", 5, 15},
                    {"Producto 2", 8, 12},
                    {"Producto 3", 3, 17},
                    {"Producto 4", 10, 10},
                    {"Producto 5", 2, 18}
            };

            // Modelo de tabla con los datos de los productos
            DefaultTableModel modelo = new DefaultTableModel(datos, columnas);

            // Crear tabla con el modelo
            JTable tabla = new JTable(modelo);

            // Centrar contenido de las celdas
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            tabla.setDefaultRenderer(Object.class, centerRenderer);

            // Agregar la tabla a un JScrollPane y añadirlo al JFrame
            JScrollPane scrollPane = new JScrollPane(tabla);
            add(scrollPane, BorderLayout.CENTER);

            JPanel panel = new JPanel(new BorderLayout());

            // Crear botón de ventas
            JButton ventasButton = new JButton("Ventas");

            // Agregar ActionListener al botón de ventas
            ventasButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // No es necesario crear una nueva instancia de VentanaVentas aquí
                    // Simplemente haz que la ventana de ventas sea visible
                    setVisible(true);
                }
            });

            // Agregar el botón de ventas al panel
            panel.add(ventasButton, BorderLayout.CENTER);

            // Agregar el panel a la ventana principal
            add(panel);

        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                VentanaVentas ventanaVentas = new VentanaVentas();
                ventanaVentas.setVisible(true);
            });
        }
    }

