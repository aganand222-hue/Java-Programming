import javax.swing.*;
import java.awt.*;

public class StudentResumeForm extends JFrame {

    JTextField nameField, dobField, emailField, phoneField;
    JTextArea addressArea, summaryArea;
    JRadioButton male, female, other;
    JCheckBox java, python, cpp;
    JComboBox<String> eduBox;
    JButton submit, clear;
    ButtonGroup bg;

    StudentResumeForm() {

        setTitle("Student Resume Form");
        setSize(500, 650);
        setLayout(null);
        getContentPane().setBackground(new Color(204, 255, 204));

        JLabel heading = new JLabel("My Resume (S096)");
        heading.setFont(new Font("Arial", Font.BOLD, 22));
        heading.setForeground(new Color(0, 100, 0));
        heading.setBounds(130, 10, 250, 30);
        add(heading);

        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setBounds(30, 60, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 60, 250, 25);
        add(nameField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 100, 100, 25);
        add(genderLabel);

        male = new JRadioButton("Male");
        male.setBounds(150, 100, 60, 25);
        male.setBackground(new Color(204, 255, 204));

        female = new JRadioButton("Female");
        female.setBounds(220, 100, 80, 25);
        female.setBackground(new Color(204, 255, 204));

        other = new JRadioButton("Other");
        other.setBounds(310, 100, 70, 25);
        other.setBackground(new Color(204, 255, 204));

        bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        bg.add(other);

        add(male);
        add(female);
        add(other);

        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(30, 140, 100, 25);
        add(dobLabel);

        dobField = new JTextField();
        dobField.setBounds(150, 140, 250, 25);
        add(dobField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 180, 100, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 180, 250, 25);
        add(emailField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(30, 220, 100, 25);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(150, 220, 250, 25);
        add(phoneField);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(30, 260, 100, 25);
        add(addressLabel);

        addressArea = new JTextArea();
        JScrollPane addressScroll = new JScrollPane(addressArea);
        addressScroll.setBounds(150, 260, 250, 60);
        add(addressScroll);

        JLabel eduLabel = new JLabel("Education:");
        eduLabel.setBounds(30, 340, 100, 25);
        add(eduLabel);

        String education[] = {
                "High School",
                "Diploma",
                "BCA",
                "B.Sc",
                "B.Tech",
                "MCA",
                "M.Tech"
        };

        eduBox = new JComboBox<>(education);
        eduBox.setBounds(150, 340, 250, 25);
        add(eduBox);

        JLabel skillLabel = new JLabel("Skills:");
        skillLabel.setBounds(30, 380, 100, 25);
        add(skillLabel);

        java = new JCheckBox("Java");
        java.setBounds(150, 380, 70, 25);
        java.setBackground(new Color(204, 255, 204));

        python = new JCheckBox("Python");
        python.setBounds(220, 380, 80, 25);
        python.setBackground(new Color(204, 255, 204));

        cpp = new JCheckBox("C++");
        cpp.setBounds(310, 380, 70, 25);
        cpp.setBackground(new Color(204, 255, 204));

        add(java);
        add(python);
        add(cpp);

        JLabel summaryLabel = new JLabel("Resume Summary:");
        summaryLabel.setBounds(30, 420, 120, 25);
        add(summaryLabel);

        summaryArea = new JTextArea();
        JScrollPane summaryScroll = new JScrollPane(summaryArea);
        summaryScroll.setBounds(150, 420, 250, 80);
        add(summaryScroll);

        submit = new JButton("Submit");
        submit.setBounds(70, 530, 140, 35);
        submit.setBackground(Color.GREEN);
        add(submit);

        clear = new JButton("Clear");
        clear.setBounds(250, 530, 140, 35);
        clear.setBackground(Color.PINK);
        add(clear);

        submit.addActionListener(e -> {

            String gender = "";

            if (male.isSelected())
                gender = "Male";
            else if (female.isSelected())
                gender = "Female";
            else if (other.isSelected())
                gender = "Other";

            String skills = "";

            if (java.isSelected())
                skills += "Java ";

            if (python.isSelected())
                skills += "Python ";

            if (cpp.isSelected())
                skills += "C++";

            String message =
                    "Resume Submitted Successfully\n\n" +
                    "Name: " + nameField.getText() + "\n" +
                    "DOB: " + dobField.getText() + "\n" +
                    "Gender: " + gender + "\n" +
                    "Email: " + emailField.getText() + "\n" +
                    "Phone: " + phoneField.getText() + "\n" +
                    "Address: " + addressArea.getText() + "\n" +
                    "Education: " + eduBox.getSelectedItem() + "\n" +
                    "Skills: " + skills + "\n" +
                    "Summary: " + summaryArea.getText();

            JOptionPane.showMessageDialog(
                    null,
                    message,
                    "Resume Submitted",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        clear.addActionListener(e -> {
            nameField.setText("");
            dobField.setText("");
            emailField.setText("");
            phoneField.setText("");
            addressArea.setText("");
            summaryArea.setText("");
            bg.clearSelection();
            java.setSelected(false);
            python.setSelected(false);
            cpp.setSelected(false);
            eduBox.setSelectedIndex(0);
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentResumeForm();
    }
}