package com.dmr.medicalinternbackend.DAO;

import com.dmr.medicalinternbackend.Entities.Institute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstituteDataAccess extends JpaRepository<Institute,Integer> {
}
