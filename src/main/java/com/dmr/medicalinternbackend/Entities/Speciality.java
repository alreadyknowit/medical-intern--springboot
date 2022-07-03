package com.dmr.medicalinternbackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "speciality")
public class Speciality {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "speciality",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<AttendingPhysician> attendings;

    @OneToMany(mappedBy = "speciality")
    @JsonIgnore
    private List<ProcedureForm> procedureForms;

    @OneToMany(mappedBy = "speciality")
    @JsonIgnore
    private List<PatientLogForm> patientLogForms;

    @ManyToOne
    @JoinColumn(nullable = false,name = "Course_id")
    private Course course;

    @OneToMany(mappedBy = "speciality")
    @JsonIgnore
    private List<Diagnosis> diagnoses;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AttendingPhysician> getAttendings() {
        return attendings;
    }

    public void setAttendings(List<AttendingPhysician> attendings) {
        this.attendings = attendings;
    }

    public List<ProcedureForm> getProcedureForms() {
        return procedureForms;
    }

    public void setProcedureForms(List<ProcedureForm> procedureForms) {
        this.procedureForms = procedureForms;
    }

    public List<PatientLogForm> getPatientLogForms() {
        return patientLogForms;
    }

    public void setPatientLogForms(List<PatientLogForm> patientLogForms) {
        this.patientLogForms = patientLogForms;
    }

    public List<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }



    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}

