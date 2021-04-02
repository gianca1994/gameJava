package rolGame;

import rolGame.dbWork.DBWork;
import rolGame.dbWork.DbUsers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static rolGame.Messages.*;


public class Server {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket sClient = null;
        DataInputStream in;
        DataOutputStream out;
        final int PORT = 9999;

        DbUsers dbUsers = new DbUsers();

        try {
            server = new ServerSocket(PORT);
            print("Server Online!");

            while (true) {

                sClient = server.accept();
                in = new DataInputStream(sClient.getInputStream());
                out = new DataOutputStream(sClient.getOutputStream());

                out.writeUTF(WELCOME);
                out.writeUTF(checkDbConnection());
                out.writeUTF(LOGIN_REGISTER);

                if (in.readInt() == 1) {
                    out.writeBoolean(true);
                    out.writeUTF(LOGIN);
                    out.writeUTF(SET_USER);
                    String userName = in.readUTF();
                    out.writeUTF(SET_PASS);
                    String userPass = in.readUTF();
                    dbUsers.loginDB(userName, userPass);
                } else {
                    out.writeBoolean(false);
                    out.writeUTF(REGISTER);
                    out.writeUTF(SET_NEW_USER);
                    String userNewName = in.readUTF();
                    out.writeUTF(SET_NEW_PASS);
                    String userNewPass = in.readUTF();
                    out.writeUTF(SET_NEW_CLASS);
                    int userNewClass = in.readInt();
                    dbUsers.insertUser(userNewName, userNewPass, userNewClass);
                }

                sClient.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String checkDbConnection() {
        DBWork db = new DBWork();
        return DB_CONNECTION + db.createAppDatabase() + "\n";
    }
}
