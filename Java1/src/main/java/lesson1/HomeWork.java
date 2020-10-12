package lesson1;

public class HomeWork {

    public static void main(String[] args) {
        boolean bBool = true;
        int iInteger = 12;
        byte bByte = 120;
        short sShort = 20;
        long lLong = 124098430L;
        float fFloat = 12.45F;
        double dDouble = 12.345;
        char cChar = 'F';

        System.out.println("Calc = "+ calcFloat(1.0F,2.5F, 6F, 67.5F));
        System.out.println(calcInt(5,8));
        whatSignPrint(8);
        printHello("Anton");
        System.out.println(isLeapYear(2000));



    }
    public static float calcFloat(float a, float b, float c, float d) {
        return a * (b+(c/d));
    }
    public static boolean calcInt(int a, int b){
        int iSum = a + b;
        return ((iSum <= 10) || (iSum >= 20));

    }
    public static void whatSignPrint(int iCheck){
        String sSign = "";
        if (isNegative(iCheck)){
            sSign = "negative";
        } else {
            sSign = "Positive";
        }
        System.out.println("Your number = " + iCheck + " is "+ sSign);
    }

    public static boolean isNegative(int iCheck){
        return (iCheck<0);
    }

    public static void printHello(String name){
        System.out.println("Hello, "+name);
    }
    public static boolean isLeapYear(int year){
        return ((year % 4) == 0) && ((year % 100) != 0 || (year % 400) == 0);

    }

}
