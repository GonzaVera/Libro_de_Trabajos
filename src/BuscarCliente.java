import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuscarCliente {
    private Connection connection;

    public BuscarCliente(Connection connection) {
        this.connection = connection;
    }

    public List<Object[]> buscarRegistros(String nombreABuscar) {
        try {
            String query = "SELECT n.nombre, d.dni FROM nombre n " +
                    "INNER JOIN Cliente c ON c.IDnombre = n.IDnombre " +
                    "INNER JOIN dni d ON c.IDdni = d.IDdni " +
                    "WHERE n.nombre = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nombreABuscar);
            ResultSet resultSet = statement.executeQuery();

            List<Object[]> data = new ArrayList<>();

            while (resultSet.next()) {
                Object[] rowData = new Object[3]; //
                for (int i = 0; i < rowData.length; i++) {
                    rowData[i] = resultSet.getObject(i + 1);
                }
                data.add(rowData);
            }

            resultSet.close();
            return data;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new ArrayList<>(); // Devuelve una lista vacía en caso de error
        }
    }
}

