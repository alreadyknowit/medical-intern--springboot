package com.dmr.medicalinternbackend.Service.attending;


import com.dmr.medicalinternbackend.Entities.AttendingPhysician;

import java.util.List;

public interface InterfaceAttendingService {

    AttendingPhysician getAttendingById(int id);
    List<AttendingPhysician> getAllAttendingPhysicians();
}
