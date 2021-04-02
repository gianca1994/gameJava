package rolGame.client.client;

import java.util.Scanner;

public class Writes {

    Scanner scan = new Scanner(System.in);

    public int writeLoginOrRegister(){
        return Integer.parseInt(scan.nextLine());
    }

    public String writeUser() {
        return scan.nextLine();
    }
    public String writePass() {
        return scan.nextLine();
    }

    public int writeClas() {
        return Integer.parseInt(scan.nextLine());
    }
}
