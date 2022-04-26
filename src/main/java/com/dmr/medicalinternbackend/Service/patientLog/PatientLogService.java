package com.dmr.medicalinternbackend.Service.patientLog;

import com.dmr.medicalinternbackend.DAO.*;
import com.dmr.medicalinternbackend.Entities.*;
import com.dmr.medicalinternbackend.Exception.ResourceNotFoundException;
import com.dmr.medicalinternbackend.dto.requests.PatientLogDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientLogService implements IPatientLogService {

    private final PatientLogDataAccess patientLogDataAccess;
    private final CoordinatorDataAccess coordinatorDataAccess;
    private final StudentDataAccess studentDataAccess;
    private final AttendingDataAccess attendingDataAccess;
    private final SpecialityDataAccess specialityDataAccess;

    public PatientLogService(PatientLogDataAccess patientLogDataAccess,
                             CoordinatorDataAccess coordinatorDataAccess,
                             StudentDataAccess studentDataAccess,
                             AttendingDataAccess attendingDataAccess,
                             SpecialityDataAccess specialityDataAccess) {
        this.patientLogDataAccess = patientLogDataAccess;
        this.coordinatorDataAccess = coordinatorDataAccess;
        this.studentDataAccess = studentDataAccess;
        this.attendingDataAccess = attendingDataAccess;
        this.specialityDataAccess = specialityDataAccess;
    }

    @Override
    public PatientLogForm insertForm(PatientLogDto formDto) {
        PatientLogForm form = new PatientLogForm();
        Student student = studentDataAccess.findById(formDto.getStudentId()).orElseThrow(() ->
                new ResourceNotFoundException("Student", "ID", formDto.getStudentId()));
        AttendingPhysician attendingPhysician = attendingDataAccess.findById(formDto.getAttendingId()).orElseThrow(() ->
                new ResourceNotFoundException("Attending", "ID", formDto.getAttendingId()));
        Coordinator coordinator = coordinatorDataAccess.findById(formDto.getCoordinatorId()).orElseThrow(() ->
                new ResourceNotFoundException("Coordinator", "Id", formDto.getCoordinatorId()));
        Speciality speciality = specialityDataAccess.findById(formDto.getSpecialityId()).orElseThrow(() ->
                new ResourceNotFoundException("Speciality", "Id", formDto.getSpecialityId()));

        form.setId(formDto.getId());
        form.setCoordinator(coordinator);
        form.setStudent(student);
        form.setAttending(attendingPhysician);
        form.setSpeciality(speciality);

        form.setStatus(formDto.getStatus());
        form.setKayitNo(formDto.getKayitNo());
        form.setCinsiyet(formDto.getCinsiyet());
        form.setYas(formDto.getYas());
        form.setSikayet(formDto.getSikayet());
        form.setAyiriciTani(formDto.getAyiriciTani());
        form.setKesinTani(formDto.getKesinTani());
        form.setTedaviYontemi(formDto.getTedaviYontemi());
        form.setEtkilesimTuru(formDto.getEtkilesimTuru());
        form.setKapsam(formDto.getKapsam());
        form.setGerceklestigiOrtam(formDto.getGerceklestigiOrtam());

        return patientLogDataAccess.save(form);
    }

    @Override
    @SuppressWarnings({"OptionalUsedAsFieldOrParameterType", "ConstantConditions"})
    public ResponseEntity<List<PatientLogForm>> getFormsById(Optional<Integer> studentId, Optional<Integer> attendingId,
                                                             Optional<Integer> coordinatorId, String status) {
        //TODO:There is a bug use switch-case
        if (studentId.isPresent())
            return new ResponseEntity<>(patientLogDataAccess.findByStudentIdAndStatus(studentId.get(), status), HttpStatus.OK);
        else if (coordinatorId.isPresent())
            return new ResponseEntity<>(patientLogDataAccess.findAllByCoordinatorIdAndStatus(coordinatorId.get(), status), HttpStatus.OK);
        else if (attendingId.isPresent())
            return new ResponseEntity<>(patientLogDataAccess.findAllByAttendingIdAndStatus(attendingId.get(), status), HttpStatus.OK);
        else if(studentId.isPresent() && attendingId.isPresent())
            return new ResponseEntity<>(patientLogDataAccess.findAllByStudentIdAndAttendingIdAndStatus(studentId.get(),attendingId.get(), status), HttpStatus.OK);
        else if(studentId.isPresent() && coordinatorId.isPresent())
            return new ResponseEntity<>(patientLogDataAccess.findAllByStudentIdAndCoordinatorIdAndStatus(studentId.get(),coordinatorId.get(), status), HttpStatus.OK);
        else if(attendingId.isPresent() & coordinatorId.isPresent())
            return new ResponseEntity<>(patientLogDataAccess.findAllByAttendingIdAndCoordinatorIdAndStatus(attendingId.get(),coordinatorId.get(), status), HttpStatus.OK);
        else if(studentId.isPresent() && coordinatorId.isPresent() && attendingId.isPresent())
            return new ResponseEntity<>(patientLogDataAccess.findAllByStudentIdAndAttendingIdAndCoordinatorIdAndStatus(studentId.get(), attendingId.get(),coordinatorId.get(), status), HttpStatus.OK);
        else
            throw new ResourceNotFoundException("Patient Logs", "coordinator id", coordinatorId);

    }


    @Override
    public PatientLogForm getById(int id) {
        //lambda expression
        return patientLogDataAccess.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Form", "ID", id));


    }
        //TODO: test the method
    @SuppressWarnings("DuplicatedCode")
    @Override
    public PatientLogForm updateForm(PatientLogDto patientLogDto,int id) {

        AttendingPhysician attendingPhysician = attendingDataAccess.findById(patientLogDto.getAttendingId()).orElseThrow(() ->
                new ResourceNotFoundException("Attending", "ID", patientLogDto.getAttendingId()));
        Student student = studentDataAccess.findById(patientLogDto.getStudentId()).orElseThrow(() ->
                new ResourceNotFoundException("Student", "ID", patientLogDto.getStudentId()));
        Coordinator coordinator = coordinatorDataAccess.findById(patientLogDto.getCoordinatorId()).orElseThrow(() ->
                new ResourceNotFoundException("Coordinator", "Id", patientLogDto.getCoordinatorId()));
        Speciality speciality = specialityDataAccess.findById(patientLogDto.getSpecialityId()).orElseThrow(() ->
                new ResourceNotFoundException("Speciality", "Id", patientLogDto.getSpecialityId()));
        PatientLogForm patientLogFormMaybe = patientLogDataAccess.findById(patientLogDto.getId()).orElseThrow(() ->
                new ResourceNotFoundException("Form", "ID", patientLogDto.getId()));
        patientLogFormMaybe.setCinsiyet(patientLogDto.getCinsiyet());
        patientLogFormMaybe.setAyiriciTani(patientLogDto.getAyiriciTani());
        patientLogFormMaybe.setEtkilesimTuru(patientLogDto.getEtkilesimTuru());
        patientLogFormMaybe.setKapsam(patientLogDto.getKapsam());
        patientLogFormMaybe.setGerceklestigiOrtam(patientLogDto.getGerceklestigiOrtam());
        patientLogFormMaybe.setKayitNo(patientLogDto.getKayitNo());
        patientLogFormMaybe.setKesinTani(patientLogDto.getKesinTani());
        patientLogFormMaybe.setSikayet(patientLogDto.getSikayet());
        patientLogFormMaybe.setSpeciality(speciality);
        patientLogFormMaybe.setStatus(patientLogDto.getStatus());
        patientLogFormMaybe.setTedaviYontemi(patientLogDto.getTedaviYontemi());
        patientLogFormMaybe.setYas(patientLogDto.getYas());
        patientLogFormMaybe.setAttending(attendingPhysician);
        patientLogFormMaybe.setStudent(student);
        patientLogFormMaybe.setCoordinator(coordinator);
        patientLogDataAccess.save(patientLogFormMaybe);
        return patientLogFormMaybe;
    }

    @Override
    public void deleteForm(int id) {
        PatientLogForm patientLogFormMaybe = patientLogDataAccess.findById(id).orElseThrow(() -> new ResourceNotFoundException("Form", "ID", id));
        patientLogDataAccess.deleteById(patientLogFormMaybe.getId());
    }

    @Override
    public void deleteAllForms() {
        patientLogDataAccess.deleteAll();
    }


}
