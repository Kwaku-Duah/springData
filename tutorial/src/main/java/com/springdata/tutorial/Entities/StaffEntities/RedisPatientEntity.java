package com.springdata.tutorial.Entities.StaffEntities;


import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

@Data
@RedisHash
public class RedisPatientEntity implements Serializable {
    private String id;
    private String name;
    private int age;
    private String condition;
    private String bedNumber;

    public RedisPatientEntity() {}

    public RedisPatientEntity(String id, String name, int age, String condition, String bedNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.condition = condition;
        this.bedNumber = bedNumber;
    }
}

