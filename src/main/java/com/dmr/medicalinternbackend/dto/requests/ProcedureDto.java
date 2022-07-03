package com.dmr.medicalinternbackend.dto.requests;

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
    private int specialityId;
    private int courseId;
    private String kayitNo;
    private String status;

}
