package com.springdata.tutorial.Services;

import com.springdata.tutorial.Entities.StaffEntities.Doctor;
import com.springdata.tutorial.Repositories.StaffRepositories.DoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    
    /** 
     * @param doctor
     * @return Doctor
     */
    @Transactional
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Transactional(readOnly = true)
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Doctor> findDoctorById(Long doctorId) {
        return doctorRepository.findById(doctorId);
    }

    @Transactional
    public void deleteDoctor(Long doctorId) {
        if (doctorRepository.existsById(doctorId)) {
            doctorRepository.deleteById(doctorId);
        } else {
            throw new IllegalArgumentException("Doctor with id " + doctorId + " does not exist.");
        }
    }
}
