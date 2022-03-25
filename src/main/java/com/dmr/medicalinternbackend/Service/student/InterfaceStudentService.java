package com.dmr.medicalinternbackend.Service.student;

import com.dmr.medicalinternbackend.Entities.Form;
import com.dmr.medicalinternbackend.Entities.Student;

import java.util.List;

public interface InterfaceStudentService {

    Student getStudentById(int id);
    List<Student> getAllStudents();

}
