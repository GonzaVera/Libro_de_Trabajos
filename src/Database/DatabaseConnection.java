package Database;

import java.sql.*;

public class DatabaseConnection {
    Statement statement;
    Connection con;

    public Statement coo()  {
        return statement;
    }

    public Connection cc() {
        return con;
    }

    public void conectar() throws SQLException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/Loneria?&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "Gonza+-Vera115935";

        try {
            Class.forName(driver);

            con = DriverManager.getConnection(url, user, password);
            /*if (!con.isClosed()) {
                System.out.println("[MySQL] Connected Database");
            }*/

            statement = con.createStatement();
            System.out.println("Conexion Establecida");

        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Connection getConnection() {
        return con;
    }
    public boolean isDatabaseConnected() {
        try {
            return con != null && !con.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }
}