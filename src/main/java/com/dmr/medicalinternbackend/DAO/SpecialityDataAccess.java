package com.dmr.medicalinternbackend.DAO;

import com.dmr.medicalinternbackend.Entities.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecialityDataAccess extends JpaRepository<Speciality, Integer> {

    List<Speciality> findAllByCourseId(int id);
}
