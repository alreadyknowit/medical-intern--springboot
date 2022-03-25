package com.dmr.medicalinternbackend.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "diagnosis")
public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Diagnosis_name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "Speciality_id", nullable = false)
    private Speciality speciality;


}
