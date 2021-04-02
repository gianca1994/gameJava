package rolGame.admin;

import rolGame.dbWork.DbNpcs;
import rolGame.dbWork.DbUsers;

import java.util.Scanner;

import static rolGame.Messages.*;

public class MenuAdmin {

    Scanner scan = new Scanner(System.in);

    public void setMenu() {

        print(MENU_ADMIN);
        /*
        int option = Integer.parseInt(scan.nextLine());

        switch (option) {
            case 1 -> setMenuNPC();
            case 2 -> setMenuUser();
            case 3 -> System.exit(0);
            default -> {
                setMenu();
                throw new IllegalStateException(msg.errNumeric + option);
            }
        }*/
    }

    public void setMenuNPC() {

        DbNpcs dbNpcs = new DbNpcs();
        FunctionsNpc functions = new FunctionsNpc();

        print(MENU_NPC_ADMIN);
        int opt = Integer.parseInt(scan.nextLine());

        switch (opt) {
            case 1:
                functions.addNewNpc();
                break;

            case 2:
                dbNpcs.seeStatsNpcDB(functions.setSeeIdNpc(), false);

            case 3:

                int[] newStats = functions.editNpc(functions.setNameNpc());

                boolean resultEditNpc = dbNpcs.editStatsNpcDB(
                        functions.setEditIdNpc(),
                        functions.setNameNpc(),
                        newStats[0],
                        newStats[1],
                        newStats[2],
                        newStats[3],
                        newStats[4],
                        newStats[5],
                        newStats[6],
                        newStats[7]
                );
                System.out.println(resultEditNpc);

            case 4:
                functions.deleteNpc();

            case 5:
                System.exit(0);

            default:
                setMenu();
                throw new IllegalStateException(ERR_NUMERIC + opt);

        }
    }

    public void setMenuUser() {

        FunctionsUsers functionsUsers = new FunctionsUsers();
        DbUsers dbUser = new DbUsers();

        print(MENU_USER_ADMIN);
        int opt = Integer.parseInt(scan.nextLine());

        switch (opt) {
            case 1:
                dbUser.seeStatsUserDB(functionsUsers.setSeeIdUser(), false);

            case 2:
                System.exit(0);
            default:
                setMenu();
                throw new IllegalStateException(ERR_NUMERIC + opt);
        }
    }
}
