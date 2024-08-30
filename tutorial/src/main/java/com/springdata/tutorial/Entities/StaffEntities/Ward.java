package com.springdata.tutorial.Entities.StaffEntities;

import jakarta.persistence.*;
import java.util.Set;

import lombok.*;

@Entity
@Data
@Table(name = "wards")
public class Ward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int wardNumber;
    private int bedCount;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne
    @JoinColumn(name = "supervisor_id")
    private Nurse supervisor;

    @OneToMany(mappedBy = "ward")
    private Set<Patient> patients;
}
