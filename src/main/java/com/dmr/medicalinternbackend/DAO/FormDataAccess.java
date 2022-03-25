package com.dmr.medicalinternbackend.DAO;

import com.dmr.medicalinternbackend.Entities.Form;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface FormDataAccess extends JpaRepository<Form, Integer> {

    //select* from form where kayitNo=$kayit
    List<Form> findByKayitNo(String kayit);

    //select* from form where kayitNo LIKE '%$text%'
    List<Form> findByKayitNoContaining(String keyword, Sort sort);


    @Query(" from Form where student.id = :studentId")
    List<Form> findFormByStudentId(int studentId);

    List<Form> findAllByAttendingId(int id);

    List<Form> findAllByAttendingIdAndCoordinatorId(int aid, int cid);


}
