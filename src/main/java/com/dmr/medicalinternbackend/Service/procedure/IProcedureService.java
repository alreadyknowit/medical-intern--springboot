package com.dmr.medicalinternbackend.Service.procedure;

import com.dmr.medicalinternbackend.Entities.ProcedureForm;
import com.dmr.medicalinternbackend.dto.requests.ProcedureDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProcedureService {



    ProcedureForm getProcedureById(int id);

    ProcedureForm updateProcedureForm(ProcedureDto procedureForm, int id);

    ProcedureForm insertProcedureForm(ProcedureDto form);

    ResponseEntity<List<ProcedureForm>> getStudentsForm(int id, String status);
    ResponseEntity<List<ProcedureForm>> getAttendingForms(int id, String status);

}
