package gameJava.rolGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmGame extends JFrame{
    private JButton btnRegister;
    private JButton btnLogin;
    private JTextField txtUserNameLogin;
    private JTextField txtUserNameRegister;
    private JTextField txtPasswordRegister;
    private JTextField txtPasswordLogin;
    private JComboBox combClass;
    private JPanel rootPanel;
    private JButton btnExit;

    public frmGame(){

        add(rootPanel);

        setTitle("Bienvenidos a Game Of Java");
        setSize(800, 600);

    }
}
