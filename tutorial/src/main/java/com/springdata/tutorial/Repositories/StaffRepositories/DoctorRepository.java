package com.springdata.tutorial.Repositories.StaffRepositories;

import com.springdata.tutorial.Entities.StaffEntities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    
    // Find doctors by specialty
    List<Doctor> findBySpecialty(String specialty);
    
    // Find doctors by their department's ID
    List<Doctor> findByDepartment_Id(Long departmentId); 

  
}
