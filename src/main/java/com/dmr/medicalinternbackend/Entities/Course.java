package com.dmr.medicalinternbackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Course_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    List<Speciality> specialities;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    List<Student> students;
}
