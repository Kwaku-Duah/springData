/**
 * The DoctorsController class in a Spring Boot application provides endpoints for adding doctors,
 * searching doctors by specialization, and retrieving doctors with pagination and sorting.
 */
package com.springdata.tutorial.Controllers.JPQL;

import com.springdata.tutorial.Entities.JPQL.Doctorsjpa;
import com.springdata.tutorial.Services.JPQL.DoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorsController {

    @Autowired
    private DoctorsService doctorsService;

    
    /** 
     * @param doctor
     * @return ResponseEntity<Doctorsjpa>
     */
    // Endpoint to add a new doctor
    @PostMapping
    public ResponseEntity<Doctorsjpa> addDoctor(@RequestBody Doctorsjpa doctor) {
        Doctorsjpa savedDoctor = doctorsService.addDoctor(doctor);
        return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
    }

    // Example endpoint to get doctors by specialization
    @GetMapping("/search")
    public ResponseEntity<List<Doctorsjpa>> findDoctorsBySpecialization(@RequestParam String specialization) {
        List<Doctorsjpa> doctors = doctorsService.findDoctorsBySpecialization(specialization);
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

       // Endpoint to get doctors by specialization with pagination and sorting
       @GetMapping("/search/paginated")
       public ResponseEntity<Page<Doctorsjpa>> findDoctorsBySpecializationPaginated(
           @RequestParam String specialization,
           @RequestParam(defaultValue = "0") int page,
           @RequestParam(defaultValue = "10") int size,
           @RequestParam(defaultValue = "name") String sortBy) {
   
           Page<Doctorsjpa> doctorsPage = doctorsService.findDoctorsBySpecializationPaginated(specialization, page, size, sortBy);
           return new ResponseEntity<>(doctorsPage, HttpStatus.OK);
       }
}
