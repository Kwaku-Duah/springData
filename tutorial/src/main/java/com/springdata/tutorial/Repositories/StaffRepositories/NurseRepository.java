package com.springdata.tutorial.Repositories.StaffRepositories;

import com.springdata.tutorial.Entities.StaffEntities.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NurseRepository extends JpaRepository<Nurse, Long> {
    
    // Find nurses by rotation
    List<Nurse> findByRotation(String rotation);
    
    // Find nurses by department ID
    List<Nurse> findByDepartmentId(Long departmentId);

    // Find nurses by salary range
    List<Nurse> findBySalaryBetween(double minSalary, double maxSalary);
}
