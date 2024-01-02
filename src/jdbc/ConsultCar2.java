package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultCar2 {
    public static void main(String[] args) throws SQLException {
        Scanner in = new Scanner(System.in);

        Connection connection = FactoryConnection.getConnection();
        // pesquisando pelo modelo de carro usando LIKE.
        String sql = "SELECT * FROM tbl_car WHERE model like ?";

        System.out.print("Enter the search Model: ");
        String value = in.nextLine();

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, "%" + value + "%");
        ResultSet result = stmt.executeQuery();

        List<Car> car = new ArrayList<>();

        while(result.next()) {
            int id = result.getInt("id");
            String model = result.getString("model");
            String brand = result.getString("brand");
            car.add(new Car(id, model, brand));
        }
        for (Car c: car) {
            System.out.println(c.getId() + " ==> " + c.getModel() + " " + c.getBrand());
        }
    }
}
