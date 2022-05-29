package com.dmr.medicalinternbackend.dto.requests;

import com.dmr.medicalinternbackend.Entities.Course;
import com.dmr.medicalinternbackend.Entities.Speciality;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Set;

@Getter
@Setter
public class ProfileDto {

    private int id;
    private long oasisId;
    private int noProcedures;
    private int noPatientLogs;
    private Set<Course> courses;
    private Set<Speciality> specialities;
    private HashMap<String,Integer> courseIdCompletedAmount;
    private int numberOfPatientLogs;
    private int numberOfProcedures;
}
