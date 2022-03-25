package com.dmr.medicalinternbackend.RestApi;

import com.dmr.medicalinternbackend.Entities.Institute;
import com.dmr.medicalinternbackend.Service.institute.IInstituteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/institutes")
public class InstituteController {

    IInstituteService instituteService;


    public InstituteController(IInstituteService instituteService) {
        this.instituteService =instituteService ;
    }

    @GetMapping
    public List<Institute> getAllStudents(){
        return instituteService.getAllInstitutes();
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Institute>> getStudentById(@PathVariable("id") int id){
        return new ResponseEntity<>(instituteService.getInstituteById(id), HttpStatus.OK);
    }

}
