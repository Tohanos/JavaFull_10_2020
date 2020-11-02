package lesson7;

import java.util.ArrayList;
import java.util.List;

public class University {

    private final List<Group> groups = new ArrayList<>();
    private final List<Teacher> teachers = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();

    public List<Group> getGroups() {
        return groups;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void enrollStudent(Group group, Student student) {
        group.enrollStudent(student);
    }

    public void takeJob(List<Group> groups, Teacher teacher) {
        // groups.forEach(group -> group.addTeacher(teacher));
        for(Group group : groups) {
            group.addTeacher(teacher);
        }
    }

    public void createGroups(int limit) {
        for (int i = 0; i < limit; i++) {
            groups.add(new Group());
        }
    }

}
