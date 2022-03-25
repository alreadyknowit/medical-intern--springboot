package com.dmr.medicalinternbackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "speciality")
public class Speciality {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "speciality")
    @JsonIgnore
    private List<AttendingPhysician> attendings;


    @ManyToOne
    @JoinColumn(nullable = false,name = "Course_id")
    private Course course;

    @OneToMany(mappedBy = "speciality")
    @JsonIgnore
    private List<Diagnosis> diagnoses;
}

