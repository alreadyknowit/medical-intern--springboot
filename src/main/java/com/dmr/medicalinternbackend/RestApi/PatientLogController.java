package com.dmr.medicalinternbackend.RestApi;

import com.dmr.medicalinternbackend.Entities.PatientLogForm;
import com.dmr.medicalinternbackend.Service.patientLog.IPatientLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/patient-log")
public class PatientLogController {

private IPatientLogService formService;

    public PatientLogController(IPatientLogService formService) {
        this.formService = formService;
    }

    //insert a new form
    @PostMapping
    public ResponseEntity<PatientLogForm> insertForm(@RequestBody PatientLogForm patientLogForm){
        return new ResponseEntity<>(formService.insertForm(patientLogForm), HttpStatus.CREATED);
    }

    //get all forms
    @GetMapping
    public List<PatientLogForm> getAllForms(){
        return this.formService.getAllForms();
    }

    //get form with specific id
    @GetMapping("{id}")
    public ResponseEntity<PatientLogForm> getFormById(@PathVariable("id") int id){
      return new ResponseEntity<>(formService.getById(id),HttpStatus.OK);
    }

    //update form info
    @PutMapping("{id}")
    public ResponseEntity<PatientLogForm> updateForm(@RequestBody PatientLogForm patientLogForm, @PathVariable("id") int id){

        return new ResponseEntity<>(formService.updateForm(patientLogForm, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void deleteForm(@PathVariable("id") int id){
        formService.deleteForm(id);

    }
    @DeleteMapping
    public void deleteAllForms(){
        formService.deleteAllForms();
    }

    @GetMapping("/filter")
    public ResponseEntity<List<PatientLogForm>> findByAttendingIdAndCoordinatorId(@RequestParam int aid, @RequestParam int cid){

        return new ResponseEntity<>(formService.findByAttendingIdAndCoordinatorId(aid,cid),HttpStatus.OK);
    }




  /*  @GetMapping("/filter")
    public ResponseEntity<List<Form>> findByKayitNo(@RequestParam("kayitNo") String kayit){
    return new ResponseEntity<>(formService.findByKayitNo(kayit),HttpStatus.OK);
    }*/
  /*  @GetMapping("/filterByKeyword")
    public ResponseEntity<List<Form>> findByKayitNoContaining(@RequestParam String key){
        return new ResponseEntity<>(formService.findByKayitNoContaining(key),HttpStatus.OK);
    }
*/
 /*   @GetMapping("/student/{id}")
    public ResponseEntity<List<Form>> findByStudentId(@PathVariable int id){
        return new ResponseEntity<>(formService.findByStudentId(id), HttpStatus.OK);
    }*/
/*    @GetMapping("/attendings")
    public ResponseEntity<List<Form>> findByAttendingId(@RequestParam int attendingId){
        return new ResponseEntity<>(formService.findByAttendingId(attendingId),HttpStatus.OK );
    }*/


}
