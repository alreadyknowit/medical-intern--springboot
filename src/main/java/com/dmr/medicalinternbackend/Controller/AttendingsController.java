package com.dmr.medicalinternbackend.Controller;
import com.dmr.medicalinternbackend.Entities.AttendingPhysician;
import com.dmr.medicalinternbackend.Service.attending.IAttendingPhysician;
import com.dmr.medicalinternbackend.dto.response.AttendingPhysicianResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/attending-physicians")
public class AttendingsController {


    private final IAttendingPhysician attendingService;

    public AttendingsController(IAttendingPhysician attendingService) {
        this.attendingService = attendingService;
    }

    @GetMapping
    public Set<AttendingPhysicianResponseDto> getAttendingPhysicians(){
        return attendingService.getAttendingPhysicians();
    }

    /*
    @Deprecated
    @GetMapping
    public ResponseEntity<List<AttendingPhysician>> getAttendingBySpecialityId(@RequestParam("specialityId") int id){
        return new ResponseEntity<>(attendingService.getAttendingsBySpecialtyId(id), HttpStatus.OK);
    }*/


}
