import pojo.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Signup extends JFrame implements ActionListener {
    JLabel jlName, jlPassword, jlEmail;
    JTextField txtName, txtEmail;
    JPasswordField txtPassword;
    JButton btnSave;
    DatabaseService ds;
    public Signup() {

        txtName = new JTextField(30);
        jlName = new JLabel("NAME");
        jlPassword = new JLabel("PASSWORD");
        txtName.setToolTipText("Enter Username");
        jlEmail = new JLabel("Email");
        txtEmail = new JTextField(20);
        txtPassword = new JPasswordField(30);
        txtName.setToolTipText("Enter password");
        btnSave = new JButton("Register");
        add(jlName);
        add(txtName);
        add(jlEmail);
        add(txtEmail);
        add(jlPassword);
        add(txtPassword);
        add(btnSave);
        btnSave.addActionListener(this);
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            ds = new DatabaseService("slycc", "postgres", "slycc@2o2o");
            User u =  new User(txtName.getText(), txtEmail.getText(), "", txtPassword.getText(),20 );
            System.out.println("registered....");
            boolean reg = ds.register(u);
            if (reg){
                JOptionPane.showMessageDialog(this, "Registered successfully");

            }

        } catch (SQLException ex) {
            System.out.println("sql error....");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Unable to connect to database");
        }

    }
}
