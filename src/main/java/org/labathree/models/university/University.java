package org.labathree.models.university;

import java.util.List;

public class University {
    private String name;
    private List<Faculty> faculties;
    private Human rector;

    public Human getRector() {
        return rector;
    }

    public void setRector(Human boss) {
        this.rector = boss;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }
}
