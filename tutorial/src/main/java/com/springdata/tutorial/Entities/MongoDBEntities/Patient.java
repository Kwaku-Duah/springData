package com.springdata.tutorial.Entities.MongoDBEntities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Data
@Document(collection = "patients")
public class Patient {

    @Id
    private String id;
    private String name;

}