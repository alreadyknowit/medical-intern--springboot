package com.dmr.medicalinternbackend.Service.form;

import com.dmr.medicalinternbackend.DAO.FormDataAccess;
import com.dmr.medicalinternbackend.Entities.Form;
import com.dmr.medicalinternbackend.Exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class FormService implements InterfaceFormService{

    FormDataAccess formDataAccess;


    @Override
    public Form insertForm(Form form) {
        return formDataAccess.save(form);
    }

    @Override
    public List<Form> getAllForms() {
        return formDataAccess.findAll();
    }

    @Override
    public Form getById(int id) {
        //lambda expression
        return formDataAccess.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Form", "ID", id));
     /* Optional<Form> formMaybe= formDataAccess.findById(id);
        if(formMaybe.isPresent())
            return formMaybe.get();
        else
            throw  new ResourceNotFoundException("Form", "Id", id);*/

    }

    @Override
    public Form updateForm(Form form, int id) {
        Form formMaybe = formDataAccess.findById(id).orElseThrow(()-> new ResourceNotFoundException("Form", "ID",id));
        formMaybe.setCinsiyet(form.getCinsiyet());
        formMaybe.setAyiriciTani(form.getAyiriciTani());
        formMaybe.setEtkilesimTuru(form.getEtkilesimTuru());
        formMaybe.setKapsam(form.getKapsam());
        formMaybe.setGerceklestigiOrtam(form.getGerceklestigiOrtam());
        formMaybe.setKayitNo(form.getKayitNo());
        formMaybe.setKesinTani(form.getKesinTani());
        formMaybe.setSikayet(form.getSikayet());
        formMaybe.setStajTuru(form.getStajTuru());
        formMaybe.setStatus(form.getStatus());
        formMaybe.setTedaviYontemi(form.getTedaviYontemi());
        formMaybe.setYas(form.getYas());
        formMaybe.setCreatedAt(form.getCreatedAt());
//        formMaybe.setAttendingPhysician(form.getAttendingPhysician());
        formDataAccess.save(formMaybe);
        return formMaybe;
    }

    @Override
    public void deleteForm(int id) {
        Form formMaybe = formDataAccess.findById(id).orElseThrow(()-> new ResourceNotFoundException("Form", "ID", id));
        formDataAccess.deleteById(formMaybe.getId());
    }

    @Override
    public void deleteAllForms() {
        formDataAccess.deleteAll();
    }

    @Override
    public List<Form> findByKayitNo(String kayit) {
        return formDataAccess.findByKayitNo(kayit);
    }

    @Override
    public List<Form> findByKayitNoContaining(String key) {
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        return formDataAccess.findByKayitNoContaining(key,sort);
    }

    @Override
    public List<Form> findByStudentId(int id) {
        return formDataAccess.findFormByStudentId(id);
    }

    @Override
    public List<Form> findByAttendingId(int id) {
        return formDataAccess.findAllByAttendingId(id);
    }

    @Override
    public List<Form> findByAttendingIdAndCoordinatorId(int aid, int cid) {
        return formDataAccess.findAllByAttendingIdAndCoordinatorId(aid,cid);
    }


}
