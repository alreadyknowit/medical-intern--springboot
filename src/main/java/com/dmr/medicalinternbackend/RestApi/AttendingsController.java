package com.dmr.medicalinternbackend.RestApi;
import com.dmr.medicalinternbackend.Entities.AttendingPhysician;
import com.dmr.medicalinternbackend.Service.attending.InterfaceAttendingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/attending-physicians")
public class AttendingsController {


    InterfaceAttendingService attendingService;

    public AttendingsController(InterfaceAttendingService attendingService) {
        this.attendingService = attendingService;
    }

    @GetMapping
    public List<AttendingPhysician> getAllAttending(){
        return attendingService.getAllAttendingPhysicians();
    }

    @GetMapping("{id}")
    public ResponseEntity<AttendingPhysician> getAttendingById(@PathVariable("id") int id){
        return new ResponseEntity<>(attendingService.getAttendingById(id), HttpStatus.OK);
    }


}
