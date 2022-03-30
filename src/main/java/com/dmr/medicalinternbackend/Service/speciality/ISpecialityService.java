package com.dmr.medicalinternbackend.Service.speciality;

import com.dmr.medicalinternbackend.Entities.Speciality;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ISpecialityService {
    ResponseEntity<List<Speciality>> getSpecialityByCourseId(int id);
}
