package lesson3.homweork;


import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {
    private HashMap<String, ArrayList<String>> record;

    public Phonebook() {
        record = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        ArrayList<String> pn;
        if (record.containsKey(name)) {
            pn = record.get(name);
        } else {
            pn = new ArrayList<>();
        }
        pn.add(phoneNumber);
        record.put(name, pn);
    }

    public ArrayList<String> get(String name) {
        return record.get(name);
    }

    public static void main(String[] args) {
        Phonebook pb = new Phonebook();

        pb.add("Ivanoff","+700001");
        pb.add("Petroff", "+700002");
        pb.add("Sidoroff","+700003");
        pb.add("Petroff", "+700004");
        pb.add("Sidoroff","+700005");
        pb.add("Getoff", "+700006");

        System.out.println("Ivanoff:" + pb.get("Ivanoff"));
        System.out.println("Petroff:" + pb.get("Petroff"));
        System.out.println("Sidoroff:" + pb.get("Sidoroff"));
    }
}

