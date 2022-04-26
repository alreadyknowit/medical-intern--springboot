package com.dmr.medicalinternbackend.Service.attending;


import com.dmr.medicalinternbackend.Entities.AttendingPhysician;
import com.dmr.medicalinternbackend.dto.response.AttendingPhysicianResponseDto;

import java.util.List;
import java.util.Set;

public interface IAttendingPhysician {

    //get attending by specific speciality id
    List<AttendingPhysician> getAttendingsBySpecialtyId(int id);

    //get all attending using AttendingResponse Dto
    Set<AttendingPhysicianResponseDto> getAttendingPhysicians();

}
