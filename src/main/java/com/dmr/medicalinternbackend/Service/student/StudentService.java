package com.dmr.medicalinternbackend.Service.student;

import com.dmr.medicalinternbackend.DAO.StudentDataAccess;
import com.dmr.medicalinternbackend.Entities.Student;
import com.dmr.medicalinternbackend.Exception.ResourceNotFoundException;
import com.dmr.medicalinternbackend.requests.DashboardDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentService implements InterfaceStudentService  {

    private final StudentDataAccess studentDataAccess;

    public StudentService(StudentDataAccess studentDataAccess) {
        this.studentDataAccess = studentDataAccess;
    }

    @Override
    public Student getStudentById(int id) {
        return studentDataAccess.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Student", "ID", id));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDataAccess.findAll();
    }

    @Override
    public int getNumberOfProcedures(int studentId) {
        Student student = studentDataAccess.findById(studentId).orElseThrow(()->
                new ResourceNotFoundException("Student", "Id", studentId));
        return studentDataAccess.findNumberOfProcedures(studentId);
    }

    @Override
    public int getNumberOfPatientLogs(int studentId) {
        Student student = studentDataAccess.findById(studentId).orElseThrow(()->
                new ResourceNotFoundException("Student", "Id", studentId));


        return studentDataAccess.findNumberOfPatientLogs(student.getId());
    }

    @Override
    public DashboardDto getProfile(int studentId){
        Student student = studentDataAccess.findById(studentId).orElseThrow(()->
                new ResourceNotFoundException("Student", "Id", studentId));
        DashboardDto dashboardDto = new DashboardDto();
        dashboardDto.setCourseName(student.getCourse().getName());
        dashboardDto.setOasisId(student.getOasisID());
        dashboardDto.setId(studentId);
        dashboardDto.setNoPatientLogs(getNumberOfPatientLogs(studentId));
        dashboardDto.setNoProcedures(getNumberOfProcedures(studentId));
        dashboardDto.setTotal(40);

        return dashboardDto;
    }


}
