package com.example.demo.controller;

import com.example.demo.entitie.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


@RestController
public class CourseController implements Controller {

    @GetMapping(value = "/get/longestDescriptionCourse")
    public String longestDescriptionCourse() {
        ArrayList<Course> courses = Controller.getListOfCourses();
        List<Course> l = courses.stream().max(Comparator.comparingInt(o -> o.getDescription().length())).stream().toList();
        return l.get(0).getName();
    }

    @GetMapping(value = "/get/moreStudentsOnCourse")
    public String moreStudentsOnCourse() {
        ArrayList<Course> courses = Controller.getListOfCourses();
        Optional<Course> moreStudentsCourse = courses.stream().max(Comparator.comparingInt(o -> o.getStudents().size()));
        return moreStudentsCourse.get().getName();
    }

    @GetMapping(value = "/get/largestSumOfYears")
    public String largestSumOfYears() {
        ArrayList<Course> courses = Controller.getListOfCourses();
        Optional<Course> largestSumCourse = courses.stream().max(Comparator.comparingInt(Course::sumOfStudentsYears));
        return largestSumCourse.get().getName();
    }

    @GetMapping(value = "/get/mostBusyMentor")
    public String mostBusyMentor() {
        ArrayList<Course> courses = Controller.getListOfCourses();
        List<String> mentors2 = courses.stream().map(Course::getMentor).toList();
        List<String> mentors = mentors2.stream().distinct().toList();
        Optional<String> name = mentors2.stream().max(Comparator.comparingInt(o ->
                (int) mentors2.stream().filter(o::equals).count()));
        return name.get().toString();
    }
}
