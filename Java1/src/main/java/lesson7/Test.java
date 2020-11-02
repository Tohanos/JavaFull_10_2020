package lesson7;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        University u = new University();
        u.createGroups(3);
        Group g1 = u.getGroups().get(0);
        Group g2 = u.getGroups().get(1);
        Group g3 = u.getGroups().get(2);
        Teacher t1 = new Teacher("Ivan", "Petrov", "Math");
        Teacher t2 = new Teacher("Oleg", "Popov", "Inf");
        Student s1 = new Student("S1", "N1");
        Student s2 = new Student("S2", "N2");
        Student s3 = new Student("S3", "N3");
        Student s4 = new Student("S4", "N4");
        u.addStudent(s1);
        u.addStudent(s2);
        u.addStudent(s3);
        u.addStudent(s4);
        u.addTeacher(t1);
        u.addTeacher(t2);
        u.enrollStudent(g1, s1);
        u.enrollStudent(g1, s2);
        u.enrollStudent(g2, s3);
        u.enrollStudent(g2, s4);
        u.takeJob(List.of(g1, g2), t1);
        u.takeJob(List.of(g1, g2), t2);
        System.out.println(t1);
        System.out.println(t1.getStudents());
        System.out.println(t1.getStudents(g1));


        System.out.println(s1);
        System.out.println(s1.getClassMates());
        System.out.println(s1.getTeachers());
        System.out.println(s1.getGroup());
//        for (int i = 0; i < 10; i++) {
//            u.addTeacher(new Teacher("N" + i, "S" + i, "sub" + i));
//            int finalI = i;
//            u.getGroups().forEach(g -> g.addTeacher(u.getTeachers().get(finalI)));
//        }
//        for (int i = 0; i < 30; i++) {
//            u.addStudent(new Student("sN" + i, "sS" + i, u.getGroups().get(i % 3)));
//
//        }
//
//        System.out.println(u.getTeachers().get(0).getStudents());
//        System.out.println(u.getTeachers().get(0).getStudents(u.getGroups().get(0)));
//
//        System.out.println(u.getStudents().get(0).getTeachers());
//        System.out.println(u.getStudents().get(0).getClassMates());

    }
}
