package com.dmr.medicalinternbackend.DAO;

import com.dmr.medicalinternbackend.Entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDAO extends JpaRepository<Course,Integer> {
}
