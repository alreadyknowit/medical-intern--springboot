package com.dmr.medicalinternbackend.DAO;

import com.dmr.medicalinternbackend.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StudentDataAccess extends JpaRepository<Student,Integer> {

}
