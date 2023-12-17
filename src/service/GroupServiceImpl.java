package service;

import database.Database;
import models.Group;

import java.util.Arrays;

public class GroupServiceImpl implements GroupServise {
    private final Database database;

    public GroupServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public void add(Group group) {
        database.groups.add(group);
        group.setId(MyCenerateId.generateId());
    }
    @Override
    public Group getGroupByName(String name) {
        boolean isTrue = true;
        for (int i = 0; i < database.groups.size(); i++) {
                if (database.groups.get(i).getGroupName().equals(name)){
                return database.groups.get(i);
            } else isTrue = false;
        }
        if(isTrue == false){
            System.out.println("Мындай група табылган жок");
        }
        return null;
    }

    @Override
    public void updateGroupName(String oldName, String newName) {
        boolean istrue = true;
        for (int i = 0; i < database.groups.size(); i++) {
            if (database.groups.get(i).getGroupName().equals(oldName)) {
                database.groups.get(i).setGroupName(newName);
                System.out.println("Группанын аты ийгиликтуу озгортулду!");
                System.out.println(database.groups.get(i).toString());
            } else istrue = false;
        }
        if(istrue == false){
            System.out.println("Мындай группа табылган жок!");
        }
    }

    @Override
    public void getAllGroups() {
        for (Group group : database.groups) {
            System.out.println(group);
            System.out.println();
        }
    }

    @Override
    public void deleteGroup(String groupName) {
        boolean isTrue = true;
        for (int i = 0; i < database.groups.size(); i++) {
            if (database.groups.get(i).getGroupName().equals(groupName)) {
                database.groups.remove(database.groups.get(i));
                System.out.println("Аты " + groupName + " болгон группа ийгиликтуу очурулду!");
            }else isTrue = false;
        }
        if (isTrue == false){
            System.out.println("Аты " + groupName + " болгон группа табылган жок!");
        }
    }
}
