package gameJava.rolGame.admin;

import gameJava.rolGame.Messages;
import gameJava.rolGame.dbWork.DbNpcs;
import gameJava.rolGame.dbWork.DbUsers;

import java.util.Scanner;

public class MenuAdmin {

    Messages msg = new Messages();
    Scanner scan = new Scanner(System.in);

    public void setMenu() {

        msg.print(msg.menuAdmin);
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

        msg.print(msg.menuNPCAdmin);
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
                throw new IllegalStateException(msg.errNumeric + opt);

        }
    }

    public void setMenuUser() {

        FunctionsUsers functionsUsers = new FunctionsUsers();
        DbUsers dbUser = new DbUsers();

        msg.print(msg.menuUsersAdmin);
        int opt = Integer.parseInt(scan.nextLine());

        switch (opt) {
            case 1:
                dbUser.seeStatsUserDB(functionsUsers.setSeeIdUser(), false);

            case 2:
                System.exit(0);
            default:
                setMenu();
                throw new IllegalStateException(msg.errNumeric + opt);
        }
    }
}
