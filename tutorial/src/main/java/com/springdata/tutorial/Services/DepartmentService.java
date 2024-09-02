package com.springdata.tutorial.Services;

import com.springdata.tutorial.Entities.StaffEntities.Department;
import com.springdata.tutorial.Repositories.StaffRepositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    
    /** 
     * @return List<Department>
     */
    @Cacheable("departments")
    @Transactional(readOnly = true)
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Cacheable(value = "departments", key = "#departmentId")
    @Transactional(readOnly = true)
    public Optional<Department> findDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId);
    }

    @CacheEvict(value = "departments", allEntries = true)
    @Transactional
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @CacheEvict(value = "departments", key = "#department.id")
    @Transactional
    public Department updateDepartment(Department department) {
        if (departmentRepository.existsById(department.getId())) {
            return departmentRepository.save(department);
        } else {
            throw new IllegalArgumentException("Department with id " + department.getId() + " does not exist.");
        }
    }

    @CacheEvict(value = "departments", key = "#departmentId")
    @Transactional
    public void deleteDepartment(Long departmentId) {
        if (departmentRepository.existsById(departmentId)) {
            departmentRepository.deleteById(departmentId);
        } else {
            throw new IllegalArgumentException("Department with id " + departmentId + " does not exist.");
        }
    }
}
