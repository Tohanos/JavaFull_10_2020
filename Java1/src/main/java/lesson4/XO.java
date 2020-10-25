package lesson4;

import java.util.Scanner;

public class XO {

    public static char[][] MAP;
    public static int[] arrDirX =
            {-1, -1, -1,
                    0, 0, 0,
                    1, 1, 1};
    public static int[] arrDirY =
            {-1, 0, 1,
                    -1, 0, 1,
                    -1, 0, 1};

    private static boolean isInGame;
    private static int SIZE;
    private static final char USER = 'X';
    private static final char PC = 'O';
    private static final char DEFAULT = '_';

    static void fillMap(int size) {
        isInGame = true;
        MAP = new char[size][size];
        SIZE = size;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DEFAULT;
            }
        }
    }

    static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + "|");
            }
            System.out.println();
        }
    }

    public static boolean move(int x, int y, char player) {
        try {
            if (MAP[x][y] == DEFAULT) {
                MAP[x][y] = player;
                return true;
            } else {
                return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    private static void moveAI() {
        int bestX = 0, bestY = 0, weight = -1, bestWeight = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] == DEFAULT) {
                    weight = (i == 1 && j == 1) ? 1 : 0;
                    MAP[i][j] = USER;
                    if (isVictory(USER)) {
                        weight = weight + 2;
                    }
                    MAP[i][j] = PC;
                    if (isVictory(PC)) return;
                    MAP[i][j] = DEFAULT;

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
        MAP[bestX][bestY] = PC;
    }

    public static boolean isVictory(char player) {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                for (int k = 0; k < 9; k++) {
                    if (arrDirX[k] == 0 && arrDirY[k] == 0) {
                        continue;
                    }
                    if (checkPos(i, j, arrDirX[k], arrDirY[k], 0, player, 3)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    static boolean checkPos(int x, int y, int dirX, int dirY, int amount, char player, int amountToWin) {
        //Функция для проверки выигрышного положения на поле любого размера
        //и для проверки отрезков любой длины
        try {
            if (MAP[x][y] == player) {
                if (amount + 1 == amountToWin) {    //базовый случай
                    return true;
                }
                return (checkPos(x + dirX, y + dirY, dirX, dirY, amount + 1, player, amountToWin));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        fillMap(3);
        printMap();
        System.out.println("Игра крестики-нолики!" +
                "Вы играете за Х" +
                "Для того, чтобы совершить ход: введите номер строки и номер столбца");
        while (isInGame) {
            System.out.println("Ваш ход:");
            int x, y;
            try {
                x = in.nextInt();
                y = in.nextInt();
            } catch (Exception e) {
                System.out.println("Введите корректные данные");
                in.nextLine();
                continue;
            }
            x--;
            y--;
            if (move(x, y, USER)) {
                printMap();
                if (isVictory(USER)) {
                    System.out.println("Вы победили!");
                    break;
                }
                try {
                    System.out.println("Ходит компьютер");
                    moveAI();
                    printMap();
                } catch (Exception e) {
                    System.out.println("Ничья");
                    break;
                }
                if (isVictory(PC)) {
                    System.out.println("Вы проиграли!");
                    break;
                }
            } else {
                System.out.println("Введите корректные данные");
            }
        }

    }
}
