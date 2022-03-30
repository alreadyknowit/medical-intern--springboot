package com.dmr.medicalinternbackend.DAO;

import com.dmr.medicalinternbackend.Entities.AttendingPhysician;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendingDataAccess extends JpaRepository<AttendingPhysician, Integer> {

    List<AttendingPhysician> findAllBySpecialityId(int id);
}
