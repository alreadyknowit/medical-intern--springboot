package com.dmr.medicalinternbackend.Service.student;

import com.dmr.medicalinternbackend.Entities.Student;
import com.dmr.medicalinternbackend.requests.DashboardDto;

import java.util.List;

public interface InterfaceStudentService {

    Student getStudentById(int id);
    List<Student> getAllStudents();
    int getNumberOfProcedures(int studentId);
    int getNumberOfPatientLogs(int studentId);
    DashboardDto getProfile(int studentId);

}
