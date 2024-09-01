package com.springdata.tutorial.Entities.StaffEntities;

import jakarta.persistence.*;
import java.util.Set;

import lombok.*;



@Entity
@Data
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String name;
    private String building;

    @OneToOne
    @JoinColumn(name = "director_id")
    private Doctor director;

    @OneToMany(mappedBy = "department")
    private Set<Ward> wards;
}
