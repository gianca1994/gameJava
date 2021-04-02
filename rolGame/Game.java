package rolGame;

import rolGame.dbWork.DBWork;
import rolGame.users.Users;
import rolGame.frms.frmInitial;

import javax.swing.*;
import java.util.Scanner;

import static rolGame.Messages.*;


class Game {

    public static void main(String[] args) throws InterruptedException, ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        DBWork database = new DBWork();
        Users users = new Users();
        Utilities util = new Utilities();
        Scanner scan = new Scanner(System.in);

        // FORMULARIO INICIAL
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        frmInitial frminitial = new frmInitial();

        frminitial.setVisible(true);

        print(WELCOME);

        boolean verifyCreateDb = database.createAppDatabase();
        print(DB_CONNECTION + verifyCreateDb + "\n");

        util.timer(1);

        print(LOGIN_REGISTER);

        int opt = Integer.parseInt(scan.nextLine());
        util.clear();

        switch (opt) {
            case 1 -> users.loginUser();
            case 2 -> users.registerUser();
            default -> throw new IllegalStateException(ERR_NUMERIC + opt);
        }
    }


}