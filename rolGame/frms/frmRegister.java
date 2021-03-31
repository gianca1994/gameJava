package gameJava.rolGame.frms;

import gameJava.rolGame.dbWork.DbUsers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmRegister extends JFrame {
    private JPanel rootPanel;
    private JLabel lblPassword;
    private JLabel lblClass;
    private JLabel lblUser;
    private JTextField txtUser;
    private JTextField txtPassword;
    private JComboBox comBox;
    private JButton btnRegister;
    private JButton btnBack;

    public frmRegister() {

        add(rootPanel);
        setTitle("Game Of Java");
        setSize(500, 300);
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

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DbUsers users = new DbUsers();

                String user = String.valueOf(txtUser.getText());
                String password = String.valueOf(txtPassword.getText());
                int clase = (comBox.getSelectedIndex() + 1);
                boolean check = users.insertUser(user, password, clase);

                if (check){
                    JOptionPane.showMessageDialog(null, "¡¡Successful registration!! Welcome: " + user + "!!");
                }else{
                    JOptionPane.showMessageDialog(null, "Registration failed, try again...");
                }
            }
        });
    }
}
