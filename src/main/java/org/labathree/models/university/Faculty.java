package org.labathree.models.university;

import java.util.List;

public class Faculty {
    private String name;
    private List<Department> departments;
    private Human dean;

    public Human getDean() {
        return dean;
    }

    public void setDean(Human boss) {
        this.dean = boss;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}