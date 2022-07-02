package com.dmr.medicalinternbackend.DAO;

import com.dmr.medicalinternbackend.Entities.ProcedureForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcedureFormDataAccess extends JpaRepository<ProcedureForm,Integer> {

    List<ProcedureForm> findAllByStudentIdAndStatus(int id,String status);
    List<ProcedureForm> findAllByAttendingIdAndStatus(int id,String status);
    List<ProcedureForm> findAllByCoordinatorIdAndStatus(int id,String status);


}
