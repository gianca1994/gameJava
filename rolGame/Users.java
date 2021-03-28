package gameJava.rolGame;

import java.util.Scanner;

public class Users {

    Scanner scan = new Scanner(System.in);
    DBWork database = new DBWork();
    Messages msg = new Messages();
    MenuAdmin AdmMenu = new MenuAdmin();
    MenuUser UserMenu = new MenuUser();

    public void loginUser() {

        System.out.println(msg.login);
        System.out.println(msg.setUser);
        String userName = scan.nextLine();
        System.out.println(msg.setPass);
        String userPassword = scan.nextLine();

        int checkLogin = database.loginDB(userName, userPassword);

        if (checkLogin == 1) {
            UserMenu.setMenu();
        } else if (checkLogin == 666) {
            AdmMenu.setMenu();
        } else {
            System.out.println("ERROR WHEN TRYING TO LOGIN !!");
        }
    }

    public void registerUser() {

        System.out.println(msg.register);

        System.out.println(msg.setNewUser);
        String userNewName = scan.nextLine();

        System.out.println(msg.setNewPass);
        String userNewPassword = scan.nextLine();

        System.out.println(msg.setNewClass);
        int userNewClass = Integer.parseInt(scan.nextLine());

        boolean checkRegister = database.insert(userNewName, userNewPassword, userNewClass);

        if (checkRegister) {
            System.out.println("REGISTERED USER!!");
        } else {
            System.out.println("ERROR WHEN TRYING TO REGISTER !!");
        }
    }
}
