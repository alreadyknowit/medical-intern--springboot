package com.dmr.medicalinternbackend.DAO;

import com.dmr.medicalinternbackend.Entities.ProcedureForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcedureFormDataAccess extends JpaRepository<ProcedureForm,Integer> {

    List<ProcedureForm> findByStudentIdAndStatus(int id,String status);
    List<ProcedureForm> findByAttendingIdAndStatus(int id,String status);
    List<ProcedureForm> findByCoordinatorIdAndStatus(int id,String status);


}
