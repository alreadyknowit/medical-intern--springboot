package com.dmr.medicalinternbackend.DAO;

import com.dmr.medicalinternbackend.Entities.PatientLogForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PatientLogDataAccess extends JpaRepository<PatientLogForm, Integer> {

    //@Query(" from PatientLogForm where student.id = :studentId")


    List<PatientLogForm> findByStudentIdAndStatus(int id,String status);

    List<PatientLogForm> findAllByAttendingIdAndStatus(int id,String status);

    List<PatientLogForm> findAllByCoordinatorIdAndStatus(int id,String status);

    List<PatientLogForm> findAllByStudentIdAndCoordinatorIdAndStatus(int sid, int cid, String status);

    List<PatientLogForm> findAllByStudentIdAndAttendingIdAndStatus(int sid, int aid, String status);

    List<PatientLogForm> findAllByAttendingIdAndCoordinatorIdAndStatus(int aid, int cid, String status);

    List<PatientLogForm> findAllByStudentIdAndAttendingIdAndCoordinatorIdAndStatus(int sid,int aid, int cid, String status);

    List<PatientLogForm> findByStudentIdAndAndAttendingIdAndCoordinatorIdAndStatus(int sid,int aid, int cid, String status);


}
