package com.dmr.medicalinternbackend.Controller;

import com.dmr.medicalinternbackend.Entities.Student;
import com.dmr.medicalinternbackend.Service.student.InterfaceStudentService;
import com.dmr.medicalinternbackend.requests.DashboardDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

     @GetMapping("/profile")
    public DashboardDto getProfile(@RequestParam("studentId") int id){
        return studentService.getProfile(id);
    }





}
