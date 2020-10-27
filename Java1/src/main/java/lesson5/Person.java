package lesson5;

public class Person {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Person(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public void printInfo() {
        System.out.println(this);
    }

    public static void main(String[] args) {
        String[] names = {"Вася", "Петя", "Коля", "Лена", "Света"};
        String[] positions = {"директор", "слесарь", "специалист по клинингу", "главный инженер", "тренер"};
        String[] emails = {"vasya@firma.com", "petya@firma.com", "kolya@firma.com", "lena@firma.com", "sveta@firma.com"};
        String[] phones = {"+79999999999","+79999999998","+79999999997","+79999999996","+79999999995"};
        int[] salaries = {200000, 250000, 10000, 250000, 200000};
        int[] ages = {50, 40, 25, 45, 30};
        Person[] personArr = new Person[5];
        for (int i = 0; i < 5; i++) {
            personArr[i] = new Person(names[i], positions[i], emails[i], phones[i], salaries[i], ages[i]);
            if (personArr[i].age > 40) {
                System.out.println(personArr[i]);
            }
        }


    }


}
