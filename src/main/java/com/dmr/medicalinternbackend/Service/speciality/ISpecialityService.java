package com.dmr.medicalinternbackend.Service.speciality;

import com.dmr.medicalinternbackend.Entities.Speciality;
import com.dmr.medicalinternbackend.dto.response.SpecialityResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface ISpecialityService {
    ResponseEntity<List<Speciality>> getSpecialityByCourseId(int id);
    //get all specialities using SpecialityDto
    Set<SpecialityResponseDto> getSpecialities();
}
