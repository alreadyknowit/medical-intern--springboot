package com.dmr.medicalinternbackend.Service.form;

import com.dmr.medicalinternbackend.Entities.Form;

import java.util.List;

public interface InterfaceFormService {

    Form insertForm(Form form);
    List<Form> getAllForms();
    Form getById(int id);
    Form updateForm(Form form, int id);
    void deleteForm(int id);
    void deleteAllForms();
    List<Form> findByKayitNo(String kayit);
    List<Form> findByKayitNoContaining(String key);
    List<Form> findByStudentId(int id);
    List<Form> findByAttendingId(int id);
    List<Form> findByAttendingIdAndCoordinatorId(int aid, int cid);
}
