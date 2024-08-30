package com.springdata.tutorial.Repositories.StaffRepositories;

import com.springdata.tutorial.Entities.StaffEntities.Ward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WardRepository extends JpaRepository<Ward, Long> {
    
    // Find wards by ward number
    List<Ward> findByWardNumber(int wardNumber);
    
    // Find wards by department ID
    List<Ward> findByDepartmentId(Long departmentId);

    // Find wards by bed count
    List<Ward> findByBedCountGreaterThan(int bedCount);
}
