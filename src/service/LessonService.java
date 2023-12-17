package service;

import models.Group;
import models.Lesson;

import java.util.LinkedList;

public interface LessonService {
    void addNewLessonToGroup(Lesson lesson, String nameGroup);
    Lesson getLessonByName(String lessonName);
    LinkedList<Lesson> getAllLesson(String groupName);
    void deleteLesson(long id);
}
