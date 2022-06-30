package com.example.demo.entitie;

import java.util.ArrayList;

public class Student {
    private String name;
    private String lastname;
    private int age;
    private ArrayList<String> courses;

    public Student(String name, String lastname, int age, ArrayList<String> courses) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }
}
