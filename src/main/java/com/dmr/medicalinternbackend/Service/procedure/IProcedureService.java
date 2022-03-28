package com.dmr.medicalinternbackend.Service.procedure;

import com.dmr.medicalinternbackend.Entities.ProcedureForm;

import java.util.List;

public interface IProcedureService {

    List<ProcedureForm> findAll();

    ProcedureForm getProcedureById(int id);

    ProcedureForm updateProcedureForm(ProcedureForm procedureForm, int id);

    ProcedureForm insertProcedureForm(ProcedureForm form);
}
