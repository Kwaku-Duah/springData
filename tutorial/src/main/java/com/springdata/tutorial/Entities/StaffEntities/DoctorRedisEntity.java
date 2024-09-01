package com.springdata.tutorial.Entities.StaffEntities;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import lombok.Data;

import java.io.Serializable;

@Data
@RedisHash("Doctor")
public class DoctorRedisEntity implements Serializable {

    @Id 
    private String id;

    private String name;
    private String specialization;
}
