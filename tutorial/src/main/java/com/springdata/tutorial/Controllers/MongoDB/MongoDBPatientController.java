package com.springdata.tutorial.Controllers.MongoDB;



import com.springdata.tutorial.Entities.MongoDBEntities.Patient;
import com.springdata.tutorial.Services.MongoDB.MongoDBPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mongodb/patients")
public class MongoDBPatientController {

    @Autowired
    private MongoDBPatientService mongoDBPatientService;

    
    /** 
     * @param patient
     * @return Patient
     */
    @PostMapping
    public Patient savePatient(@RequestBody Patient patient) {
        return mongoDBPatientService.savePatient(patient);
    }

    @GetMapping("/{id}")
    public Optional<Patient> findPatientById(@PathVariable String id) {
        return mongoDBPatientService.findPatientById(id);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return mongoDBPatientService.getAllPatients();
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable String id) {
        mongoDBPatientService.deletePatient(id);
    }
}
