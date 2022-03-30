package com.dmr.medicalinternbackend.RestApi;

import com.dmr.medicalinternbackend.Entities.ProcedureForm;
import com.dmr.medicalinternbackend.Service.procedure.IProcedureService;
import com.dmr.medicalinternbackend.requests.ProcedureDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/procedures")
public class ProceduresController {

    IProcedureService procedureService;

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
    public ResponseEntity<ProcedureForm> updateProcedureForm(@RequestBody ProcedureForm form, @PathVariable int id){
        return new ResponseEntity<>(procedureService.updateProcedureForm(form,id),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProcedureForm>> getStudentsForm( @RequestParam("studentId") Optional<Integer> studentId,
                                                                @RequestParam("coordinatorId") Optional<Integer> coordinatorId,
                                                                @RequestParam("attendingId") Optional<Integer> attendingId,
                                                                @RequestParam("status") String status){

        return procedureService.getFormsById(studentId,attendingId,coordinatorId,status);
    }


}
