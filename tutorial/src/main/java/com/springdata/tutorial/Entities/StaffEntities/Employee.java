package com.springdata.tutorial.Entities.StaffEntities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String surname;
    private String address;
    private String phoneNumber;

}
