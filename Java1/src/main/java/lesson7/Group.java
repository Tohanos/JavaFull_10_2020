package lesson7;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private final String id;
    private static int inc = 0;
    private static final String PREFIX = "group#";
    private final List<Student> students = new ArrayList<>();
    private final List<Teacher> teachers = new ArrayList<>();

    public Group() {
        id = PREFIX + (++inc);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void enrollStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            student.changeGroup(this);
        }
    }

    public void addTeacher(Teacher teacher) {
        if (!teachers.contains(teacher)) {
            teachers.add(teacher);
            teacher.getGroups().add(this);
        }
    }

    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }

    public String getId() {
        return id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id='" + id + '\'' +
                '}';
    }
}
