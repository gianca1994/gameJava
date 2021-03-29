package gameJava.rolGame.admin;

import gameJava.rolGame.Messages;

import java.util.Scanner;

public class FunctionsUsers {
    Messages msg = new Messages();
    Scanner scan = new Scanner(System.in);
    MenuAdmin menuAdm = new MenuAdmin();

    int idUser;

    public void seeStatsUser(String dbNameUser, String dbPass, String dbClass, int dbStr,
                            int dbAgi, int dbInt, int dbSpeed, int dbLife, int dbArmor,
                            int dbLifeMax, int dbLifeMin, int dbLevel, int dbExp, int dbExpUp,
                            int adm) {

        msg.print(msg.nameUser + dbNameUser + ", " + msg.passUser + dbPass + ", " +
                msg.classUser + dbClass + ", " + msg.admUser + adm + "\n"

                + msg.strUser + dbStr + ", " + msg.agiUser + dbAgi + ", " + msg.intUser + dbInt +
                ", " + msg.speedUser + dbSpeed + ", " + msg.lifeUser + dbLife + "\n"

                + msg.armorUser + dbArmor + ", " + msg.lifeMaxUser + dbLifeMax + ", " +
                msg.lifeMinUser + dbLifeMin + ", " + msg.levelUser + dbLevel + ", " + msg.expUser
                + dbExp + ", " + msg.expUpUser + dbExpUp + "\n");

        menuAdm.setMenu();
    }

    public int setSeeIdUser() {

        msg.print(msg.seeUserID);
        idUser = Integer.parseInt(scan.nextLine());
        return idUser;
    }
}
