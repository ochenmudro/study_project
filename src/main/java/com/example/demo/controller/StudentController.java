package com.example.demo.controller;

import com.example.demo.entitie.Course;
import com.example.demo.entitie.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController implements Controller {

    @GetMapping(value = "/get/oldestStudent")
    public String oldestStudent() {
        ArrayList<Course> courses = Controller.getListOfCourses();
        List<Student> students = new ArrayList<>();
        courses.forEach(course -> students.addAll(course.getStudents()));
        Optional<Student> oldStudent = students.stream().max(Comparator.comparingInt(Student::getAge));
        return oldStudent.get().getName() + " " + oldStudent.get().getLastname();
    }

    @GetMapping(value = "/get/longerLastnameAndBusyStudent")
    public String longerLastnameAndBusyStudent() {
        ArrayList<Course> courses = Controller.getListOfCourses();
        List<Student> students = new ArrayList<>();
        List<Student> busyStudents = new ArrayList<>();
        courses.forEach(course -> students.addAll(course.getStudents()));
        busyStudents = students.stream().filter(student -> student.getCourses().size() >= 3 && student.getCourses()
                .size() <= 5).toList();
        Optional<Student> busyLongerStudent = students.stream().max(Comparator.comparingInt(o -> o.getLastname().length()));
        return busyLongerStudent.get().getName() + " " + busyLongerStudent.get().getLastname();
    }
}
