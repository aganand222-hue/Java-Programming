package practicals.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    JTextField t1, t2, result;
    JButton add, sub, mul, div;

    Calculator() {
        setTitle("Simple Calculator");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));

        JLabel l1 = new JLabel("Enter First Number:");
        JLabel l2 = new JLabel("Enter Second Number:");
        JLabel l3 = new JLabel("Result:");

        t1 = new JTextField();
        t2 = new JTextField();
        result = new JTextField();
        result.setEditable(false);

        add = new JButton("Add");
        sub = new JButton("Subtract");
        mul = new JButton("Multiply");
        div = new JButton("Divide");

        add(l1);
        add(t1);

        add(l2);
        add(t2);

        add(l3);
        add(result);

        add(add);
        add(sub);
        add(mul);
        add(div);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double a = Double.parseDouble(t1.getText());
        double b = Double.parseDouble(t2.getText());
        double ans = 0;

        if (e.getSource() == add) {
            ans = a + b;
        } 
        else if (e.getSource() == sub) {
            ans = a - b;
        } 
        else if (e.getSource() == mul) {
            ans = a * b;
        } 
        else if (e.getSource() == div) {
            if (b != 0)
                ans = a / b;
            else {
                result.setText("Cannot divide by zero");
                return;
            }
        }

        result.setText(String.valueOf(ans));
    }

    public static void main(String[] args) {
        new Calculator();
    }
}