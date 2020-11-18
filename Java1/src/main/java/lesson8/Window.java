package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Arrays;

public class Window extends JFrame {

    private  static final ImageIcon ICON_X = new ImageIcon(Window.class.getResource("X.png"));
    private  static final ImageIcon ICON_O = new ImageIcon(Window.class.getResource("O.png"));
    private  static final ImageIcon ICON_DEFAULT = new ImageIcon(Window.class.getResource("def.png"));
    private  static final int[] arrDirX =
            {-1, -1, -1,
                    0, 0, 0,
                    1, 1, 1};
    private  static final int[] arrDirY =
            {-1, 0, 1,
                    -1, 0, 1,
                    -1, 0, 1};

    private final JButton[][] map = new JButton[3][3];
    private static int clickCount = 0;

    private void initMap(JPanel panel) {
        clickCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = new JButton();
                JButton btn = map[i][j];
                btn.setIcon(ICON_DEFAULT);
                btn.setDisabledIcon(ICON_DEFAULT);
                btn.addActionListener(a -> {
                    btn.setIcon(ICON_X);
                    btn.setDisabledIcon(ICON_X);
                    btn.setEnabled(false);
                    if (isVictory(ICON_X)) {
                        disableAllButtons();
                        showDialog("Вы победили!");
                        return;
                    }

                    try {
                        moveAI();
                    } catch (IllegalArgumentException e) {
                        disableAllButtons();
                        showDialog("Ничья");
                        //dispose();
                        return;
                    }

                    if (isVictory(ICON_O)) {
                        disableAllButtons();
                        showDialog("Вы проиграли");
                        //dispose();
                    }
                });
                panel.add(btn);
            }
        }
    }

    private void moveAI() {
        int bestX = 0, bestY = 0, weight = -1, bestWeight = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[i][j].getIcon() == ICON_DEFAULT) {
                    weight = (i == 1 && j == 1) ? 1 : 0;
                    map[i][j].setIcon(ICON_X);
                    if (isVictory(ICON_X)) {
                        weight = weight + 2;
                    }
                    map[i][j].setIcon(ICON_O);
                    if (isVictory(ICON_O)) {
                        map[i][j].setDisabledIcon(ICON_O);
                        map[i][j].setEnabled(false);
                        return;
                    }
                    map[i][j].setIcon(ICON_DEFAULT);

                    if (weight > bestWeight || bestWeight == 0) {
                        bestX = i;
                        bestY = j;
                        bestWeight = weight;
                    }
                }
            }
        }
        if (weight == -1) {
            throw new IllegalArgumentException();
        }
        map[bestX][bestY].setIcon(ICON_O);
        map[bestX][bestY].setDisabledIcon(ICON_O);
        map[bestX][bestY].setEnabled(false);
    }

    private boolean isVictory(ImageIcon iconPlayer) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 9; k++) {
                    if (arrDirX[k] == 0 && arrDirY[k] == 0) {
                        continue;
                    }
                    if (checkPos(i, j, arrDirX[k], arrDirY[k], 0, iconPlayer, 3)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean checkPos(int x, int y, int dirX, int dirY, int amount, ImageIcon iconPlayer, int amountToWin) {
        //Функция для проверки выигрышного положения на поле любого размера
        //и для проверки отрезков любой длины
        try {
            if (map[x][y].getIcon() == iconPlayer) {
                if (amount + 1 == amountToWin) {    //базовый случай
                    return true;
                }
                return (checkPos(x + dirX, y + dirY, dirX, dirY, amount + 1, iconPlayer, amountToWin));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    private void showDialog (String text) {
        CommonWindow dialog = new CommonWindow(text);
    }

    private void showGameWindow () {
        JPanel panel = new JPanel(new GridLayout(3,3));
        initMap(panel);
        add(panel);
        setResizable(false);
        setVisible(true);
    }
    
    private void disableAllButtons() {
        Arrays.asList(map).forEach(e -> Arrays.asList(e).forEach(b -> b.setEnabled(false)));



//        for (JButton[] butts:
//             map) {
//            for (JButton but:
//                 butts) {
//                but.setEnabled(false);
//            }
//        }
    }


    public Window() throws HeadlessException {
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        showGameWindow();

    }

    public static void main(String[] args) {
        new Window();
    }
}
