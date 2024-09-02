/**
 * The WardController class in a Spring Boot application provides REST endpoints for managing Ward
 * entities using JPA.
 */
package com.springdata.tutorial.Controllers.JPA;

import com.springdata.tutorial.Entities.StaffEntities.Ward;
import com.springdata.tutorial.Services.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jpa/wards")
public class WardController {

    @Autowired
    private WardService wardService;

    
    /** 
     * @param ward
     * @return Ward
     */
    @PostMapping
    public Ward saveWard(@RequestBody Ward ward) {
        return wardService.saveWard(ward);
    }

    @GetMapping("/{id}")
    public Optional<Ward> findWardById(@PathVariable Long id) {
        return wardService.findWardById(id);
    }

    @GetMapping
    public List<Ward> getAllWards() {
        return wardService.getAllWards();
    }

    @DeleteMapping("/{id}")
    public void deleteWard(@PathVariable Long id) {
        wardService.deleteWard(id);
    }
}
