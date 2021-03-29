package gameJava.rolGame;

import gameJava.rolGame.dbWork.DBWork;
import gameJava.rolGame.users.Users;

import javax.swing.*;
import java.util.Scanner;


class Game {

    public static void main(String[] args) throws InterruptedException, ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        DBWork database = new DBWork();
        Users users = new Users();
        Utilities util = new Utilities();
        Messages msg = new Messages();
        Scanner scan = new Scanner(System.in);

        // FORMULARIOS
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        //frmGame frmGame = new frmGame();
        //frmGame.setVisible(true);

        msg.print(msg.welcome);


        boolean verifyCreateDb = database.createAppDatabase();
        msg.print(msg.dbConnection + verifyCreateDb + "\n");

        util.timer(1);

        msg.print(msg.loginOrRegister);

        int opt = Integer.parseInt(scan.nextLine());
        util.clear();

        switch (opt) {
            case 1 -> users.loginUser();
            case 2 -> users.registerUser();
            default -> throw new IllegalStateException(msg.errNumeric + opt);
        }
    }


}