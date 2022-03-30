package com.dmr.medicalinternbackend.Service.attending;


import com.dmr.medicalinternbackend.Entities.AttendingPhysician;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InterfaceAttendingService {

    AttendingPhysician getAttendingById(int id);
    ResponseEntity<List<AttendingPhysician>> getAllAttendingPhysicians(int id);
}
