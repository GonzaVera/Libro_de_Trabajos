import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import Database.DatabaseConnection;

public class AgregarCliente {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton agregarButton;
    private JButton cancelarButton;
    private JPanel panelAgregar;
    private JTextField textField5;
    private JTextField textField6;

    private DatabaseConnection dbConnection;
    private OperacionesDB dbOperaciones;

    public AgregarCliente() {
        dbConnection = new DatabaseConnection();
        dbOperaciones = new OperacionesDB(dbConnection.getConnection());

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //declaro las variables que voy a usar

                String nombre, apellido, telefono, direccion, descripcion, dni;

                nombre = textField1.getText();
                apellido = textField2.getText();
                telefono = textField3.getText();
                direccion = textField4.getText();
                descripcion = textField5.getText();
                dni = textField6.getText();
            //este if lo que hace es validar que el campo dni no supere los 8 digitos si lo hace salta un MessageDialog marcando el error (dentro del try este if no funciona)

                if (dni.length() != 8 || !dni.matches("\\d{8}")) {
                    JOptionPane.showMessageDialog(null, "El DNI no es válido. Debe contener exactamente 8 dígitos.");
                } else {

                    try {
                        dbOperaciones.insertNombre(nombre);
                        dbOperaciones.insertApellido(apellido);
                        dbOperaciones.insertTelefono(telefono);
                        dbOperaciones.insertDireccion(direccion);
                        dbOperaciones.insertDescripcion(descripcion);
                        dbOperaciones.insertDNI(dni);

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panelAgregar);
                frame.dispose();
            }
        });
    }

    public void setVisible(boolean b) {
        JFrame frame = new JFrame("Administrable");
        frame.setContentPane(new AgregarCliente().panelAgregar);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

