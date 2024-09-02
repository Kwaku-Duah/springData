package com.springdata.tutorial.Controllers.JPA;



import com.springdata.tutorial.Entities.StaffEntities.Doctor;
import com.springdata.tutorial.Services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jpa/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    
    /** 
     * @param doctor
     * @return Doctor
     */
    @PostMapping
    public Doctor saveDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @GetMapping("/{id}")
    public Optional<Doctor> findDoctorById(@PathVariable Long id) {
        return doctorService.findDoctorById(id);
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
    }
}
