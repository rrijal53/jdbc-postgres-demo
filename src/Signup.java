import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Signup extends JFrame implements ActionListener {
    JTextField txtName;
    JPasswordField txtPassword;
    JButton btnSave;
    DatabaseService ds;
    public Signup() {
        try {
            ds = new DatabaseService("slycc", "postgres", "");
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        txtName = new JTextField(30);
        txtName.setToolTipText("Enter Username");
        txtPassword = new JPasswordField(30);
        txtName.setToolTipText("Enter password");
        btnSave = new JButton("Register");
        add(txtName);
        add(txtPassword);
        btnSave.addActionListener(this);
        setLayout(new FlowLayout());
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        User u =  new User(txtName.getText(), "", "", txtPassword.getText(),20 );
        ds.register(u);
    }
}
