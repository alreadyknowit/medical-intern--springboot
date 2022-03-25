package com.dmr.medicalinternbackend.Service.institute;

import com.dmr.medicalinternbackend.Entities.Institute;

import java.util.List;
import java.util.Optional;

public interface IInstituteService {

    List<Institute> getAllInstitutes();
    Optional<Institute> getInstituteById(int id);
}
