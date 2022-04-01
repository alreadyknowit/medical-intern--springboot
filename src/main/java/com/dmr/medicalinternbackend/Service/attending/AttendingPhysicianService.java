package com.dmr.medicalinternbackend.Service.attending;

import com.dmr.medicalinternbackend.DAO.AttendingDataAccess;
import com.dmr.medicalinternbackend.Entities.AttendingPhysician;
import com.dmr.medicalinternbackend.Exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class AttendingPhysicianService implements IAttendingPhysician {


    private AttendingDataAccess attendingDataAccess;

    @Override
    public com.dmr.medicalinternbackend.Entities.AttendingPhysician getAttendingById(int id) {

           return attendingDataAccess.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Attending Physician", "ID", id));
    }

    @Override
    public ResponseEntity<List<AttendingPhysician>> getAttendingPhysiciansBySpeciality(int specialityId) {
        return new ResponseEntity<>(attendingDataAccess.findAllBySpecialityId(specialityId), HttpStatus.OK);
    }

}
