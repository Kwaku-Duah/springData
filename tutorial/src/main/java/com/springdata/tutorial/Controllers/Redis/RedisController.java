package com.springdata.tutorial.Controllers.Redis;

import com.springdata.tutorial.Entities.StaffEntities.RedisPatientEntity;
import com.springdata.tutorial.Services.Redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    
    /** 
     * @param patient
     * @return RedisPatientEntity
     */
    @PostMapping("/patient")
    public RedisPatientEntity savePatientData(@RequestBody RedisPatientEntity patient) {
        redisService.savePatientData(patient);
        return patient;
    }

    @GetMapping("/patient/{id}")
    public RedisPatientEntity getPatientData(@PathVariable String id) {
        return redisService.getPatientData(id);
    }

    @DeleteMapping("/patient/{id}")
    public String deletePatientData(@PathVariable String id) {
        redisService.deletePatientData(id);
        return "Patient data deleted from Redis";
    }

    @GetMapping("/patients")
    public List<RedisPatientEntity> getAllPatientData() {
        return redisService.getAllPatientData();
    }
}
