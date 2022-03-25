package com.dmr.medicalinternbackend.Service.institute;

import com.dmr.medicalinternbackend.DAO.InstituteDataAccess;
import com.dmr.medicalinternbackend.Entities.Institute;
import com.dmr.medicalinternbackend.Exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InstituteService implements IInstituteService{


    InstituteDataAccess instituteDataAccess;


    @Override
    public List<Institute> getAllInstitutes() {
        return instituteDataAccess.findAll();
    }

    @Override
    public Optional<Institute> getInstituteById(int id) {
        return instituteDataAccess.findById(id).map(Optional::of).orElseThrow(()->new ResourceNotFoundException("Institute","ID",id));
    }
}
