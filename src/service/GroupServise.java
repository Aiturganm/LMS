package service;

import models.Group;

public interface GroupServise{
    void add(Group group);
    Group getGroupByName(String name);
    void updateGroupName(String Oldame, String newName);
    void getAllGroups();
    void deleteGroup(String groupName);
}
