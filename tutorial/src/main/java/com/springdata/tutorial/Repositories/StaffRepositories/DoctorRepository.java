package com.springdata.tutorial.Repositories.StaffRepositories;

import com.springdata.tutorial.Entities.StaffEntities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    
    // Find doctors by specialty
    List<Doctor> findBySpecialty(String specialty);
    
    // Find doctors by their department's ID
    List<Doctor> findByDepartmentId(Long departmentId);
    
    // Find doctors assigned to a specific patient
    List<Doctor> findByPatientsId(Long patientId);
}
