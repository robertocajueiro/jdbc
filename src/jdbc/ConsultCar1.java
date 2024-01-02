package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultCar1 {
    public static void main(String[] args) throws SQLException {
        Connection connection = FactoryConnection.getConnection();
        String sql = "SELECT * FROM tbl_car";

        Statement stmt = connection.createStatement();
        ResultSet result = stmt.executeQuery(sql);

        List<Car> car = new ArrayList<>();

        while (result.next()) {
            int id = result.getInt("id");
            String model = result.getNString("model");
            String brand = result.getString("brand");
            car.add(new Car(id, model, brand));
        }

        for (Car p: car) {
            System.out.println(p.getId() + " ==> " + p.getModel() + " " + p.getBrand());
        }

        stmt.close();
        connection.close();
    }
}
