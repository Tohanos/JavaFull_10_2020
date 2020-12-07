package lesson7;

import javafx.scene.control.TextArea;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ServerListener implements Runnable{

    private final ObjectInputStream is;
    private boolean running;
    private TextArea output;


    public ServerListener(Socket socket, TextArea output) throws IOException {
        is = new ObjectInputStream(socket.getInputStream());
        running = true;
        this.output = output;
    }



    @Override
    public void run() {
        while (running) {
            try {
                while(!Thread.interrupted()) {
                    Message message = (Message) is.readObject();
                    output.appendText(message.getAuthor() + ": " + message.getMessage());
                }
                is.close();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Exception while read");
                break;
            }
        }
    }
}
