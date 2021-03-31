package rolGame.users;

import rolGame.Messages;
import rolGame.admin.MenuAdmin;
import rolGame.dbWork.DbUsers;

import java.util.Scanner;

public class Users {

    Scanner scan = new Scanner(System.in);
    Messages msg = new Messages();
    MenuAdmin AdmMenu = new MenuAdmin();
    MenuUser UserMenu = new MenuUser();
    DbUsers dbUsers = new DbUsers();

    String userName, userPassword;
    int userClass;
    boolean checkRegister;

    public void loginUser() {

        msg.print(msg.login);

        userName = setUserName(msg.setUser);
        userPassword = setUserPassword(msg.setPass);

        dbUsers.loginDB(userName, userPassword);
    }

    public void registerUser() {

        msg.print(msg.register);

        userName = setUserName(msg.setNewUser);
        userPassword = setUserPassword(msg.setNewPass);
        userClass = setUserClass(msg.setNewClass);

        checkRegister = dbUsers.insertUser(userName, userPassword, userClass);

        if (checkRegister) {
            msg.print(msg.userRegistered);
        } else {
            msg.print(msg.errorUserRegistered);
        }
    }

    private String setUserName(String type) {

        msg.print(type);
        userName = scan.nextLine();
        return userName;
    }

    private String setUserPassword(String type) {

        msg.print(type);
        userPassword = scan.nextLine();
        return userPassword;
    }

    private int setUserClass(String type) {

        msg.print(type);
        userClass = Integer.parseInt(scan.nextLine());
        return userClass;
    }

}
