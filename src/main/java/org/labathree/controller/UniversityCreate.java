package org.labathree.controller;

import org.labathree.models.university.University;
import org.labathree.models.university.Faculty;
import org.labathree.models.university.Human;

import java.util.List;

public interface UniversityCreate {
    default University create(List<Faculty> faculties, Human boss, String universityName){
        University university = new University();
        university.setRector(boss);
        university.setName(universityName);
        university.setFaculties(faculties);
        return university;
    }
}
