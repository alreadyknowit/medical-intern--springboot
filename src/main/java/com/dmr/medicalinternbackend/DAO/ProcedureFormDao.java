package com.dmr.medicalinternbackend.DAO;

import com.dmr.medicalinternbackend.Entities.ProcedureForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedureFormDao extends JpaRepository<ProcedureForm,Integer> {
}
