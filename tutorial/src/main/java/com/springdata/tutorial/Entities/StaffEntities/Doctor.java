package com.springdata.tutorial.Entities.StaffEntities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@EqualsAndHashCode(callSuper = true) 
@Data
@Table(name = "doctors")
public class Doctor extends Employee {

    private String specialty;

    // Many-to-one relationship with Department
    @ManyToOne(fetch = FetchType.LAZY) // or FetchType.EAGER, depending on your needs
    @JoinColumn(name = "department_id")
    private Department department;
}
