package gameJava.rolGame.frms;

import gameJava.rolGame.dbWork.DbUsers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmLogin extends JFrame {
    private JPanel rootPanel;
    private JButton btnBack;
    private JButton btnLogin;
    private JTextField txtPassword;
    private JTextField txtUser;
    private JLabel lblPassword;
    private JLabel lblUser;

    public frmLogin() {

        add(rootPanel);
        setTitle("Game Of Java");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmInitial abrir = new frmInitial();

                abrir.setVisible(true);
                setVisible(false);
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DbUsers users = new DbUsers();

                String user = String.valueOf(txtUser.getText());
                String password = String.valueOf(txtPassword.getText());
                users.loginDB(user, password);
            }
        });
    }
}
