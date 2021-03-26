package gameJava.rolGame;

import java.util.Scanner;


class Game {

    public static void main(String[] args) throws InterruptedException {
        DBWork database = new DBWork();
        Users users = new Users();
        Utilities util = new Utilities();
        Messages msg = new Messages();
        Scanner scan = new Scanner(System.in);


        msg.print_msg(msg.welcome);

        boolean verifyCreateDb = database.createAppDatabase();
        msg.print_msg(msg.dbConnection + verifyCreateDb + "\n");

        util.timer(5);

        msg.print_msg(msg.loginOrRegister);

        String opt = scan.nextLine();
        util.clear();

        switch (opt) {
            case "1" -> users.loginUser();
            case "2" -> users.registerUser();
            default -> throw new IllegalStateException(msg.errNumeric + opt);
        }
    }


}