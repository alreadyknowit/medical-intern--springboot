package com.dmr.medicalinternbackend.Controller;

import com.dmr.medicalinternbackend.Entities.Speciality;
import com.dmr.medicalinternbackend.Service.speciality.ISpecialityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/specialities")
public class SpecialitiesController {

    private final ISpecialityService specialityService;

    public SpecialitiesController(ISpecialityService specialityService) {
        this.specialityService = specialityService;
    }


    @GetMapping
    public ResponseEntity<List<Speciality>> getSpecialitiesByCourseId(@RequestParam("courseId") int id){
        return specialityService.getSpecialityByCourseId(id);
    }
}
