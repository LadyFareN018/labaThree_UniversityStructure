package org.labathree.controller;

import org.jetbrains.annotations.NotNull;
import org.labathree.models.university.*;

import java.util.ArrayList;
import java.util.List;
/*import java.util.Random;*/

public class Creator implements HumanCreator,StudentCreate, GroupCreate, DepartmentCreate, FacultyCreate, UniversityCreate
{

    public void createTypicalUniversity() {
        HumanCreator humanCreator = new HumanCreator() {
            @Override
            public Human create(Human.Gender gender, String name, String lastName) {
                return HumanCreator.super.create(gender, name, lastName);
            }
        };

        StudentCreate studentCreate = new StudentCreate() {
            @Override
            public Student create(@NotNull Human person) {
                return StudentCreate.super.create(person);
            }
        };

        GroupCreate groupCreate = new GroupCreate() {
            @Override
            public Group create(List<Student> students, String name, Human boss) {
                return GroupCreate.super.create(students, name, boss);
            }
        };

        DepartmentCreate departmentCreate = new DepartmentCreate() {
            @Override
            public Department createDepartment(List<Group> groups, Human boss, String depName) {
                return DepartmentCreate.super.createDepartment(groups, boss, depName);
            }
        };

        FacultyCreate facultyCreate = new FacultyCreate() {
            @Override
            public Faculty createFaculty(List<Department> departments, Human boss, String facultyName) {
                return FacultyCreate.super.createFaculty(departments, boss, facultyName);
            }
        };

        UniversityCreate universityCreate = new UniversityCreate() {
            @Override
            public University create(List<Faculty> faculties, Human boss, String universityName) {
                return UniversityCreate.super.create(faculties, boss, universityName);
            }
        };

        List<Student> students1 = new ArrayList<>();
        List<Student> students2 = new ArrayList<>();
        List<Group> groups = new ArrayList<>();
        List<Department> departments = new ArrayList<>();
        List<Faculty> faculties = new ArrayList<>();

        /*Random random = new Random();*/

        String[] Students_Name = {"Dmytro", "Jensen", "Ann", "Pugsley", "Petro", "Wednesday"};
        String[] Students_Lastname = {"Jarson", "Ackles", "Hanzulenko", "Addams", "Bondorenko", "Addams"};
        Integer[] Students_Gender = {0, 0, 1, 0, 0, 1};
        for (int i = 0; i < 6; i++) {
            Human human = humanCreator.create(Human.Gender.values()[Students_Gender[i]], Students_Name[i], Students_Lastname[i]);
            if (i < 3) {
                Student student = studentCreate.create(human);
                students1.add(student);
            } else {
                Student student = studentCreate.create(human);
                students2.add(student);
            }
        }

        Human groupBoss1 = humanCreator.create(Human.Gender.values()[0], "Jared", "Padalecki");
        Human groupBoss2 = humanCreator.create(Human.Gender.values()[1], "Ammy", "Hartzler");

        Group group1 = groupCreate.create(students1, "124-19-1", groupBoss1);
        Group group2 = groupCreate.create(students2, "124-19-2", groupBoss2);
        groups.add(group1);
        groups.add(group2);

        Human departmentBoss = humanCreator.create(Human.Gender.values()[0], "Timur", "Zheldak");
        Department department = departmentCreate.createDepartment(groups, departmentBoss, "System Analysis & Control");
        departments.add(department);

        Human facultyBoss = humanCreator.create(Human.Gender.values()[1], "Iryna", "Udovik");
        Faculty faculty = facultyCreate.createFaculty(departments, facultyBoss, "FIT");
        faculties.add(faculty);

        Human universityBoss = humanCreator.create(Human.Gender.values()[0], "Oleksandr", "Azukovskiy");
        University university = universityCreate.create(faculties, universityBoss, "NTU DP");

        university.getFaculties()
                .forEach(fac -> faculty.getDepartments()
                        .forEach(dep -> dep.getGroupList()
                                .forEach(gr -> gr.getStudents()
                                        .forEach(st -> System.out.println(
                                                "UNIVERSITY:[ " + university.getName() + ",\tRECTOR:[ " + university.getRector().getName() + " " + university.getRector().getLastName() + " " + university.getRector().getGender()
                                                        + " ]]\t-> FACULTY:[ " + fac.getName() + ",\tDEAN:[ " + fac.getDean().getName() + " " + fac.getDean().getLastName() + " " + fac.getDean().getGender()
                                                        + " ]]\t-> DEPARTMENT:[" + dep.getName() + ",\tHEAD:[ " + dep.getMaster().getName() + " " + dep.getMaster().getLastName() + " " + dep.getMaster().getGender()
                                                        + " ]]\t-> GROUP:[ " + gr.getName() + ",\tHEADMAN:[ " + gr.getCaptain().getName() + " " + gr.getCaptain().getLastName() + " " + gr.getCaptain().getGender()
                                                        + "],\tSTUDENT:[ " + st.getLastName() + " " + st.getName() + " " + st.getGender() + " ]]"
                                        )))));

    }
}
