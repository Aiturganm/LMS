package service;

import database.Database;
import exceptions.NotFoundException;
import models.Group;
import models.Lesson;
import models.Student;

import java.util.Arrays;
import java.util.LinkedList;

public class StudentServiceImpl implements StudentService {
    private final Database database;
    private static long counter = 1;

    public StudentServiceImpl(Database database) {
        this.database = database;
    }

    public static long generateId() {
        return counter++;
    }


    @Override
    public void addStudent(Student student, String groupName) {
        boolean isTrue = true;
        for (int i = 0; i < database.groups.size(); i++) {
            if (database.groups.get(i).getGroupName().equals(groupName)) {
                database.groups.get(i).setStudents(student);
                student.setId(counter++);
                System.out.println(database.groups.get(i) + " \nГруппага студент ийгиликтуу кошулду:");
            } else isTrue = false;
        }
        if (isTrue == false) {
            System.out.println("Мындай группа табылган жок.");
        }
    }

    @Override
    public void updateStudent(String email, String password, String newName, String newLastName) {
        boolean isTrue = true;
        for (int i = 0; i < database.groups.size(); i++) {
            for (int j = 0; j < database.groups.get(i).getStudents().size(); j++) {
                if (database.groups.get(i).getStudents().get(j).getEmail().equals(email) && database.groups.get(i).getStudents().get(j).getPassword().equals(password)) {
                    database.groups.get(i).getStudents().get(j).setFirstName(newName);
                    database.groups.get(i).getStudents().get(j).setLastName(newLastName);
                    System.out.println("Студенттин аты жана фамилиясы ийгиликтуу озгортулду!");
                    System.out.println(database.groups.get(i).getStudents().get(j).toString());
                } else isTrue = false;
            }
        }
        if (isTrue == false) {
            System.out.println("Мындай студент табылган жок!");
        }
    }

    @Override
    public Student findStudent(String name) {
        for (int i = 0; i < database.groups.size(); i++) {
            for (int j = 0; j < database.groups.get(i).getStudents().size(); j++) {
                if (name.equals(database.groups.get(i).getStudents().get(j).getFirstName())) {
                    return database.groups.get(i).getStudents().get(j);
                }
            }
        }
        return null;
    }

    @Override
    public void getAllStudents(String groupname) {
        boolean isTrue = true;
        for (int i = 0; i < database.groups.size(); i++) {
            if (database.groups.get(i).getGroupName().equals(groupname)) {
                for (int j = 0; j < database.groups.get(i).getStudents().size(); j++) {
                    System.out.println(database.groups.get(i).getStudents().get(j));
                }
            } else isTrue = false;
        }
        if (isTrue = false) {
            System.out.println("Мындай группа табылган жок!");
        }
    }

    @Override
    public LinkedList<Lesson> getLessons(String email) {
        boolean isTrue = true;
        for (int i = 0; i < database.groups.size(); i++) {
            for (int j = 0; j < database.groups.get(i).getStudents().size(); j++) {
                if (database.groups.get(i).getStudents().get(j).getEmail().equals(email)) {
                    return database.groups.get(i).getStudents().get(j).lessons;
                } else isTrue = false;
            }
        }
        if (isTrue == false) {
            System.out.println("Мындай студент табылган жок");
            return null;
        }
        return null;
    }

    @Override
    public void deleteStudent(String email) {
        for (int i = 0; i < database.groups.size(); i++) {
            for (int j = 0; j < database.groups.get(i).getStudents().size(); j++) {
                if (database.groups.get(i).getStudents().get(j).getEmail().equals(email)) {
                    database.groups.get(i).getStudents().remove(database.groups.get(i).getStudents().get(j));
                    System.out.println("Почтасы " + email + " болгон студент ийгиликтуу очурулду!");
                } else {
                    System.out.println("Электрондук почта табылган жок.");
                }
            }
        }
    }
}
