package com.dmr.medicalinternbackend.DAO;

import com.dmr.medicalinternbackend.Entities.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialityDAO extends JpaRepository<Speciality,Integer> {
}
