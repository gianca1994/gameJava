package gameJava.rolGame;

import java.util.Scanner;


class Game {

    public static void main(String[] args) throws InterruptedException {
        DBWork database = new DBWork();
        Users users = new Users();
        Utilities util = new Utilities();
        Scanner scan = new Scanner(System.in);


        boolean verifyCreateDb = database.createAppDatabase();
        System.out.println("Database connection: " + verifyCreateDb + "\n");

        util.timer(5);

        System.out.println("Login or register to continue.");
        System.out.println("Type 1-For login o 2-For register");

        String opt = scan.nextLine();
        util.clear();

        switch (opt) {
            case "1" -> users.loginUser();
            case "2" -> users.registerUser();
            default -> throw new IllegalStateException("Unexpected value: " + opt);
        }
    }


}