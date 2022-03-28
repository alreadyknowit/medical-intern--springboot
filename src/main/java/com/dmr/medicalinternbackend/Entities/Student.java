package com.dmr.medicalinternbackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "Student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Student_name",nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(nullable = false,name = "Course_id")
    private Course course;

    @Column(name="Oasis_id", nullable = false)
    private Long oasisID;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<PatientLogForm> patientLogForms;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<ProcedureForm> procedureForms;
}
