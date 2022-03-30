package com.dmr.medicalinternbackend.requests;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProcedureDto {

    private int id;
    private String tibbiUygulama;
    private String etkilesimTuru;
    private String gerceklestigiOrtam;
    private int studentId;
    private int attendingId;
    private int coordinatorId;
    private String status;
}
