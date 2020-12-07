package lesson7;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements Initializable {

    public TextArea output;
    public TextField input;

    private ObjectOutputStream os;
    private Thread sl;

    public void send(ActionEvent actionEvent) throws IOException {

        os.writeObject(Message.of(MockAuthServiceImpl.getCurrentUser(), input.getText() + "\n"));
        input.clear();
    }

    public void quit(ActionEvent actionEvent) throws IOException {
        Parent chat = FXMLLoader.load(getClass().getResource("auth.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Регистрация");
        stage.setScene(new Scene(chat));
        stage.setResizable(false);
        stage.show();
        input.getScene().getWindow().hide();

        os.close();
        sl.interrupt();
        Platform.exit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 8189);
            os = new ObjectOutputStream(socket.getOutputStream());
            sl = new Thread(new ServerListener(socket, output));
            sl.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
