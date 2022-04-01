package com.dmr.medicalinternbackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "speciality")
public class Speciality {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "speciality",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<AttendingPhysician> attendings;

    @OneToMany(mappedBy = "speciality")
    @JsonIgnore
    private List<ProcedureForm> procedureForms;

    @OneToMany(mappedBy = "speciality")
    @JsonIgnore
    private List<PatientLogForm> patientLogForms;

    @ManyToOne
    @JoinColumn(nullable = false,name = "Course_id")
    private Course course;

    @OneToMany(mappedBy = "speciality")
    @JsonIgnore
    private List<Diagnosis> diagnoses;
}

