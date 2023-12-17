package service;

import database.Database;
import models.Group;
import models.Lesson;
import models.Student;

import java.util.LinkedList;

public interface StudentService {
    void addStudent(Student student, String  group);
    void updateStudent(String email, String password, String newName, String newLastName);
    Student findStudent(String name);
    void getAllStudents(String groupname);
    LinkedList<Lesson> getLessons(String email);
    void deleteStudent(String email);
}
