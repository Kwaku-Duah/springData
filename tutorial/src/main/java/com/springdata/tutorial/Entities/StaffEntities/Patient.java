package com.springdata.tutorial.Entities.StaffEntities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int patientNumber;
    private String name;
    private String surname;
    private String address;
    private String phoneNumber;
    private String diagnosis;

    @ManyToOne
    @JoinColumn(name = "ward_id")
    private Ward ward;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
