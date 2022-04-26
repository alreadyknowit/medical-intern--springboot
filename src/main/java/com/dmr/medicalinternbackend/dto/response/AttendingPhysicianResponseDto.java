package com.dmr.medicalinternbackend.dto.response;

public class AttendingPhysicianResponseDto {

    private int id;
    private String attendingName;
    private int instituteId;
    private int specialityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAttendingName() {
        return attendingName;
    }

    public void setAttendingName(String attendingName) {
        this.attendingName = attendingName;
    }

    public int getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(int instituteId) {
        this.instituteId = instituteId;
    }

    public int getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
    }
}
