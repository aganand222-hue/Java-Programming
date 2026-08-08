import java.sql.*;

public class PracticalNo07_A {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/sycs";
        String user = "root";
        String password = "root";

        String query = "SELECT * FROM employees";

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)
        ) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String department = rs.getString("department");

                System.out.println(
                    "ID: " + id +
                    ", Name: " + name +
                    ", Age: " + age +
                    ", Department: " + department
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}