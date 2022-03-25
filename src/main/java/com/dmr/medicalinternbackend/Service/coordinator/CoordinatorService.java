package com.dmr.medicalinternbackend.Service.coordinator;

import com.dmr.medicalinternbackend.DAO.CoordinatorDataAccess;
import com.dmr.medicalinternbackend.Entities.Coordinator;
import com.dmr.medicalinternbackend.Exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CoordinatorService implements InterfaceCoordinatorService {


    CoordinatorDataAccess coordinatorDataAccess;
    @Override
    public List<Coordinator> getAllCoordinators() {
        return coordinatorDataAccess.findAll();
    }

    @Override
    public Coordinator getCoordinatorById(int id) {
        return coordinatorDataAccess.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Coordinator", "ID", id)
        );
    }
}
