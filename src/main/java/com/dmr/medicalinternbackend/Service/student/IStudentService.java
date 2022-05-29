package com.dmr.medicalinternbackend.Service.student;

import com.dmr.medicalinternbackend.Entities.Student;
import com.dmr.medicalinternbackend.dto.requests.ProfileDto;

import java.util.List;

public interface IStudentService {

    Student getStudentById(int id);
    List<Student> getAllStudents();
    int getNumberOfProcedures(int studentId);
    int getNumberOfPatientLogs(int studentId);
    ProfileDto getProfile(int studentId);

}
