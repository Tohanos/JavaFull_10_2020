package lesson7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class EchoServer {

    private boolean running;
    private ConcurrentLinkedDeque<SerialHandler> clients = new ConcurrentLinkedDeque<>();

    public EchoServer() {
        go();
    }

    public void go() {
        // web 8080
        running = true;
        ExecutorService executor = Executors.newCachedThreadPool();
        try(ServerSocket server = new ServerSocket(8189)) {
            System.out.println("Server started!");
            while (running) {
                System.out.println("Server is waiting connection");
                Socket socket = server.accept();
                System.out.println("Client connected!");
                SerialHandler handler = new SerialHandler(socket, this);
                clients.add(handler);

                executor.execute(handler);
                //new Thread(handler).start();
                System.out.println("Client info: " + socket.getInetAddress());
            }
            executor.shutdown();
        } catch (Exception e) {
            System.out.println("Server crashed");
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void broadCast(Message msg) throws IOException {
        for (SerialHandler client : clients) {
            client.sendMessage(msg);
        }
    }

    public void roomCast(Message msg, String room) throws IOException {
        for (SerialHandler client : clients) {
            if (client.getCurrentRoom().equals(room)) {
                client.sendMessage(msg);
            }
        }
    }

    public void kickMe(SerialHandler client) {
        clients.remove(client);
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ServerConfig.class);
        EchoServer echoServer = context.getBean("echoServer", EchoServer.class);
        echoServer.go();
//        new EchoServer();
    }

}
