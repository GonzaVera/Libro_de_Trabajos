import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OperacionesDB {
    private Connection connection;

    public OperacionesDB(Connection connection) {
        this.connection = connection;
    }


    public void insertCliente(String nombre, String apellido, String telefono, String direccion, String descripcion, String dni) throws SQLException {
        String insertClienteQuery = "INSERT INTO cliente (nombre, apellido, telefono, direccion, descripcion, DNI) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement insertClienteStatement = connection.prepareStatement(insertClienteQuery)) {
            insertClienteStatement.setString(1, nombre);
            insertClienteStatement.setString(2, apellido);
            insertClienteStatement.setString(3, telefono);
            insertClienteStatement.setString(4, direccion);
            insertClienteStatement.setString(5, descripcion);
            insertClienteStatement.setString(6, dni);
            insertClienteStatement.executeUpdate();
        }
    }

    public void eliminarClientePorDNI(String dni) {
        try {
            String deleteQuery = "DELETE FROM cliente WHERE DNI = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, dni);
            int rowCount = preparedStatement.executeUpdate();

            if (rowCount > 0) {
                System.out.println("Cliente con DNI " + dni + " eliminado de la base de datos.");
            } else {
                System.out.println("No se encontró ningún cliente con el DNI " + dni + " en la base de datos.");
            }

            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



    public void closeConnection() {

        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}