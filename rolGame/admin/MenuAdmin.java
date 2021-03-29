package gameJava.rolGame.admin;

import gameJava.rolGame.Messages;
import gameJava.rolGame.dbWork.DbNpcs;

import java.util.Scanner;

public class MenuAdmin extends Functions {

    Messages msg = new Messages();
    Scanner scan = new Scanner(System.in);
    DbNpcs dbNpcs = new DbNpcs();
    Functions functions = new Functions();

    public void setMenu() {

        msg.print(msg.menuAdmin);
        int option = Integer.parseInt(scan.nextLine());

        switch (option) {
            case 1:
                functions.addNewNpc();
                break;

            case 2:
                dbNpcs.seeStatsNpcDB(functions.setSeeIdNpc());

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

            default:
                setMenu();
                throw new IllegalStateException(msg.errNumeric + option);

        }
    }
}
