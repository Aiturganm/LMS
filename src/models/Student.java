package models;

import java.util.Arrays;
import java.util.LinkedList;

public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;
    public LinkedList<Lesson> lessons = new LinkedList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LinkedList<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Lesson lesson) {
        this.lessons.add(lesson);
    }

    @Override
    public String toString() {
        return "\nStudent: " +
                "\nid=" + id +
                "\nfirstName='" + firstName + '\'' +
                "\nlastName='" + lastName + '\'' +
                "\nemail='" + email + '\'' +
                "\npassword='" + password + '\'' +
                "\ngender='" + gender + '\'' +
                "\nlessons='" + lessons + '\'' +
                '\n';
    }
}
