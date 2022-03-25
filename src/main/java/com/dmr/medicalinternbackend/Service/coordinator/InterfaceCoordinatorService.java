package com.dmr.medicalinternbackend.Service.coordinator;

import com.dmr.medicalinternbackend.Entities.Coordinator;

import java.util.List;

public interface InterfaceCoordinatorService {

    List<Coordinator> getAllCoordinators();
    Coordinator getCoordinatorById(int id);
}
