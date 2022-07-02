package com.dmr.medicalinternbackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "attending")
public class AttendingPhysician {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "Attending_id")
    private int id;

    @Column(name = "Attending_name",nullable = false)
    private String attendingName;

    @Column(name = "Phone_no", nullable = false)
    private String phoneNo;

    @ManyToOne
    @JoinColumn(name = "Institute_id",nullable = false)
    private Institute institute;

    @OneToMany(mappedBy = "attending")
    @JsonIgnore
    private List<PatientLogForm> patientLogForms;

    @OneToMany(mappedBy = "attending")
    @JsonIgnore
    private List<ProcedureForm> procedureForms;

    @ManyToOne
    @JoinColumn(name = "Speciality_id", nullable = false)
    private Speciality speciality;

    @Column(nullable = false)
    private String password;
}
