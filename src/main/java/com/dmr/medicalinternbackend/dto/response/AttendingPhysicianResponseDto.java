package com.dmr.medicalinternbackend.dto.response;

public class AttendingPhysicianResponseDto {

    private int id;
    private String attendingName;
    private int instituteId;
    private int specialityId;

    private String phoneNo;

    public String getPhoneNo() {

        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

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
