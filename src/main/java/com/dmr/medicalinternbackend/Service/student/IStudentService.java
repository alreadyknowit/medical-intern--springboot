package com.dmr.medicalinternbackend.Service.student;

import com.dmr.medicalinternbackend.Entities.Student;
import com.dmr.medicalinternbackend.dto.requests.ProfileDto;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.Optional;

public interface IStudentService {

    Student getStudentById(int id);
    List<Student> getAllStudents();
    int getNumberOfProcedures(int studentId);
    int getNumberOfPatientLogs(int studentId);
    ProfileDto getProfile(int studentId);

    Student getStudentLogin(long no, String password,String role) throws AuthenticationException;

    boolean checkAvailability(long no) throws AuthenticationException;

}
