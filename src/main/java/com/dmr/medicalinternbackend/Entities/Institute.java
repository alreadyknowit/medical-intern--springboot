package com.dmr.medicalinternbackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "institute")
public class Institute {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "institute_name", nullable = false)
    private String name;


    @OneToMany(mappedBy = "institute") @JsonIgnore
    List<AttendingPhysician> attendings;


}
