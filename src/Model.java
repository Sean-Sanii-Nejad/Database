import java.sql.*;
import java.util.ArrayList;

public class Model {

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?", "root", "test");
    }
}
