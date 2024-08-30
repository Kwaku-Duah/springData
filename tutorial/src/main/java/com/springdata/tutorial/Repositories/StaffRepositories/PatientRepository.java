package com.springdata.tutorial.Repositories.StaffRepositories;

import com.springdata.tutorial.Entities.StaffEntities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    
    // Find patients by diagnosis
    List<Patient> findByDiagnosis(String diagnosis);
    
    // Find patients by ward ID
    List<Patient> findByWardId(Long wardId);
    
    // Find patients assigned to a specific doctor
    List<Patient> findByDoctorId(Long doctorId);

    // Find patients by surname
    List<Patient> findBySurname(String surname);
    
    // Find patients by address
    List<Patient> findByAddress(String address);
}
