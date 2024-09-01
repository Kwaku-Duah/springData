package com.springdata.tutorial.Entities.StaffEntities;


import jakarta.persistence.*;
import lombok.*;





@Entity
@EqualsAndHashCode(callSuper = true) 
@Data
@Table(name = "nurses")
public class Nurse extends Employee {

    private String rotation;
    private double salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}

