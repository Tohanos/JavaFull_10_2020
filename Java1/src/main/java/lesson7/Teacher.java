package lesson7;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher {

    private String name;
    private String surname;
    private String subject;
    private final List<Group> groups = new ArrayList<>();

    public Teacher(String name, String surname, String subject) {
        this.name = name;
        this.surname = surname;
        this.subject = subject;
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        for (Group group : groups) {
            students.addAll(group.getStudents());
        }
        return students;
    }

    public List<Student> getStudents(Group group) {
        return group.getStudents();
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", subject='" + subject + '\'' +
                ", groups='" + getGroups().stream()
                .map(Group::getId)
                .collect(Collectors.joining(", ")) + "'" + '}';
    }
}
