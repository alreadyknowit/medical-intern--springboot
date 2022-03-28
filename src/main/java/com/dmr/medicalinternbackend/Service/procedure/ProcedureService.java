package com.dmr.medicalinternbackend.Service.procedure;

import com.dmr.medicalinternbackend.DAO.ProcedureFormDao;
import com.dmr.medicalinternbackend.Entities.ProcedureForm;
import com.dmr.medicalinternbackend.Exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProcedureService implements IProcedureService{


    ProcedureFormDao procedureFormDao;

    public ProcedureService(ProcedureFormDao procedureFormDao) {
        this.procedureFormDao = procedureFormDao;
    }

    @Override
    public List<ProcedureForm> findAll() {
        return procedureFormDao.findAll();
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
    public ProcedureForm insertProcedureForm(ProcedureForm form) {
        return procedureFormDao.save(form);
    }


}
