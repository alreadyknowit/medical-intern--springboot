package com.dmr.medicalinternbackend.Service.student;

import com.dmr.medicalinternbackend.DAO.StudentDataAccess;
import com.dmr.medicalinternbackend.Entities.Student;
import com.dmr.medicalinternbackend.Exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService implements InterfaceStudentService  {

    StudentDataAccess studentDataAccess;


    @Override
    public Student getStudentById(int id) {
        return studentDataAccess.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Student", "ID", id));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDataAccess.findAll();
    }


}
