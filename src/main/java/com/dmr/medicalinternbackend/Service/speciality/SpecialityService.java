package com.dmr.medicalinternbackend.Service.speciality;

import com.dmr.medicalinternbackend.DAO.SpecialityDataAccess;
import com.dmr.medicalinternbackend.Entities.Speciality;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SpecialityService implements ISpecialityService{

    private final SpecialityDataAccess specialityDataAccess;

    public SpecialityService(SpecialityDataAccess specialityDataAccess) {
        this.specialityDataAccess = specialityDataAccess;
    }

    @Override
    public ResponseEntity<List<Speciality>> getSpecialityByCourseId(int id) {

                return new ResponseEntity<>(specialityDataAccess.findAllByCourseId(id), HttpStatus.OK);
    }
}
