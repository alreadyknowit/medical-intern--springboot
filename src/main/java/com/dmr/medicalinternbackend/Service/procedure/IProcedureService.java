package com.dmr.medicalinternbackend.Service.procedure;

import com.dmr.medicalinternbackend.Entities.ProcedureForm;
import com.dmr.medicalinternbackend.dto.requests.ProcedureDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IProcedureService {



    ProcedureForm getProcedureById(int id);

    ProcedureForm updateProcedureForm(ProcedureForm procedureForm, int id);

    ProcedureForm insertProcedureForm(ProcedureDto form);

    ResponseEntity<List<ProcedureForm>> getFormsById(Optional<Integer> id, Optional<Integer> attendingId, Optional<Integer> coordinatorId,String status);
}
