package com.dmr.medicalinternbackend.DAO;

import com.dmr.medicalinternbackend.Entities.Coordinator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinatorDataAccess extends JpaRepository<Coordinator, Integer> {
}
