package com.dmr.medicalinternbackend.Service.course;

import com.dmr.medicalinternbackend.DAO.CourseDAO;
import com.dmr.medicalinternbackend.Entities.Course;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseService implements ICourseService{

    private CourseDAO courseDAO;

    public CourseService(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public List<Course> getCourses() {
        return courseDAO.findAll();
    }
}
