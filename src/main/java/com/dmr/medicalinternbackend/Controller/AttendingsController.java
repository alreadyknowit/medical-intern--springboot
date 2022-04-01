package com.dmr.medicalinternbackend.Controller;
import com.dmr.medicalinternbackend.Entities.AttendingPhysician;
import com.dmr.medicalinternbackend.Service.attending.IAttendingPhysician;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attending-physicians")
public class AttendingsController {


    IAttendingPhysician attendingService;

    public AttendingsController(IAttendingPhysician attendingService) {
        this.attendingService = attendingService;
    }

    @GetMapping
    public ResponseEntity<List<AttendingPhysician>> getAttendings(@RequestParam("specialityId") int id){
        return attendingService.getAttendingPhysiciansBySpeciality(id);
    }

    @GetMapping("{specialityId}")
    public ResponseEntity<AttendingPhysician> getAttendingBySpecialityId(@PathVariable("specialityId") int id){
        return new ResponseEntity<>(attendingService.getAttendingById(id), HttpStatus.OK);
    }


}
