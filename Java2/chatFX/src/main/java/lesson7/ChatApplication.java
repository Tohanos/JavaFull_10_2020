package lesson7;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

@Component
public class ChatApplication extends Application {

    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;

    @Override
    public void start(Stage primaryStage) throws Exception {

        ApplicationContext context = new AnnotationConfigApplicationContext(ServerConfig.class);
        ChatApplication application = context.getBean("chatApplication", ChatApplication.class);
        application.go(primaryStage);

    }

    public void go(Stage primaryStage) throws Exception {
        Socket socket;
        try {
            socket = new Socket("localhost", 8189);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent auth = FXMLLoader.load(getClass().getResource("auth.fxml"));
        primaryStage.setTitle("Авторизация");
        primaryStage.setScene(new Scene(auth));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void close () {
        try {
            outputStream.close();
            inputStream.close();
            Platform.exit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
