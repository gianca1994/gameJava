package gameJava.rolGame;

import java.util.Scanner;

public class Users {

    public void loginUser(){
        Scanner scan = new Scanner(System.in);
        DBWork database = new DBWork();

        System.out.println("Para continuar, inicie sesion:");
        System.out.println("Enter Username");
        String userName = scan.nextLine();
        System.out.println("Enter Password");
        String userPassword = scan.nextLine();

        boolean checkLogin = database.loginDB(userName, userPassword);

        if(checkLogin){
            System.out.println("USER LOGGED IN!!");
        }else{
            System.out.println("ERROR WHEN TRYING TO LOGIN !!");
        }
    }

}
