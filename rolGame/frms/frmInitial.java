package rolGame.frms;

import rolGame.dbWork.DBWork;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class frmInitial extends JFrame{
    private JPanel rootPanel;
    private JButton btnExit;
    private JButton btnRegister;
    private JButton btnLogin;
    private JLabel lblStatus;


    public frmInitial(){

        add(rootPanel);

        setTitle("Game Of Java");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        connected();

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmLogin abrir = new frmLogin();
                abrir.setVisible(true);
                setVisible(false);
            }
        });
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmRegister abrir = new frmRegister();
                abrir.setVisible(true);
                setVisible(false);
            }
        });
    }

    public void connected (){
        DBWork db = new DBWork();
        boolean verifyCreateDb = db.createAppDatabase();

        if (verifyCreateDb) {
            lblStatus.setText("Server: ONLINE");
        }else{
            lblStatus.setText("Server: OFFLINE");
        }
    }
}
