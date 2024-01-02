package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
    public static void main(String[] args) throws SQLException {
        final String url = "jdbc:mysql://localhost";
        final String usr = "root";
        final String pwd = "toor";

        Connection connection = DriverManager.getConnection(url, usr, pwd);

//        Connection connection = FactoryConnection.getConnection();
        Statement stmt = connection.createStatement();
        stmt.execute("CREATE DATABASE IF NOT EXISTS testdb");

        System.out.println("Create Database Success!");

        connection.close();
    }
}
