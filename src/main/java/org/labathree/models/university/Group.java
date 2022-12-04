package org.labathree.models.university;

import java.util.List;

public class Group{
    private String name;
    private Human captain;
    private
    List<Student> students;

    public Human getCaptain() {
        return captain;
    }

    public void setCaptain(Human boss) {
        this.captain = boss;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
