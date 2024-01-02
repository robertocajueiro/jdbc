package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryConnection {
    public static Connection getConnection() {

        try {
            final String url = "jdbc:mysql://localhost/testdb";
            final String usr = "root";
            final String pwd = "toor";

            return DriverManager.getConnection(url, usr, pwd);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
