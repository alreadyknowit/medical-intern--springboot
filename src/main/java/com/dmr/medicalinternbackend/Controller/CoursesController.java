package com.dmr.medicalinternbackend.Controller;

import com.dmr.medicalinternbackend.Entities.Course;
import com.dmr.medicalinternbackend.Service.course.ICourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    private final ICourseService courseService;

    public CoursesController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

}
