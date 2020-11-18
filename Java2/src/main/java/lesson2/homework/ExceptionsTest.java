package lesson2.homework;

public class ExceptionsTest {
    public static int testArray(String[][] stringArray) throws MyArraySizeException, MyArrayDataException{
        int sum = 0;
        int i = 0, j = 0;
        if (stringArray.length > 4) {
            throw new MyArraySizeException("Размер массива равен " + stringArray.length + ", но не должен превышать 4");
        }
        try {
            for (i = 0; i < 4; i++) {
                for (j = 0; j < 4; j++) {
                    sum += Integer.parseInt(stringArray[i][j]);
                }
            }
        } catch (NumberFormatException e) {
            throw new MyArrayDataException("В ячейке [" + i + "][" + j + "]" +
                    "не валидные данные");
        }
        return sum;
    }

    public static void main(String[] args) {
        String[][] strArr = {
            { "1" , "2" , "3" , "4" },
            { "5" , "6" , "7" , "8" },
            { "9" , "10" , "11" , "12" },
            { "13" , "14" , "15" , "16" },
        };

        String[][] strArr2 = {
                { "1" , "2" , "3" , "4" },
                { "5" , "6" , "7" , "8" },
                { "9" , "10" , "oneone" , "12" },
                { "13" , "14" , "15" , "16" },
        };

        String[][] strArr3 = {
                { "1", "2", "3", "4", "5"},
                { "6", "7", "8", "9", "10"},
                { "11", "12", "13", "14", "15"},
                { "16", "17", "18", "19", "20" },
                { "21", "22", "23", "24", "25" },
        };

        try {
            System.out.println(testArray(strArr));
            System.out.println(testArray(strArr2));
            System.out.println(testArray(strArr3));

        } catch (MyArraySizeException arraySizeException) {
            System.out.println("Размеры массива вышли за пределы");
        } catch (MyArrayDataException arrayDataException) {
            System.out.println("Данные не верны");
        }
    }
}
