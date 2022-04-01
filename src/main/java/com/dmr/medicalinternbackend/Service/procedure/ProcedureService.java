package com.dmr.medicalinternbackend.Service.procedure;

import com.dmr.medicalinternbackend.DAO.*;
import com.dmr.medicalinternbackend.Entities.*;
import com.dmr.medicalinternbackend.Exception.ResourceNotFoundException;
import com.dmr.medicalinternbackend.requests.ProcedureDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProcedureService implements IProcedureService{


    private final ProcedureFormDataAccess procedureFormDataAccess;
    private final StudentDataAccess studentDataAccess;
    private final CoordinatorDataAccess coordinatorDataAccess;
    private final AttendingDataAccess attendingDataAccess;
    private final SpecialityDataAccess specialityDataAccess;

    public ProcedureService(ProcedureFormDataAccess procedureFormDataAccess, StudentDataAccess studentDataAccess,
                            CoordinatorDataAccess coordinatorDataAccess, AttendingDataAccess attendingDataAccess,
                            SpecialityDataAccess specialityDataAccess) {
        this.procedureFormDataAccess = procedureFormDataAccess;
        this.studentDataAccess = studentDataAccess;
        this.coordinatorDataAccess = coordinatorDataAccess;
        this.attendingDataAccess = attendingDataAccess;
        this.specialityDataAccess = specialityDataAccess;
    }


    @Override
    public ProcedureForm getProcedureById(int id) {
       return procedureFormDataAccess.findById(id).orElseThrow(()->new ResourceNotFoundException("Procedure Form","ID",id));
    }

    @Override
    public ProcedureForm updateProcedureForm(ProcedureForm procedureForm, int id) {

        ProcedureForm formMaybe = procedureFormDataAccess.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Procedure Form","ID", id));

        formMaybe.setEtkilesimTuru(procedureForm.getEtkilesimTuru());
        formMaybe.setGerceklestigiOrtam(procedureForm.getGerceklestigiOrtam());
        formMaybe.setAttending(procedureForm.getAttending());
        formMaybe.setCoordinator(procedureForm.getCoordinator());
        formMaybe.setStudent(procedureForm.getStudent());
        formMaybe.setTibbiUygulama(procedureForm.getTibbiUygulama());
        procedureFormDataAccess.save(procedureForm);
        return procedureForm;
    }

    @Override
    public ProcedureForm insertProcedureForm(ProcedureDto formDto) {
        ProcedureForm form = new ProcedureForm();
        form.setTibbiUygulama(formDto.getTibbiUygulama());
        form.setGerceklestigiOrtam(formDto.getGerceklestigiOrtam());
        form.setEtkilesimTuru(formDto.getEtkilesimTuru());
        form.setStatus(formDto.getStatus());

        AttendingPhysician attendingPhysician =attendingDataAccess.findById(formDto.getAttendingId()).orElseThrow(()->
                new ResourceNotFoundException("Attending", "ID",formDto.getAttendingId()));
        Student student=studentDataAccess.findById(formDto.getStudentId()).orElseThrow(()->
                new ResourceNotFoundException("Student", "ID", formDto.getStudentId()));
        Coordinator coordinator = coordinatorDataAccess.findById(formDto.getCoordinatorId()).orElseThrow(()->
                new ResourceNotFoundException("Coordinator", "Id", formDto.getCoordinatorId()));
        Speciality speciality =specialityDataAccess.findById(formDto.getSpecialityId()).orElseThrow(()->
                new ResourceNotFoundException("Speciality", "Id", formDto.getSpecialityId()));

        form.setStudent(student);
        form.setCoordinator(coordinator);
        form.setAttending(attendingPhysician);
        form.setSpeciality(speciality);
        return procedureFormDataAccess.save(form);
    }

    @Override
    public ResponseEntity<List<ProcedureForm>> getFormsById(Optional<Integer> studentId, Optional<Integer> attendingId, Optional<Integer> coordinatorId,String status) {

        //TODO:Switch case kullanılacak
        if(studentId.isPresent())
            return new ResponseEntity<>(procedureFormDataAccess.findAllByStudentIdAndStatus(studentId.get(),status), HttpStatus.OK);
        else if(coordinatorId.isPresent())
            return new ResponseEntity<>(procedureFormDataAccess.findAllByCoordinatorIdAndStatus(coordinatorId.get(),status),HttpStatus.OK);
        else if(attendingId.isPresent())
            return new ResponseEntity<>(procedureFormDataAccess.findAllByAttendingIdAndStatus(attendingId.get(),status),HttpStatus.OK);

        throw new ResourceNotFoundException("Patient Logs", "coordinator id",coordinatorId);
    }


}
