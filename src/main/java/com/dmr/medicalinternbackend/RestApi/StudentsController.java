package com.dmr.medicalinternbackend.RestApi;

import com.dmr.medicalinternbackend.Entities.Student;
import com.dmr.medicalinternbackend.Service.student.InterfaceStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {

    InterfaceStudentService studentService;

    public StudentsController(InterfaceStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id){
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }


}
