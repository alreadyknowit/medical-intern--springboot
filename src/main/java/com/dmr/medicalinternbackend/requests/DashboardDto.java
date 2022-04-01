package com.dmr.medicalinternbackend.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DashboardDto {

    private int id;
    private long oasisId;
    private int noProcedures;
    private int noPatientLogs;
    private String courseName;
    private int total;
}
