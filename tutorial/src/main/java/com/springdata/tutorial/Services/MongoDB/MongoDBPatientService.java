package com.springdata.tutorial.Services.MongoDB;


import com.springdata.tutorial.Entities.MongoDBEntities.Patient;
import com.springdata.tutorial.Repositories.MongoRepositories.PatientMongoRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MongoDBPatientService {

    @Autowired
    private PatientMongoRepository patientRepository;

    
    /** 
     * @param patient
     * @return Patient
     */
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Optional<Patient> findPatientById(String patientId) {
        return patientRepository.findById(patientId);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public void deletePatient(String patientId) {
        if (patientRepository.existsById(patientId)) {
            patientRepository.deleteById(patientId);
        } else {
            throw new IllegalArgumentException("Patient with id " + patientId + " does not exist.");
        }
    }
}
