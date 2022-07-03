package com.dmr.medicalinternbackend.Entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "procedure_form")
public class ProcedureForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "Student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "Course_id", nullable = false)
    private Course course;
    @ManyToOne
    @JoinColumn(name = "Attending_id", nullable = false)
    private AttendingPhysician attending;

    @Column(name="kayit_no")
    private String kayitNo;
    @ManyToOne
    @JoinColumn(name = "Speciality_id", nullable = false)
    private Speciality speciality;

    @ManyToOne
    @JoinColumn(name = "Coordinator_id", nullable = false)
    private Coordinator coordinator;

    @Column(name = "tibbi_uygulama")
    private String tibbiUygulama;

    @Column(name = "Etkilesim_turu", nullable = false)
    private String etkilesimTuru;

    @Column(name = "Gerceklestigi_ortam", nullable = false)
    private String gerceklestigiOrtam;

    @Column(name = "status", nullable = false)
    private String status;

    @CreationTimestamp
    @Column(name="created_at")
    private Date createdAt;



    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;


}
