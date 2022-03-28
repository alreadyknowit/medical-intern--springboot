package com.dmr.medicalinternbackend.Entities;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="patient_log")
public class PatientLogForm {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "Student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "Attending_id", nullable = false)
    private AttendingPhysician attending;

    @ManyToOne
    @JoinColumn(name = "Coordinator_id", nullable = false)
    private Coordinator coordinator;

    @Column(name = "Kayit_no", nullable = false)
    private String kayitNo;

    @Column(name = "Staj_turu", nullable = false)
    private String stajTuru;

    @Column(name = "Yas", nullable = false)
    private int yas;

    @Column(name = "Cinsiyet", nullable = false)
    private String cinsiyet;

    @Column(name = "Sikayet", nullable = false)
    private String sikayet;

    @Column(name = "Ayirici_tani", nullable = false)
    private String ayiriciTani;

    @Column(name = "Kesin_tani", nullable = false)
    private String kesinTani;

    @Column(name = "Tedavi_yontemi", nullable = false)
    private String tedaviYontemi;

    @Column(name = "Etkilesim_turu", nullable = false)
    private String etkilesimTuru;

    @Column(name = "Kapsam", nullable = false)
    private String kapsam;

    @Column(name = "Gerceklestigi_ortam", nullable = false)
    private String gerceklestigiOrtam;

    @Column(name = "Status", nullable = false)
    private String status;

    @CreationTimestamp
    @Column(name="created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

}
