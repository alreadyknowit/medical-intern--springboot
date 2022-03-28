package com.dmr.medicalinternbackend.Service.patientLog;

import com.dmr.medicalinternbackend.Entities.PatientLogForm;

import java.util.List;

public interface IPatientLogService {

    PatientLogForm insertForm(PatientLogForm patientLogForm);
    List<PatientLogForm> getAllForms();
    PatientLogForm getById(int id);
    PatientLogForm updateForm(PatientLogForm patientLogForm, int id);
    void deleteForm(int id);
    void deleteAllForms();
/*    List<PatientLogForm> findByKayitNo(String kayit);
    List<PatientLogForm> findByKayitNoContaining(String key);
    List<PatientLogForm> findByStudentId(int id);
    List<PatientLogForm> findByAttendingId(int id);*/
    List<PatientLogForm> findByAttendingIdAndCoordinatorId(int aid, int cid);
}
