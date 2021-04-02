package rolGame.users;

import static rolGame.Messages.*;
import rolGame.admin.MenuAdmin;
import rolGame.dbWork.DbUsers;

import java.util.Scanner;

public class Users {

    Scanner scan = new Scanner(System.in);
    DbUsers dbUsers = new DbUsers();

    String userName, userPassword;
    int userClass;
    boolean checkRegister;

    public void loginUser() {

        print(LOGIN);

        userName = setUserName(SET_USER);
        userPassword = setUserPassword(SET_PASS);

        dbUsers.loginDB(userName, userPassword);
    }

    public void registerUser() {

        print(REGISTER);

        userName = setUserName(SET_NEW_USER);
        userPassword = setUserPassword(SET_NEW_PASS);
        userClass = setUserClass();

        checkRegister = dbUsers.insertUser(userName, userPassword, userClass);

        if (checkRegister) {
            print(USER_REGISTERED);
        } else {
            print(ERROR_USER_REGISTERED);
        }
    }

    private String setUserName(String type) {

        print(type);
        userName = scan.nextLine();
        return userName;
    }

    private String setUserPassword(String type) {

        print(type);
        userPassword = scan.nextLine();
        return userPassword;
    }

    private int setUserClass() {

        print(SET_NEW_CLASS);
        userClass = Integer.parseInt(scan.nextLine());
        return userClass;
    }

}
