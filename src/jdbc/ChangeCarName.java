package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ChangeCarName {
    public static void main(String[] args) throws SQLException {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter the car id: ");
        int id = in.nextInt();

        String select = "SELECT id, model, brand FROM tbl_car WHERE id = ?";
        String update = "UPDATE tbl_car SET model = ? WHERE id = ?";


        Connection connection = FactoryConnection.getConnection();
        PreparedStatement stmt = connection.prepareStatement(select);
        stmt.setInt(1, id);
        ResultSet r = stmt.executeQuery();

        if (r.next()) {
            Car c = new Car(r.getInt(1), r.getString(2), r.getString(3));

            System.out.printf("The current car name is: %s, brand: %s%n", c.getModel(), c.getBrand());
            in.nextLine();

            System.out.print("Enter the new model to update: ");
            String newModelCar = in.nextLine();


            stmt.close();
            stmt = connection.prepareStatement(update);
            stmt.setString(1, newModelCar);
            stmt.setInt(2, id);
            stmt.execute();

            System.out.println("update car success!");

        } else {
            System.out.println("Car not found");
        }


        connection.close();
        in.close();

    }
}
