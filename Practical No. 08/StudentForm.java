package practicals.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentForm extends JFrame implements ActionListener {

    JTextField rollno, name, age, department;
    JButton submit;

    StudentForm() {

        setTitle("Student Registration");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));

        JLabel l1 = new JLabel("Roll No:");
        JLabel l2 = new JLabel("Name:");
        JLabel l3 = new JLabel("Age:");
        JLabel l4 = new JLabel("Department:");

        rollno = new JTextField();
        name = new JTextField();
        age = new JTextField();
        department = new JTextField();

        submit = new JButton("Submit");

        add(l1);
        add(rollno);

        add(l2);
        add(name);

        add(l3);
        add(age);

        add(l4);
        add(department);

        add(new JLabel(""));
        add(submit);

        submit.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "root"
            );

            String sql = "INSERT INTO student VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(rollno.getText()));
            ps.setString(2, name.getText());
            ps.setInt(3, Integer.parseInt(age.getText()));
            ps.setString(4, department.getText());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                this,
                "Record Inserted Successfully!"
            );

            ps.close();
            con.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                this,
                "Error: " + ex.getMessage()
            );
        }
    }

    public static void main(String[] args) {
        new StudentForm();
    }
}