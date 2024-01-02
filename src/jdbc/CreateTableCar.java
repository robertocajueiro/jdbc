package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableCar {

    public static void main(String[] args) throws SQLException {
        Connection connection = FactoryConnection.getConnection();

        String sql = """
                CREATE TABLE IF NOT EXISTS tbl_car (
                   id INT AUTO_INCREMENT PRIMARY KEY,
                   model VARCHAR(50) NOT NULL,
                   brand VARCHAR(50) NOT NULL
                )
                """;
        Statement stmt = connection.createStatement();
        stmt.execute(sql);

        System.out.println("Create Table");

        connection.close();
    }
}
