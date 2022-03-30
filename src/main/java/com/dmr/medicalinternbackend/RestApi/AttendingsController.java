package com.dmr.medicalinternbackend.RestApi;
import com.dmr.medicalinternbackend.Entities.AttendingPhysician;
import com.dmr.medicalinternbackend.Service.attending.InterfaceAttendingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attending-physicians")
public class AttendingsController {


    InterfaceAttendingService attendingService;

    public AttendingsController(InterfaceAttendingService attendingService) {
        this.attendingService = attendingService;
    }

    @GetMapping
    public ResponseEntity<List<AttendingPhysician>> getAttendings(@RequestParam("specialityId") int id){
        return attendingService.getAllAttendingPhysicians(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<AttendingPhysician> getAttendingById(@PathVariable("id") int id){
        return new ResponseEntity<>(attendingService.getAttendingById(id), HttpStatus.OK);
    }


}
