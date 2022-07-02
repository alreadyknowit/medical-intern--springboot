package com.dmr.medicalinternbackend.Service.patientLog;

import com.dmr.medicalinternbackend.Entities.PatientLogForm;
import com.dmr.medicalinternbackend.dto.requests.PatientLogDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IPatientLogService {

    PatientLogForm insertForm(PatientLogDto formDto);
    ResponseEntity<List<PatientLogForm>> getFormsById(int id,String status);
    ResponseEntity<List<PatientLogForm>> getFormsAttending(int id,String status);

    PatientLogForm updateStatus(PatientLogDto dto,int id);

    void deleteForm(int id);
    void deleteAllForms();

}
