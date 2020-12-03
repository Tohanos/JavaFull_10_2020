package lesson6.homework;

import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public EchoServer() {
        // web 8080
        try(ServerSocket server = new ServerSocket(8189)) {
            System.out.println("Server started!");
            while (true) {
                System.out.println("Server is waiting connection");
                Socket socket = server.accept(); // block mode
                new Thread(new ClientHandler(socket)).start();
                System.out.println("Client accepted!");
                System.out.println("Client info: " + socket.getInetAddress());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
