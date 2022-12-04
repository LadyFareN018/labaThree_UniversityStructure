package org.labathree.models.university;

import java.util.List;

public class Department  {
    private String name;
    private Human master;
    private List<Group> GroupList;

    public Human getMaster() {
        return master;
    }

    public void setMaster(Human boss) {
        this.master = boss;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getGroupList() {
        return GroupList;
    }

    public void setGroupList(List<Group> groupList) {
        GroupList = groupList;
    }

}
