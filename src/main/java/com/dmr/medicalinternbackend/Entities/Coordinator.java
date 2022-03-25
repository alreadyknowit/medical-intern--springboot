package com.dmr.medicalinternbackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="coordinator")
public class Coordinator {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "Oasis_id",nullable = false)
    private Long oasisId;

    @OneToMany(mappedBy = "coordinator")
    @JsonIgnore
    private List<Form> forms;

}
