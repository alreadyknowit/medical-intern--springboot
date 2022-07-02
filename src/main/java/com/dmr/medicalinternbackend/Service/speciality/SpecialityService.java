package com.dmr.medicalinternbackend.Service.speciality;

import com.dmr.medicalinternbackend.DAO.SpecialityDataAccess;
import com.dmr.medicalinternbackend.Entities.Speciality;
import com.dmr.medicalinternbackend.dto.response.SpecialityResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class SpecialityService implements ISpecialityService {

    private final SpecialityDataAccess specialityDataAccess;
    private final ModelMapper modelMapper;


    public SpecialityService(SpecialityDataAccess specialityDataAccess, ModelMapper modelMapper) {
        this.specialityDataAccess = specialityDataAccess;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<List<Speciality>> getSpecialityByCourseId(int id) {

        return new ResponseEntity<>(specialityDataAccess.findAllByCourseId(id), HttpStatus.OK);
    }

    @Override
    public Set<SpecialityResponseDto> getSpecialities() {
        List<Speciality> list = specialityDataAccess.findAll();
        Set<SpecialityResponseDto> dtoSet = new HashSet<>();
        for (Speciality s : list) {
            dtoSet.add(mapToDto(s));
        }
        return dtoSet;
    }

    public SpecialityResponseDto mapToDto(Speciality speciality) {
        return modelMapper.map(speciality, SpecialityResponseDto.class);
    }
}
