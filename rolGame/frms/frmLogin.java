package rolGame.frms;

import rolGame.dbWork.DbUsers;

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
        setSize(350, 300);
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
                boolean check = users.loginDB(user, password);

                if (check){
                    JOptionPane.showMessageDialog(null, "¡¡Successful Login!! Welcome: " + user + "!!");
                }else{
                    JOptionPane.showMessageDialog(null, "Login failed, try again...");
                }
            }
        });
    }
}
