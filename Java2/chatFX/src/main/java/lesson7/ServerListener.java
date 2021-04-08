package lesson7;

import javafx.scene.control.TextArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.ObjectInputStream;

@Component
@Scope("prototype")
public class ServerListener implements Runnable{

    private final ObjectInputStream is;

    private boolean running;
    private TextArea output;

    @Autowired
    public ServerListener(ObjectInputStream is, TextArea output) {
        this.is = is;
        running = true;
        this.output = output;
    }

    @Override
    public void run() {
        while (running) {
            try {
                while(!Thread.interrupted()) {
                    Message message = (Message) is.readObject();
                    switch (message.getCommand()[0]) {
                        case "QUIT":
                            running = false;
                            break;
                        case "MESSAGE":
                            output.appendText(message.toString());
                            new LocalHistoryService().saveMessage(message.toString());
                            break;
                    }
                }
                is.close();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Exception while read");
                break;
            }
        }
    }

    public boolean isRunning() {
        return running;
    }
}
