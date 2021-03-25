package gameJava.rolGame;

import java.util.Scanner;

public class Users {

    Scanner scan = new Scanner(System.in);
    DBWork database = new DBWork();

    public void loginUser() {

        System.out.println("Para continuar, inicie sesion:");
        System.out.println("Enter Username");
        String userName = scan.nextLine();
        System.out.println("Enter Password");
        String userPassword = scan.nextLine();

        boolean checkLogin = database.loginDB(userName, userPassword);

        if (checkLogin) {
            System.out.println("USER LOGGED IN!!");
        } else {
            System.out.println("ERROR WHEN TRYING TO LOGIN !!");
        }
    }

    public void registerUser() {


        System.out.println("Para continuar, Registrese:");
        System.out.println("Enter new Username");
        String userNewName = scan.nextLine();
        System.out.println("Enter new Password");
        String userNewPassword = scan.nextLine();
        System.out.println("Select a class: 1-Warrior, 2-Mage, 3-Archer");
        int userNewClass = Integer.parseInt(scan.nextLine());


        boolean checkRegister = database.insert(userNewName, userNewPassword, userNewClass);

        if (checkRegister) {
            System.out.println("REGISTERED USER!!");
        } else {
            System.out.println("ERROR WHEN TRYING TO REGISTER !!");
        }
    }
}
