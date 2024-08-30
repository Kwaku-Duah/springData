package com.springdata.tutorial.Entities.StaffEntities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(callSuper = true) 
@Data
@Table(name = "doctors")
public class Doctor extends Employee {

    private String specialty;
}
