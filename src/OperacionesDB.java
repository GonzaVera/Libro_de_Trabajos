import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OperacionesDB {
    private Connection connection;

    public OperacionesDB(Connection connection) {
        this.connection = connection;
    }
 //creo metodos en una clase a parte para ahorrarme la repeticion de codigo
    public void insertNombre(String nombre) throws SQLException {
        String insertNombreQuery = "INSERT INTO nombre (nombre) VALUES (?)";
        try (PreparedStatement insertNombreStatement = connection.prepareStatement(insertNombreQuery)) {
            insertNombreStatement.setString(1, nombre);
            insertNombreStatement.executeUpdate();
        }
    }
    public void insertApellido(String apellido) throws SQLException {
        String insertApellidoQuery = "INSERT INTO apellido (apellido) VALUES (?)";
        try (PreparedStatement insertApellidoStatement = connection.prepareStatement(insertApellidoQuery)) {
            insertApellidoStatement.setString(1, apellido);
            insertApellidoStatement.executeUpdate();
        }
    }
    public void insertTelefono(String telefono) throws SQLException {
        String insertTelefonoQuery = "INSERT INTO telefono (telefono) VALUES (?)";
        try (PreparedStatement insertTelefonoStatement = connection.prepareStatement(insertTelefonoQuery)) {
            insertTelefonoStatement.setString(1, telefono);
            insertTelefonoStatement.executeUpdate();
        }
    }
    public void insertDireccion(String direccion) throws SQLException {
        String insertDireccionQuery = "INSERT INTO direccion (direccion) VALUES (?)";
        try (PreparedStatement insertDireccionStatement = connection.prepareStatement(insertDireccionQuery)) {
            insertDireccionStatement.setString(1, direccion);
            insertDireccionStatement.executeUpdate();
        }
    }
    public void insertDescripcion(String descripcion) throws SQLException {
        String insertDescripcionQuery = "INSERT INTO descripcion (descripcion) VALUES (?)";
        try (PreparedStatement insertDescripcionStatement = connection.prepareStatement(insertDescripcionQuery)) {
            insertDescripcionStatement.setString(1, descripcion);
            insertDescripcionStatement.executeUpdate();
        }
    }
    public void insertDNI(String dni) throws SQLException {
        String insertDNIQuery = "INSERT INTO dni (dni) VALUES (?)";
        try (PreparedStatement insertDNIStatement = connection.prepareStatement(insertDNIQuery)) {
            insertDNIStatement.setString(1, dni);
            insertDNIStatement.executeUpdate();
        }
    }




    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

