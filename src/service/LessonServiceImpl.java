package service;

import database.Database;
import models.Lesson;

import java.util.Arrays;
import java.util.LinkedList;

public class LessonServiceImpl implements LessonService {
    private final Database database;
    private static long counter = 1;

    public LessonServiceImpl(Database database) {
        this.database = database;
    }

    public static long generateId() {
        return counter++;
    }

    @Override
    public void addNewLessonToGroup(Lesson lesson, String nameGroup) {
        boolean isTrue = true;
        for (int i = 0; i < database.groups.size(); i++) {
            if (database.groups.get(i).getGroupName().equals(nameGroup)) {
                database.groups.get(i).getLessons().add(lesson);
                lesson.setId(counter++);
                System.out.println(lesson);
            } else isTrue = false;
        }
        if (isTrue == false) {
            System.out.println("Мындай группа табылган жок!");
        }
    }

    @Override
    public Lesson getLessonByName(String lessonName) {
        boolean isTrue = true;
        for (int i = 0; i < database.groups.size(); i++) {
            for (int j = 0; j < database.groups.get(i).getLessons().size(); j++) {
                if (database.groups.get(i).getLessons().get(j).getLessonName().equals(lessonName)) {
                    return database.groups.get(i).getLessons().get(j);
                } else isTrue = false;
            }
        }
        if (isTrue == false) {
            System.out.println("Мындай сабак табылган жок!");
        }
        return null;
    }

    @Override
    public LinkedList<Lesson> getAllLesson(String groupName) {
        boolean isTrue = true;
        for (int i = 0; i < database.groups.size(); i++) {
            if (database.groups.get(i).getGroupName().equals(groupName)) {
                return database.groups.get(i).getLessons();
            } else isTrue = false;
        }
        if (isTrue == false) {
            System.out.println("Мындай группа табылган жок!");
        }
        return null;
    }


    @Override
    public void deleteLesson(long id) {
        boolean isTrue = true;
        for (int i = 0; i < database.groups.size(); i++) {
            for (int j = 0; j < database.groups.get(i).getLessons().size(); j++) {
                if (database.groups.get(i).getLessons().get(j).getId() == id) {
                    database.groups.get(i).getLessons().remove(database.groups.get(i).getLessons().get(j));
                    System.out.println("IDси " + id + " болгон сабак ийгиликтуу очурулду!");
                } else isTrue = false;
            }
        }
        if(isTrue == false){
            System.out.println("Мындай IDде сабак табылган жок.");
        }
    }
}
