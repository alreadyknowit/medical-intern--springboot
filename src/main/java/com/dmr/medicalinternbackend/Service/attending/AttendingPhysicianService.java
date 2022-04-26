package com.dmr.medicalinternbackend.Service.attending;

import com.dmr.medicalinternbackend.DAO.AttendingDataAccess;
import com.dmr.medicalinternbackend.Entities.AttendingPhysician;
import com.dmr.medicalinternbackend.dto.response.AttendingPhysicianResponseDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@AllArgsConstructor
public class AttendingPhysicianService implements IAttendingPhysician {


    private AttendingDataAccess attendingDataAccess;
    private ModelMapper modelMapper;


    @Deprecated
    @Override
    public List<AttendingPhysician> getAttendingsBySpecialtyId(int id) {

        return attendingDataAccess.findBySpecialityId(id);
    }

    @Override
    public Set<AttendingPhysicianResponseDto> getAttendingPhysicians() {
        List<AttendingPhysician> list = attendingDataAccess.findAll();
        Set<AttendingPhysicianResponseDto> dtoSet = new HashSet<>();

        for (AttendingPhysician a : list) {
            dtoSet.add(mapToDto(a));
        }
        return dtoSet;
    }

    public AttendingPhysicianResponseDto mapToDto(AttendingPhysician attendingPhysician) {
        return modelMapper.map(attendingPhysician, AttendingPhysicianResponseDto.class);
    }


}
