package com.dmr.medicalinternbackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "attending")
public class AttendingPhysician {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "Attending_id")
    private int id;

    @Column(name = "Attending_name",nullable = false)
    private String fullname;

    @Column(name = "Phone_no", nullable = false)
    private String phoneNo;

/*
    @OneToMany(mappedBy = "attending")
    private List<Form> forms;
*/


    @ManyToOne
    @JoinColumn(name = "Institute_id",nullable = false)
    private Institute institute;

    @OneToMany(mappedBy = "attending", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Form> forms;

    @ManyToOne
    @JoinColumn(name = "Speciality_id", nullable = false)
    private Speciality speciality;




}
