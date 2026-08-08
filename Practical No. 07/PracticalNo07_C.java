package jsons117;

import java.sql.*;
import java.util.Scanner;

public class PracticalNo07_C {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/sycs";
        String user = "root";
        String password = "root";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an operation:");
        System.out.println("1. Insert");
        System.out.println("2. Update");
        System.out.println("3. Delete");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                insertRecord(url, user, password);
                break;

            case 2:
                updateRecord(url, user, password);
                break;

            case 3:
                deleteRecord(url, user, password);
                break;

            default:
                System.out.println("Invalid choice");
        }

        scanner.close();
    }

    private static void insertRecord(
            String url, String user, String password) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter employee department: ");
        String department = scanner.nextLine();

        String query =
            "INSERT INTO employees (id, name, age, department) " +
            "VALUES (?, ?, ?, ?)";

        try (
            Connection conn =
                DriverManager.getConnection(url, user, password);
            PreparedStatement stmt =
                conn.prepareStatement(query)
        ) {

            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setInt(3, age);
            stmt.setString(4, department);

            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " row(s) inserted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateRecord(
            String url, String user, String password) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new employee age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new employee department: ");
        String department = scanner.nextLine();

        String query =
            "UPDATE employees " +
            "SET name = ?, age = ?, department = ? " +
            "WHERE id = ?";

        try (
            Connection conn =
                DriverManager.getConnection(url, user, password);
            PreparedStatement stmt =
                conn.prepareStatement(query)
        ) {

            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, department);
            stmt.setInt(4, id);

            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " row(s) updated.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteRecord(
            String url, String user, String password) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee ID to delete: ");
        int id = scanner.nextInt();

        String query =
            "DELETE FROM employees WHERE id = ?";

        try (
            Connection conn =
                DriverManager.getConnection(url, user, password);
            PreparedStatement stmt =
                conn.prepareStatement(query)
        ) {

            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " row(s) deleted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}