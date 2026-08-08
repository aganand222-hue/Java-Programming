package jsons117;

import java.sql.*;
import java.util.Scanner;

public class PracticalNo07_B {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/sycs";
        String user = "root";
        String password = "root";

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee ID to fetch: ");
        int employeeId = scanner.nextInt();

        String query = "SELECT * FROM employees WHERE id = ?";

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {

            stmt.setInt(1, employeeId);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {

                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    String department = rs.getString("department");

                    System.out.println("\nEmployee Details:");
                    System.out.println("Employee ID: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("Age: " + age);
                    System.out.println("Department: " + department);

                } else {
                    System.out.println(
                        "No employee found with ID " + employeeId
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}