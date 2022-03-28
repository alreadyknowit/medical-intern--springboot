package com.dmr.medicalinternbackend.RestApi;

import com.dmr.medicalinternbackend.Entities.ProcedureForm;
import com.dmr.medicalinternbackend.Service.procedure.IProcedureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/procedures")
public class ProceduresController {

    IProcedureService procedureService;

    public ProceduresController(IProcedureService procedureService) {
        this.procedureService = procedureService;
    }


    @GetMapping
    public ResponseEntity<List<ProcedureForm>> getAll(){
        return new ResponseEntity<>(procedureService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProcedureForm> getById(@PathVariable int id){
        return new ResponseEntity<>(procedureService.getProcedureById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProcedureForm> insertProcedureForm(@RequestBody ProcedureForm procedureForm){
        return new ResponseEntity<>(procedureService.insertProcedureForm(procedureForm),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProcedureForm> updateProcedureForm(@RequestBody ProcedureForm form, @PathVariable int id){
        return new ResponseEntity<>(procedureService.updateProcedureForm(form,id),HttpStatus.CREATED);
    }


}
