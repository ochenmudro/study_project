package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.entitie.Course;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.logging.Logger;

public interface Controller {
    Logger log = Logger.getLogger(DemoApplication.class.getName());
    String FILE_PATH = "F:\\java\\study_project\\src\\main\\java\\com\\example\\demo\\inputData\\CourseList.json";

    static ArrayList<Course> getListOfCourses() {
        String fileString = "";
        ArrayList<Course> courseList = new ArrayList<>();
        try {
            fileString = Files.readString(Path.of(FILE_PATH));
            Gson gson = new Gson();
            courseList = gson.fromJson(fileString, new TypeToken<ArrayList<Course>>() {
            }.getType());
        } catch (IOException exception) {
            log.warning(String.format("exception get all %s", exception.getMessage()));
        }
        return courseList;
    }
}
