package com.dmr.medicalinternbackend.Controller;

import com.dmr.medicalinternbackend.Entities.PatientLogForm;
import com.dmr.medicalinternbackend.Service.patientLog.IPatientLogService;
import com.dmr.medicalinternbackend.dto.requests.PatientLogDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient-logs")
public class PatientLogsController {

    private final IPatientLogService formService;

    public PatientLogsController(IPatientLogService formService) {
        this.formService = formService;
    }

    //insert a new form
    @PostMapping
    public ResponseEntity<PatientLogForm> insertForm(@RequestBody PatientLogDto patientLogForm){
        return new ResponseEntity<>(formService.insertForm(patientLogForm), HttpStatus.CREATED);
    }

    //get form with specific id
    @GetMapping("{id}")
    public ResponseEntity<PatientLogForm> getFormById(@PathVariable("id") int id){
      return new ResponseEntity<>(formService.getById(id),HttpStatus.OK);
    }

    //update form info
    @PutMapping("{id}")
    public ResponseEntity<PatientLogForm> updateForm(@RequestBody PatientLogDto patientLogDto, @PathVariable("id") int id){
        return new ResponseEntity<>(formService.updateForm(patientLogDto, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void deleteForm(@PathVariable("id") int id){
        formService.deleteForm(id);
    }

    @DeleteMapping
    public void deleteAllForms(){
        formService.deleteAllForms();
    }

    // TODO: sending wrong information
    @GetMapping
    public ResponseEntity<List<PatientLogForm>> getStudentsForm(@RequestParam("studentId") Optional<Integer> studentId,
                                                                @RequestParam("coordinatorId") Optional<Integer> coordinatorId,
                                                                @RequestParam("attendingId") Optional<Integer> attendingId,
                                                                @RequestParam("status") String status){

        return formService.getFormsById(studentId,attendingId,coordinatorId,status);
    }

}
