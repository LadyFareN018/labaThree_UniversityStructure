package org.labathree.controller;

import org.labathree.models.university.Department;
import org.labathree.models.university.Faculty;
import org.labathree.models.university.Human;


import java.util.List;


public interface FacultyCreate {

    default Faculty createFaculty(List<Department> departments, Human dean, String facultyName) {
        Faculty faculty = new Faculty();
        faculty.setDean(dean);
        faculty.setDepartments(departments);
        faculty.setName(facultyName);

        return faculty;

    }
}
