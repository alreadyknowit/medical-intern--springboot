package com.dmr.medicalinternbackend.Controller;

import com.dmr.medicalinternbackend.Entities.ProcedureForm;
import com.dmr.medicalinternbackend.Service.procedure.IProcedureService;
import com.dmr.medicalinternbackend.dto.requests.ProcedureDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/procedures")
public class ProceduresController {

        private final IProcedureService procedureService;

    public ProceduresController(IProcedureService procedureService) {
        this.procedureService = procedureService;
    }


    @GetMapping("{id}")
    public ResponseEntity<ProcedureForm> getById(@PathVariable int id){
        return new ResponseEntity<>(procedureService.getProcedureById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProcedureForm> insertProcedureForm(@RequestBody ProcedureDto procedureDto){
        return new ResponseEntity<>(procedureService.insertProcedureForm(procedureDto),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProcedureForm> updateProcedureForm(@RequestBody ProcedureDto form, @PathVariable int id){
        return new ResponseEntity<>(procedureService.updateProcedureForm(form,id),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProcedureForm>> getStudentsForm( @RequestParam("studentId") int studentId,
                                                                @RequestParam("status") String status){
        return procedureService.getStudentsForm(studentId,status);
    }

    @GetMapping("/attending")
    public ResponseEntity<List<ProcedureForm>> getAttendingForms( @RequestParam("attendingId") int id,
                                                                @RequestParam("status") String status){
        return procedureService.getAttendingForms(id,status);
    }


}
