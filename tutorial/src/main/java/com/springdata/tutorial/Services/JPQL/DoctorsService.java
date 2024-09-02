package com.springdata.tutorial.Services.JPQL;



import com.springdata.tutorial.Entities.JPQL.Doctorsjpa;
import com.springdata.tutorial.Repositories.JPQLRepository.DoctorsjpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorsService {

    @Autowired
    private DoctorsjpaRepository doctorsRepository;


     
     /** 
      * @param doctor
      * @return Doctorsjpa
      */
     // Method to add a new doctor
     public Doctorsjpa addDoctor(Doctorsjpa doctor) {
        return doctorsRepository.save(doctor);
    }
    // Method to find doctors by specialization
    public List<Doctorsjpa> findDoctorsBySpecialization(String specialization) {
        return doctorsRepository.findBySpecialization(specialization);
    }

    // Method to find doctors by specialization with pagination and sorting
    public Page<Doctorsjpa> findDoctorsBySpecializationPaginated(String specialization, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return doctorsRepository.findBySpecialization(specialization, pageable);
    }

    // Method to find doctors using specifications
    public List<Doctorsjpa> findDoctors(Specification<Doctorsjpa> spec) {
        return doctorsRepository.findAll(spec);
    }
}
