package com.springdata.tutorial.Controllers.JPA;

import com.springdata.tutorial.Entities.StaffEntities.Patient;
import com.springdata.tutorial.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jpa/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    
    /** 
     * @param patient
     */
    @PostMapping
    public void savePatient(@RequestBody Patient patient) {
        patientService.savePatient(patient);
    }

    @GetMapping("/{id}")
    public Optional<Patient> findPatientById(@PathVariable Long id) {
        return patientService.findPatientById(id);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
}
