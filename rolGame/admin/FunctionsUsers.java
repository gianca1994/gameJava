package rolGame.admin;

import static rolGame.Messages.*;

import java.util.Scanner;

public class FunctionsUsers {
    Scanner scan = new Scanner(System.in);
    MenuAdmin menuAdm = new MenuAdmin();

    int idUser;

    public void seeStatsUser(String dbNameUser, String dbPass, String dbClass, int dbStr,
                             int dbAgi, int dbInt, int dbSpeed, int dbLife, int dbArmor,
                             int dbLifeMax, int dbLifeMin, int dbLevel, int dbExp, int dbExpUp,
                             int adm) {


        print(NAME_USER + dbNameUser + ", " + PASS_USER + dbPass + ", " +
                CLASS_USER + dbClass + ", " + ADM_USER + adm + "\n"

                + STR_USER + dbStr + ", " + AGI_USER + dbAgi + ", " + INT_USER + dbInt +
                ", " + SPEED_USER + dbSpeed + ", " + LIFE_USER + dbLife + "\n"

                + ARMOR_USER + dbArmor + ", " + LIFE_MAX_USER + dbLifeMax + ", " +
                LIFE_MIN_USER + dbLifeMin + ", " + LEVEL_USER + dbLevel + ", " + EXP_USER
                + dbExp + ", " + EXP_UP_USER + dbExpUp + "\n");

        menuAdm.setMenu();
    }

    public int setSeeIdUser() {

        print(SEE_USER_ID);
        idUser = Integer.parseInt(scan.nextLine());
        return idUser;
    }
}
