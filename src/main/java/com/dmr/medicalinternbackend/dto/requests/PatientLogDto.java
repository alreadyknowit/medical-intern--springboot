package com.dmr.medicalinternbackend.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientLogDto {

    private int id;
    private int coordinatorId;
    private int studentId;
    private int attendingId;
    private int specialityId;
    private String kayitNo;
    private String cinsiyet;
    private int yas;
    private String sikayet;
    private String ayiriciTani;
    private String kesinTani;
    private String tedaviYontemi;
    private String etkilesimTuru;
    private String kapsam;
    private String gerceklestigiOrtam;
    private String status;

}
