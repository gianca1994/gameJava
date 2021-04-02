package rolGame.client.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static rolGame.Messages.print;
import static rolGame.client.client.Reads.*;

public class Client {

    public static void main(String[] args) {

        final String HOST = "127.0.0.1";
        final int PORT = 9999;
        DataInputStream in;
        DataOutputStream out;

        Writes write = new Writes();

        try {
            Socket sClient = new Socket(HOST, PORT);
            in = new DataInputStream(sClient.getInputStream());
            out = new DataOutputStream(sClient.getOutputStream());


            readWelcome(in.readUTF());
            readDbConnection(in.readUTF());
            readLoginOrRegister(in.readUTF());

            out.writeInt(write.writeLoginOrRegister());

            boolean check = in.readBoolean();

            if (check) {
                print(in.readUTF());
                print(in.readUTF());
                out.writeUTF(write.writeUser());
                print(in.readUTF());
                out.writeUTF(write.writePass());
            } else {
                print(in.readUTF());
                print(in.readUTF());
                out.writeUTF(write.writeUser());
                print(in.readUTF());
                out.writeUTF(write.writePass());
                print(in.readUTF());
                out.writeInt(write.writeClas());
            }

            sClient.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
