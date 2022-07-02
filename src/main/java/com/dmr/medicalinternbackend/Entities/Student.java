package com.dmr.medicalinternbackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "Student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Student_name",nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;
    @ManyToMany
      private Set<Course> courses;

    @Column(name="Oasis_id", nullable = false)
    private Long oasisID;

    @OneToMany(mappedBy = "student",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<PatientLogForm> patientLogForms;

    @OneToMany(mappedBy = "student",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ProcedureForm> procedureForms;



}
