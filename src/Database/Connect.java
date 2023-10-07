package Database;

import java.sql.SQLException;

public class Connect {
    public static void main(String[] args) throws SQLException {
        DatabaseConnection db = new DatabaseConnection();
        db.conectar();
    }
}
