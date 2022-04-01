package com.dmr.medicalinternbackend.Service.patientLog;

import com.dmr.medicalinternbackend.DAO.*;
import com.dmr.medicalinternbackend.Entities.*;
import com.dmr.medicalinternbackend.Exception.ResourceNotFoundException;
import com.dmr.medicalinternbackend.requests.PatientLogDto;
import lombok.AllArgsConstructor;

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
        form.setStajTuru(formDto.getStajTuru());
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
    public ResponseEntity<List<PatientLogForm>> getFormsById(Optional<Integer> studentId, Optional<Integer> attendingId,
                                                             Optional<Integer> coordinatorId, String status) {

        //TODO:There is a bug use switch-case
        if (studentId.isPresent())
            return new ResponseEntity<>(patientLogDataAccess.findAllByStudentIdAndStatus(studentId.get(), status), HttpStatus.OK);
        else if (coordinatorId.isPresent())
            return new ResponseEntity<>(patientLogDataAccess.findAllByCoordinatorIdAndStatus(coordinatorId.get(), status), HttpStatus.OK);
        else if (attendingId.isPresent())
            return new ResponseEntity<>(patientLogDataAccess.findAllByAttendingIdAndStatus(attendingId.get(), status), HttpStatus.OK);

        throw new ResourceNotFoundException("Patient Logs", "coordinator id", coordinatorId);
    }


    @Override
    public PatientLogForm getById(int id) {
        //lambda expression
        return patientLogDataAccess.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Form", "ID", id));


    }

    @Override
    public PatientLogForm updateForm(PatientLogForm patientLogForm, int id) {

        //TODO: not working probably
        PatientLogForm patientLogFormMaybe = patientLogDataAccess.findById(id).orElseThrow(() -> new ResourceNotFoundException("Form", "ID", id));
        patientLogFormMaybe.setCinsiyet(patientLogForm.getCinsiyet());
        patientLogFormMaybe.setAyiriciTani(patientLogForm.getAyiriciTani());
        patientLogFormMaybe.setEtkilesimTuru(patientLogForm.getEtkilesimTuru());
        patientLogFormMaybe.setKapsam(patientLogForm.getKapsam());
        patientLogFormMaybe.setGerceklestigiOrtam(patientLogForm.getGerceklestigiOrtam());
        patientLogFormMaybe.setKayitNo(patientLogForm.getKayitNo());
        patientLogFormMaybe.setKesinTani(patientLogForm.getKesinTani());
        patientLogFormMaybe.setSikayet(patientLogForm.getSikayet());
        patientLogFormMaybe.setStajTuru(patientLogForm.getStajTuru());
        patientLogFormMaybe.setStatus(patientLogForm.getStatus());
        patientLogFormMaybe.setTedaviYontemi(patientLogForm.getTedaviYontemi());
        patientLogFormMaybe.setYas(patientLogForm.getYas());
        patientLogFormMaybe.setAttending(patientLogForm.getAttending());
        patientLogFormMaybe.setStudent(patientLogForm.getStudent());
        patientLogFormMaybe.setCoordinator(patientLogForm.getCoordinator());
        patientLogDataAccess.save(patientLogFormMaybe);
        return patientLogForm;
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
