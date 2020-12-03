package lesson6.homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8189);
        DataInputStream is = new DataInputStream(socket.getInputStream());
        DataOutputStream os = new DataOutputStream(socket.getOutputStream());

        TyperSender ct = new TyperSender(os);
        new Thread(ct).start();
        while (true) {
            System.out.println("Message from server :" + is.readUTF());
        }
    }
}
