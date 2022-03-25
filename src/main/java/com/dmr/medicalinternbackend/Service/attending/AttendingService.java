package com.dmr.medicalinternbackend.Service.attending;

import com.dmr.medicalinternbackend.DAO.AttendingDataAccess;
import com.dmr.medicalinternbackend.Entities.AttendingPhysician;
import com.dmr.medicalinternbackend.Exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AttendingService implements InterfaceAttendingService{


    AttendingDataAccess attendingDataAccess;

    @Override
    public AttendingPhysician getAttendingById(int id) {

           return attendingDataAccess.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Attending Physician", "ID", id));
    }

    @Override
    public List<AttendingPhysician> getAllAttendingPhysicians() {
        return attendingDataAccess.findAll();
    }
}
