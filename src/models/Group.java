package models;

import java.awt.geom.Line2D;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Group {
    private long id;
    private String GroupName;
    private String description;
    LinkedList<Lesson> lessons = new LinkedList<>();
    LinkedList<Student> students = new LinkedList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LinkedList<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Lesson lesson) {
        this.lessons.add(lesson);
    }

    public LinkedList<Student> getStudents() {
        return students;
    }

    public void setStudents(Student student) {
        this.students.add(student);
    }

    @Override
    public String toString() {
        return "Group:" +
                "\nid=" + id +
                "\nGroupName='" + GroupName + '\'' +
                "\ndescription='" + description + '\'' +
                "\nlessons=" + lessons +
                "\nstudents=" + students +
                '\n';
    }
}
