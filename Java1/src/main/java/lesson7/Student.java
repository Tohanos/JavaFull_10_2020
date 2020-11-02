package lesson7;

import java.util.List;

public class Student {

    private String name;
    private String surname;
    private Group group;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void changeGroup(Group group) {
        if (this.group == null) {
            this.group = group;
            group.enrollStudent(this);
        }
        if (!group.equals(this.group)) {
            this.group.removeStudent(this);
            group.enrollStudent(this);
            this.group = group;
        }
    }

    public List<Student> getClassMates() {
        return group.getStudents()
                /*.stream()
                .filter(s -> !s.equals(this))
                .collect(Collectors.toList())*/;
    }

    public List<Teacher> getTeachers() {
        return group.getTeachers();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", group=" + group.getId() +
                '}';
    }
}
