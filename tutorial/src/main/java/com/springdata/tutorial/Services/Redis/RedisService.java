package com.springdata.tutorial.Services.Redis;

import com.springdata.tutorial.Entities.StaffEntities.RedisPatientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class RedisService {

    private static final String PATIENT_KEY_PREFIX = "PATIENT:";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate; 

    @Resource(name = "redisTemplate")
    private HashOperations<String, String, Object> hashOps;

    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> valueOps;

    @Resource(name = "redisTemplate")
    private ListOperations<String, Object> listOps;

    // Save or update patient data in Redis using Hashes
    public void savePatientData(RedisPatientEntity patient) {
        Map<String, Object> patientData = Map.of(
            "id", patient.getId(),
            "name", patient.getName(),
            "age", patient.getAge(),
            "condition", patient.getCondition(),
            "bedNumber", patient.getBedNumber()
        );

        hashOps.putAll(PATIENT_KEY_PREFIX + patient.getId(), patientData);
    }

    // Retrieve patient data from Redis
    public RedisPatientEntity getPatientData(String patientId) {
        Map<String, Object> entries = hashOps.entries(PATIENT_KEY_PREFIX + patientId);
        if (entries.isEmpty()) return null;

        return mapToPatientEntity(entries);
    }

    // Delete patient data from Redis
    public void deletePatientData(String patientId) {
        Set<String> keys = hashOps.keys(PATIENT_KEY_PREFIX + patientId);
        if (keys != null) {
            hashOps.delete(PATIENT_KEY_PREFIX + patientId, keys.toArray());
        }
    }

    // Fetch all patient data from Redis
    public List<RedisPatientEntity> getAllPatientData() {
        Set<String> keys = redisTemplate.keys(PATIENT_KEY_PREFIX + "*");

        List<RedisPatientEntity> patients = new ArrayList<>();
        if (keys != null) {
            for (String key : keys) {
                Map<String, Object> entries = hashOps.entries(key);
                if (!entries.isEmpty()) {
                    RedisPatientEntity patient = mapToPatientEntity(entries);
                    patients.add(patient);
                }
            }
        }
        return patients;
    }

    // Helper method to map entries to RedisPatientEntity
    private RedisPatientEntity mapToPatientEntity(Map<String, Object> entries) {
        RedisPatientEntity patient = new RedisPatientEntity();
        patient.setId((String) entries.get("id"));
        patient.setName((String) entries.get("name"));
        patient.setAge((Integer) entries.get("age"));
        patient.setCondition((String) entries.get("condition"));
        patient.setBedNumber((String) entries.get("bedNumber"));
        return patient;
    }
}
