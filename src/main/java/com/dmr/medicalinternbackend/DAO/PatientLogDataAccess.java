package com.dmr.medicalinternbackend.DAO;

import com.dmr.medicalinternbackend.Entities.PatientLogForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PatientLogDataAccess extends JpaRepository<PatientLogForm, Integer> {

    //@Query(" from PatientLogForm where student.id = :studentId")


    List<PatientLogForm> findAllByStudentIdAndStatus(int id,String status);

    List<PatientLogForm> findAllByAttendingIdAndStatus(int id,String status);

    List<PatientLogForm> findAllByCoordinatorIdAndStatus(int id,String status);


}
