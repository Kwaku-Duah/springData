package com.springdata.tutorial.Entities.StaffEntities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Data
@Table(name = "wards")
public class Ward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int wardNumber;
    private int bedCount;

    @ManyToOne(fetch = FetchType.EAGER) // Ensure this is EAGER
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne(fetch = FetchType.EAGER) // Ensure this is EAGER
    @JoinColumn(name = "supervisor_id")
    private Nurse supervisor;

    @OneToMany(mappedBy = "ward")
    private Set<Patient> patients;
}

