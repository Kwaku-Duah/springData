package com.springdata.tutorial.Repositories.StaffRepositories;

import com.springdata.tutorial.Entities.StaffEntities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
    // Find departments by name
    List<Department> findByName(String name);
    
    // Find a department by code
    Department findByCode(String code);

    // Find departments by building name
    List<Department> findByBuilding(String building);

    // Find departments with a specific director
    List<Department> findByDirectorId(Long directorId);
}
