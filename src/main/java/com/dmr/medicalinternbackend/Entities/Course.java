package com.dmr.medicalinternbackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


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

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    Set<Student> students;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    List<PatientLogForm> patientLogForms;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    List<ProcedureForm> procedureForms;

    private int total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(List<Speciality> specialities) {
        this.specialities = specialities;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
