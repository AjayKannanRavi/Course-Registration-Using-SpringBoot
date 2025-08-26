package com.example.Course.Registration.controller;

import com.example.Course.Registration.model.Course;
import com.example.Course.Registration.model.CourseRegister;
import com.example.Course.Registration.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("courses")
    public List<Course> availableCourses(){
        return courseService.availablemethods();
    }

    @GetMapping("courses/enrolled")
    public List<CourseRegister> enrolledStudents(){
        return courseService.enrolledStudents();
    }

    @PostMapping("courses/register")
    public String enrollCourse(@RequestParam String name,
                               @RequestParam String emailId,
                               @RequestParam String courseName) {
        courseService.enrollCourse(name, emailId, courseName);
        return "Created successfully";
    }

}

