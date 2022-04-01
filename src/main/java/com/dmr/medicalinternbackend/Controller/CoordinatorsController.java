package com.dmr.medicalinternbackend.Controller;

import com.dmr.medicalinternbackend.Entities.Coordinator;
import com.dmr.medicalinternbackend.Service.coordinator.ICoordinatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coordinators")
public class CoordinatorsController {

    private final ICoordinatorService coordinatorService;

    public CoordinatorsController(ICoordinatorService coordinatorService) {
        this.coordinatorService = coordinatorService;
    }

    @GetMapping
    public ResponseEntity<List<Coordinator>> getAll(){
        return new ResponseEntity<>(coordinatorService.getAllCoordinators(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coordinator> getCoordinatorById(@PathVariable int id){
        return new ResponseEntity<>(coordinatorService.getCoordinatorById(id),HttpStatus.OK);
    }
}
