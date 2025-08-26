package com.example.Course.Registration.service;


import com.example.Course.Registration.model.Course;
import com.example.Course.Registration.model.CourseRegister;
import com.example.Course.Registration.repository.CourseRegisterRepo;
import com.example.Course.Registration.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepo courserepo;
    public List<Course> availablemethods() {
       return courserepo.findAll();
    }

    @Autowired
    CourseRegisterRepo courseRegisterRepo;
    public List<CourseRegister> enrolledStudents() {
        return courseRegisterRepo.findAll();
    }

    public void enrollCourse(String name, String emailId, String courseName) {
        CourseRegister courseRegister = new CourseRegister(name, emailId, courseName);
        courseRegisterRepo.save(courseRegister);
    }
}
