package com.dmr.medicalinternbackend.DAO;

import com.dmr.medicalinternbackend.Entities.AttendingPhysician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendingDataAccess extends JpaRepository<AttendingPhysician, Integer> {
}
