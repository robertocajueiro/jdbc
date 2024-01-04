package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteCar {
    public static void main(String[] args) throws SQLException {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter id car:");
        int id = in.nextInt();

        Connection connection = FactoryConnection.getConnection();
        String sql = "DELETE FROM tbl_car WHERE id = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);

        if (stmt.executeUpdate() > 0){
            System.out.println("Car successfully deleted!");
        } else {
            System.out.println("nothing done!");
        }
        
        connection.close();
        in.close();
    }
}
