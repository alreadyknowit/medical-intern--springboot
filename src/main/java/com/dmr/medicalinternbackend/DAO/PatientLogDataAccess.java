package com.dmr.medicalinternbackend.DAO;

import com.dmr.medicalinternbackend.Entities.PatientLogForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PatientLogDataAccess extends JpaRepository<PatientLogForm, Integer> {

/*    //select* from form where kayitNo=$kayit
    List<PatientLogForm> findByKayitNo(String kayit);

    //select* from form where kayitNo LIKE '%$text%'
    List<PatientLogForm> findByKayitNoContaining(String keyword, Sort sort);*/


    @Query(" from PatientLogForm where student.id = :studentId")
    List<PatientLogForm> findFormByStudentId(int studentId);

    List<PatientLogForm> findAllByAttendingId(int id);

    List<PatientLogForm> findAllByAttendingIdAndCoordinatorId(int aid, int cid);


}
