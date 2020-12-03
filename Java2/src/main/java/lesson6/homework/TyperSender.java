package lesson6.homework;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class TyperSender implements Runnable {
    private StringBuffer inString;
    private DataOutputStream os;

    public TyperSender(DataOutputStream os) {
        this.os = os;
        inString = new StringBuffer();
    }

    @Override
    public void run() {
        Scanner in = new Scanner(System.in);
        System.out.println("Now you can type");
        while(true) {
            while (in.hasNext()) {
                inString.append(in.nextLine());
                try {
                    os.writeUTF(inString.toString());
                    os.flush();
                    ClearString();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void ClearString() {
        inString.delete(0, inString.capacity());
    }

    public StringBuffer getInString() {
        return inString;
    }
}
