package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertCar {
    public static void main(String[] args) throws SQLException {
        Scanner in = new Scanner(System.in);

        System.out.print("Insert a new model car: ");
        String model = in.nextLine();

        System.out.print("Insert brand car: ");
        String brand = in.nextLine();

        Connection connection = FactoryConnection.getConnection();

        String sql = "INSERT INTO tbl_car (model, brand) VALUES(?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, model);
        stmt.setString(2, brand);
        stmt.execute();

        System.out.println("Insert car success");

        in.close();
    }
}
