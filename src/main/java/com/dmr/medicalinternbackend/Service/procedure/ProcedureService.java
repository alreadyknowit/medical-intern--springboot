package com.dmr.medicalinternbackend.Service.procedure;

import com.dmr.medicalinternbackend.DAO.AttendingDataAccess;
import com.dmr.medicalinternbackend.DAO.CoordinatorDataAccess;
import com.dmr.medicalinternbackend.DAO.ProcedureFormDao;
import com.dmr.medicalinternbackend.DAO.StudentDataAccess;
import com.dmr.medicalinternbackend.Entities.*;
import com.dmr.medicalinternbackend.Exception.ResourceNotFoundException;
import com.dmr.medicalinternbackend.requests.ProcedureDto;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProcedureService implements IProcedureService{


    private ProcedureFormDao procedureFormDao;
    private StudentDataAccess studentDataAccess;
    private CoordinatorDataAccess coordinatorDataAccess;
    private AttendingDataAccess attendingDataAccess;

    public ProcedureService(ProcedureFormDao procedureFormDao, StudentDataAccess studentDataAccess, CoordinatorDataAccess coordinatorDataAccess, AttendingDataAccess attendingDataAccess) {
        this.procedureFormDao = procedureFormDao;
        this.studentDataAccess = studentDataAccess;
        this.coordinatorDataAccess = coordinatorDataAccess;
        this.attendingDataAccess = attendingDataAccess;
    }



    @Override
    public ProcedureForm getProcedureById(int id) {
       return procedureFormDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Procedure Form","ID",id));
    }

    @Override
    public ProcedureForm updateProcedureForm(ProcedureForm procedureForm, int id) {

        ProcedureForm formMaybe =procedureFormDao.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Procedure Form","ID", id));

        formMaybe.setEtkilesimTuru(procedureForm.getEtkilesimTuru());
        formMaybe.setGerceklestigiOrtam(procedureForm.getGerceklestigiOrtam());
        formMaybe.setAttending(procedureForm.getAttending());
        formMaybe.setCoordinator(procedureForm.getCoordinator());
        formMaybe.setStudent(procedureForm.getStudent());
        formMaybe.setTibbiUygulama(procedureForm.getTibbiUygulama());
        procedureFormDao.save(procedureForm);
        return procedureForm;
    }

    @Override
    public ProcedureForm insertProcedureForm(ProcedureDto formDto) {
        ProcedureForm form = new ProcedureForm();
        form.setTibbiUygulama(formDto.getTibbiUygulama());
        form.setGerceklestigiOrtam(formDto.getGerceklestigiOrtam());
        form.setEtkilesimTuru(formDto.getEtkilesimTuru());
        form.setStatus(form.getStatus());
         Student student=studentDataAccess.findById(formDto.getStudentId()).orElseThrow(()->
                 new ResourceNotFoundException("Student", "ID", formDto.getStudentId()));
        AttendingPhysician attendingPhysician =attendingDataAccess.findById(formDto.getAttendingId()).orElseThrow(()->
                new ResourceNotFoundException("Attending", "ID",formDto.getAttendingId()));
        Coordinator coordinator = coordinatorDataAccess.findById(formDto.getCoordinatorId()).orElseThrow(()->
                new ResourceNotFoundException("Coordinator", "Id", formDto.getCoordinatorId()));
        form.setStudent(student);
        form.setCoordinator(coordinator);
        form.setAttending(attendingPhysician);

        return procedureFormDao.save(form);
    }

    @Override
    public ResponseEntity<List<ProcedureForm>> getFormsById(Optional<Integer> studentId, Optional<Integer> attendingId, Optional<Integer> coordinatorId,String status) {

        //TODO:Switch case kullanılacak
        if(studentId.isPresent())
            return new ResponseEntity<>(procedureFormDao.findAllByStudentIdAndStatus(studentId.get(),status), HttpStatus.OK);
        else if(coordinatorId.isPresent())
            return new ResponseEntity<>(procedureFormDao.findAllByCoordinatorIdAndStatus(coordinatorId.get(),status),HttpStatus.OK);
        else if(attendingId.isPresent())
            return new ResponseEntity<>(procedureFormDao.findAllByAttendingIdAndStatus(attendingId.get(),status),HttpStatus.OK);

        throw new ResourceNotFoundException("Patient Logs", "coordinator id",coordinatorId);
    }


}
