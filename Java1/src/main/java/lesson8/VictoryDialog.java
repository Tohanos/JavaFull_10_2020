package lesson8;

import javax.swing.*;
import java.awt.*;

public class VictoryDialog extends JFrame {
    public VictoryDialog() throws HeadlessException {
        setSize(300, 300);
        // setLocation(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton yesButton = new JButton("Да");
        yesButton.addActionListener(e -> {
            new Window();
        });
        JButton noButton = new JButton("Нет");


        JPanel panel = new JPanel();
        panel.add(yesButton);
        panel.add(noButton);

        add(panel);
        //setMenuBar(bar);
        setResizable(false);
        setVisible(true);
    }
}
