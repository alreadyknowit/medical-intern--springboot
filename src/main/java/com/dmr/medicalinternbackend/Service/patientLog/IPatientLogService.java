package com.dmr.medicalinternbackend.Service.patientLog;

import com.dmr.medicalinternbackend.Entities.PatientLogForm;
import com.dmr.medicalinternbackend.dto.requests.PatientLogDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IPatientLogService {

    PatientLogForm insertForm(PatientLogDto formDto);
    ResponseEntity<List<PatientLogForm>> getFormsById(Optional<Integer> id, Optional<Integer> attendingId, Optional<Integer> coordinatorId,String status);
    PatientLogForm getById(int id);
    PatientLogForm updateForm(PatientLogDto patientLogDto, int id);
    void deleteForm(int id);
    void deleteAllForms();

}
