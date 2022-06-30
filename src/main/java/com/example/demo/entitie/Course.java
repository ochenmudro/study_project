package com.example.demo.entitie;

import java.util.ArrayList;

public class Course {

    private String name;
    private String description;
    private String mentor;
    private ArrayList<Student> students;

    public Course(String name, String description, String mentor, ArrayList<Student> students) {
        this.name = name;
        this.description = description;
        this.mentor = mentor;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public Integer sumOfStudentsYears(){
        return this.students.stream().mapToInt(Student::getAge).sum();
    }
}
