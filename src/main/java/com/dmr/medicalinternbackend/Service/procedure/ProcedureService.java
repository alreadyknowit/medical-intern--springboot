package com.dmr.medicalinternbackend.Service.procedure;

import com.dmr.medicalinternbackend.DAO.*;
import com.dmr.medicalinternbackend.Entities.*;
import com.dmr.medicalinternbackend.Exception.ResourceNotFoundException;
import com.dmr.medicalinternbackend.dto.requests.ProcedureDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProcedureService implements IProcedureService {


    private final ProcedureFormDataAccess procedureFormDataAccess;
    private final StudentDataAccess studentDataAccess;
    private final CoordinatorDataAccess coordinatorDataAccess;
    private final AttendingDataAccess attendingDataAccess;
    private final SpecialityDataAccess specialityDataAccess;
    
    private final CourseDataAccess courseDataAccess;

    public ProcedureService(ProcedureFormDataAccess procedureFormDataAccess, StudentDataAccess studentDataAccess,
                            CoordinatorDataAccess coordinatorDataAccess, AttendingDataAccess attendingDataAccess,
                            SpecialityDataAccess specialityDataAccess, CourseDataAccess courseDataAccess) {
        this.procedureFormDataAccess = procedureFormDataAccess;
        this.studentDataAccess = studentDataAccess;
        this.coordinatorDataAccess = coordinatorDataAccess;
        this.attendingDataAccess = attendingDataAccess;
        this.specialityDataAccess = specialityDataAccess;
        this.courseDataAccess = courseDataAccess;
    }


    @Override
    public ProcedureForm getProcedureById(int id) {
        return procedureFormDataAccess.findById(id).orElseThrow(() -> new ResourceNotFoundException("Procedure Form", "ID", id));
    }

    @Override
    public ProcedureForm updateProcedureForm(ProcedureDto dto, int id) {

        ProcedureForm formMaybe = procedureFormDataAccess.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Procedure Form", "ID", id));
/*
        Course course = courseDataAccess.findById(dto.getCourseId()).orElseThrow(() ->
                new ResourceNotFoundException("Course", "id", dto.getCourseId()));
        Coordinator coordinator = coordinatorDataAccess.findById(dto.getCoordinatorId()).orElseThrow(() ->
                new ResourceNotFoundException("Coordinator", "id", dto.getCoordinatorId()));
        AttendingPhysician attendingPhysician = attendingDataAccess.findById(dto.getAttendingId()).orElseThrow(() ->
                new ResourceNotFoundException("Attending", "ID", dto.getAttendingId()));
        Student student = studentDataAccess.findById(dto.getStudentId()).orElseThrow(() ->
                new ResourceNotFoundException("Student", "ID", dto.getStudentId()));
        Speciality speciality = specialityDataAccess.findById(dto.getSpecialityId()).orElseThrow(() ->
                new ResourceNotFoundException("Speciality", "Id", dto.getSpecialityId()));

        formMaybe.setEtkilesimTuru(dto.getEtkilesimTuru());
        formMaybe.setGerceklestigiOrtam(dto.getGerceklestigiOrtam());
        formMaybe.setAttending(attendingPhysician);
        formMaybe.setCoordinator(coordinator);
        formMaybe.setStudent(student);
        formMaybe.setTibbiUygulama(dto.getTibbiUygulama());*/
        formMaybe.setStatus(dto.getStatus());

        procedureFormDataAccess.save(formMaybe);
        return formMaybe;
    }

    @Override
    public ProcedureForm insertProcedureForm(ProcedureDto formDto) {
        ProcedureForm form = new ProcedureForm();
        form.setTibbiUygulama(formDto.getTibbiUygulama());
        form.setGerceklestigiOrtam(formDto.getGerceklestigiOrtam());
        form.setEtkilesimTuru(formDto.getEtkilesimTuru());
        form.setStatus(formDto.getStatus());
        form.setKayitNo(formDto.getKayitNo());
        AttendingPhysician attendingPhysician = attendingDataAccess.findById(formDto.getAttendingId()).orElseThrow(() ->
                new ResourceNotFoundException("Attending", "ID", formDto.getAttendingId()));
        Student student = studentDataAccess.findById(formDto.getStudentId()).orElseThrow(() ->
                new ResourceNotFoundException("Student", "ID", formDto.getStudentId()));
        Coordinator coordinator = coordinatorDataAccess.findById(formDto.getCoordinatorId()).orElseThrow(() ->
                new ResourceNotFoundException("Coordinator", "Id", formDto.getCoordinatorId()));
        Speciality speciality = specialityDataAccess.findById(formDto.getSpecialityId()).orElseThrow(() ->
                new ResourceNotFoundException("Speciality", "Id", formDto.getSpecialityId()));
        Course course = courseDataAccess.findById(formDto.getSpecialityId()).orElseThrow(() ->
                new ResourceNotFoundException("Speciality", "Id", formDto.getSpecialityId()));

        form.setStudent(student);
        form.setCoordinator(coordinator);
        form.setAttending(attendingPhysician);
        form.setSpeciality(speciality);
        form.setCourse(course);
        return procedureFormDataAccess.save(form);
    }

    @Override
    public ResponseEntity<List<ProcedureForm>> getStudentsForm(int studentId, String status) {

        return new ResponseEntity<>(procedureFormDataAccess.findByStudentIdAndStatus(studentId, status), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<List<ProcedureForm>> getAttendingForms(int studentId, String status) {

        return new ResponseEntity<>(procedureFormDataAccess.findByAttendingIdAndStatus(studentId, status), HttpStatus.OK);

    }



}
