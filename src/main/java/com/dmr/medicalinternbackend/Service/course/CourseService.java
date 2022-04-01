package com.dmr.medicalinternbackend.Service.course;

import com.dmr.medicalinternbackend.DAO.CourseDataAccess;
import com.dmr.medicalinternbackend.Entities.Course;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseService implements ICourseService{

    private final CourseDataAccess courseDataAccess;

    public CourseService(CourseDataAccess courseDataAccess) {
        this.courseDataAccess = courseDataAccess;
    }

    @Override
    public List<Course> getCourses() {
        return courseDataAccess.findAll();
    }
}
