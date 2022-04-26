package com.dmr.medicalinternbackend.Service.student;

import com.dmr.medicalinternbackend.DAO.StudentDataAccess;
import com.dmr.medicalinternbackend.Entities.Student;
import com.dmr.medicalinternbackend.Exception.ResourceNotFoundException;
import com.dmr.medicalinternbackend.dto.requests.DashboardDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

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
        studentDataAccess.findById(studentId).orElseThrow(()->
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
        dashboardDto.setCourses(student.getCourses());
        dashboardDto.setOasisId(student.getOasisID());
        dashboardDto.setId(studentId);
        dashboardDto.setNoPatientLogs(getNumberOfPatientLogs(studentId));
        dashboardDto.setNoProcedures(getNumberOfProcedures(studentId));

        return dashboardDto;
    }


}
