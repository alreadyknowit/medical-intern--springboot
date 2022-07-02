package com.dmr.medicalinternbackend.Service.student;

import com.dmr.medicalinternbackend.DAO.StudentDataAccess;
import com.dmr.medicalinternbackend.Entities.Student;
import com.dmr.medicalinternbackend.Exception.ResourceNotFoundException;
import com.dmr.medicalinternbackend.dto.requests.ProfileDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    private final StudentDataAccess studentDataAccess;
    private final ModelMapper modelMapper;

    public StudentService(StudentDataAccess studentDataAccess, ModelMapper modelMapper) {
        this.studentDataAccess = studentDataAccess;
        this.modelMapper = modelMapper;
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
    public ProfileDto getProfile(int studentId){
        Student student = studentDataAccess.findById(studentId).orElseThrow(()->
                new ResourceNotFoundException("Student", "Id", studentId));

        int numberOfProcedures=studentDataAccess.findNumberOfProcedures(student.getId());
        int numberOfPatientLogs=studentDataAccess.findNumberOfPatientLogs(student.getId());
        ProfileDto profileDto = new ProfileDto();
        profileDto.setNumberOfProcedures(numberOfProcedures);
        profileDto.setNumberOfPatientLogs(numberOfPatientLogs);
        profileDto.setCourses(student.getCourses());
        profileDto.setOasisId(student.getOasisID());
        profileDto.setId(studentId);
        profileDto.setNoPatientLogs(getNumberOfPatientLogs(studentId));
        profileDto.setNoProcedures(getNumberOfProcedures(studentId));

        return profileDto;
    }

    @Override
    public Student getStudentLogin(long oasisId, String password, String role) throws AuthenticationException {
        Student student = studentDataAccess.findByOasisIDAndPassword(oasisId,password);

        if(student == null)
            throw new AuthenticationException("Student not found");

        return student;
    }

    @Override
    public boolean checkAvailability(long no) throws AuthenticationException {
        Student student = studentDataAccess.findByOasisID(no);

        return student != null;
        //throw new AuthenticationException("No such oasisID: " + no);
    }



  /*  public ProfileDto mapToDto(Student student){

        return modelMapper.map()
    }*/


}
