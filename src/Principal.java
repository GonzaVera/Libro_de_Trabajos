import Database.DatabaseConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Principal {
    private JPanel panelPrincipal;
    private JButton agregarButton;
    private JButton eliminarButton;
    private JTable table1;
    private JButton buscarButton;
    private JTextField textField1;
    private Connection connection;
    private DefaultTableModel tableModel;
    private BuscarCliente buscarCliente;

    public Principal() {
        DatabaseConnection dbConnection = new DatabaseConnection();
        connection = dbConnection.getConnection();

        String[] columnNames = {"Nombre", "Apellido", "DNI", "Descripción", "Dirección", "Teléfono"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table1.setModel(tableModel);
        buscarCliente = new BuscarCliente(connection);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarCliente AC = new AgregarCliente();
                AC.setVisible(true);
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreABuscar = textField1.getText();
                buscarClientes(nombreABuscar);
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperacionesDB operacionesDB = new OperacionesDB(connection);
                int selectedRow = table1.getSelectedRow();
                if (selectedRow != -1 && tableModel.getRowCount() > selectedRow) {
                    String dni = (String) tableModel.getValueAt(selectedRow, 2);

                    operacionesDB.eliminarClientePorDNI(dni);

                    operacionesDB.closeConnection();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para eliminar.");
                }
            }
        });
    }

    private void buscarClientes(String nombreABuscar) {
        try {
            String query = "SELECT nombre, apellido, DNI, descripcion, direccion, telefono FROM cliente WHERE nombre LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + nombreABuscar + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            tableModel.setRowCount(0);  // Limpia el modelo de la tabla

            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String dni = resultSet.getString("DNI");
                String descripcion = resultSet.getString("descripcion");
                String direccion = resultSet.getString("direccion");
                String telefono = resultSet.getString("telefono");
                tableModel.addRow(new Object[]{nombre, apellido, dni, descripcion, direccion, telefono
                });
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Principal");
        frame.setContentPane(new Principal().panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
