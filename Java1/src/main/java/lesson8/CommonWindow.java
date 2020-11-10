package lesson8;

import javax.swing.*;
import java.awt.*;

public class CommonWindow extends JFrame {
    private KeyValues keyPressed = KeyValues.NULL_KEY_PRESSED;

    public KeyValues isKeyPressed() {
        return keyPressed;
    }

    public CommonWindow(String labelText) throws HeadlessException {
        setSize(175, 120);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel(labelText);

        JLabel text = new JLabel("Новая игра?");

        JButton yesButton = new JButton("Да");

        yesButton.addActionListener(e -> {
            keyPressed = KeyValues.YES_KEY;
            dispose();
            new Window();

        });

        JButton noButton = new JButton("Нет");

        noButton.addActionListener(e -> {
            keyPressed = KeyValues.NO_KEY;
            dispose();
            System.exit(0);
        });


        JPanel panel = new JPanel();
        panel.setLayout(null);

        panel.add(label);
        panel.add(text);
        panel.add(yesButton);
        panel.add(noButton);

        Insets insets = panel.getInsets();
        Dimension size = yesButton.getPreferredSize();
        yesButton.setBounds(10 + insets.left, 40 + insets.top,
                size.width, size.height);

        size = noButton.getPreferredSize();
        noButton.setBounds( 70 + insets.left, 40 + insets.top,
                size.width, size.height);

        size = label.getPreferredSize();
        label.setBounds(20 + insets.left, 5 + insets.top,
                size.width, size.height);

        size = text.getPreferredSize();
        text.setBounds(15 + insets.left, 20 + insets.top,
                size.width, size.height);

        add(panel);

        setResizable(false);
        setVisible(true);
    }


}
