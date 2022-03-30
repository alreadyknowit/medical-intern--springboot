package com.dmr.medicalinternbackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "attending")
public class AttendingPhysician {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "Attending_id")
    private int id;

    @Column(name = "Attending_name",nullable = false)
    private String attendingName;

    @Column(name = "Phone_no", nullable = false)
    private String phoneNo;


    @ManyToOne
    @JoinColumn(name = "Institute_id",nullable = false)
    private Institute institute;

    @OneToMany(mappedBy = "attending")
    @JsonIgnore
    private List<PatientLogForm> patientLogForms;

    @OneToMany(mappedBy = "attending")
    @JsonIgnore
    private List<ProcedureForm> procedureForms;

    @ManyToOne
    @JoinColumn(name = "Speciality_id", nullable = false)
    private Speciality speciality;



/*

--homepage
formData.setGerce(valueOrtam.getGerceklsestiğiOrtam());
formData.setAttending(secielenobje.getAttending());

DatabaseService.httpInsert(fromData);


-- db service
httpInsert(FormData form){

http.post(
"ortam": form.getOrtam(),
"attending":form.getAtteninG();


}
 */
}
