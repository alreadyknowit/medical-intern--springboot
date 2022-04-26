package com.dmr.medicalinternbackend.Controller;

import com.dmr.medicalinternbackend.Service.speciality.ISpecialityService;
import com.dmr.medicalinternbackend.dto.response.SpecialityResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/specialities")
public class SpecialitiesController {

    private final ISpecialityService specialityService;

    public SpecialitiesController(ISpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @GetMapping
    public Set<SpecialityResponseDto> getSpecialities(){
        return specialityService.getSpecialities();
    }

  /*  @GetMapping
    public ResponseEntity<List<Speciality>> getSpecialitiesByCourseId(@RequestParam("courseId") int id){
        return specialityService.getSpecialityByCourseId(id);
    }*/
}
