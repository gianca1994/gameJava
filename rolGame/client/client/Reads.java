package rolGame.client.client;

import static rolGame.client.Printer.printMSG;

public class Reads {

    public static void readWelcome(String welcomeMSG) {
        printMSG(welcomeMSG);
    }

    public static void readDbConnection(String DbConnection) {
        printMSG(DbConnection);
    }

    public static void readLoginOrRegister(String loginOrRegisted) {
        printMSG(loginOrRegisted);
    }
}
