package com.dmr.medicalinternbackend.DAO;

import com.dmr.medicalinternbackend.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface StudentDataAccess extends JpaRepository<Student,Integer> {

    @Query(value = "SELECT COUNT(*) FROM procedure_form where student_id= ?",nativeQuery = true)
    int findNumberOfProcedures(int studentId);

    @Query(value = "SELECT COUNT(*) FROM patient_log where student_id= ?",nativeQuery = true)
    int findNumberOfPatientLogs(int studentId);

    Student findByOasisIDAndPassword(long oasisId, String password);

    Student findByOasisID(long oasisId);
}
