package com.dmr.medicalinternbackend.Service.patientLog;

import com.dmr.medicalinternbackend.DAO.PatientLogDataAccess;
import com.dmr.medicalinternbackend.Entities.PatientLogForm;
import com.dmr.medicalinternbackend.Exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class PatientLogService implements IPatientLogService {

    PatientLogDataAccess patientLogDataAccess;


    @Override
    public PatientLogForm insertForm(PatientLogForm patientLogForm) {
        return patientLogDataAccess.save(patientLogForm);
    }

    @Override
    public List<PatientLogForm> getAllForms() {
        return patientLogDataAccess.findAll();
    }

    @Override
    public PatientLogForm getById(int id) {
        //lambda expression
        return patientLogDataAccess.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Form", "ID", id));
     /* Optional<Form> formMaybe= formDataAccess.findById(id);
        if(formMaybe.isPresent())
            return formMaybe.get();
        else
            throw  new ResourceNotFoundException("Form", "Id", id);*/

    }

    @Override
    public PatientLogForm updateForm(PatientLogForm patientLogForm, int id) {
        PatientLogForm patientLogFormMaybe = patientLogDataAccess.findById(id).orElseThrow(()-> new ResourceNotFoundException("Form", "ID",id));
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
        PatientLogForm patientLogFormMaybe = patientLogDataAccess.findById(id).orElseThrow(()-> new ResourceNotFoundException("Form", "ID", id));
        patientLogDataAccess.deleteById(patientLogFormMaybe.getId());
    }

    @Override
    public void deleteAllForms() {
        patientLogDataAccess.deleteAll();
    }

    @Override
    public List<PatientLogForm> findByAttendingIdAndCoordinatorId(int aid, int cid) {
        return patientLogDataAccess.findAllByAttendingIdAndCoordinatorId(aid,cid);
    }



    /*
    @Override
    public List<PatientLogForm> findByKayitNo(String kayit) {
        return patientLogDataAccess.findByKayitNo(kayit);
    }

    @Override
    public List<PatientLogForm> findByKayitNoContaining(String key) {
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        return patientLogDataAccess.findByKayitNoContaining(key,sort);
    }

    @Override
    public List<PatientLogForm> findByStudentId(int id) {
        return patientLogDataAccess.findFormByStudentId(id);
    }

    @Override
    public List<PatientLogForm> findByAttendingId(int id) {
        return patientLogDataAccess.findAllByAttendingId(id);
    }
*/

}
