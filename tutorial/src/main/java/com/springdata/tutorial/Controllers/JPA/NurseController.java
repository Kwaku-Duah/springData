
package com.springdata.tutorial.Controllers.JPA;

import com.springdata.tutorial.Entities.StaffEntities.Nurse;
import com.springdata.tutorial.Services.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jpa/nurses")
public class NurseController {

    @Autowired
    private NurseService nurseService;

    
    /** 
     * @param nurse
     * @return Nurse
     */
    @PostMapping
    public Nurse saveNurse(@RequestBody Nurse nurse) {
        return nurseService.saveNurse(nurse);
    }

    @GetMapping("/{id}")
    public Optional<Nurse> findNurseById(@PathVariable Long id) {
        return nurseService.findNurseById(id);
    }

    @GetMapping
    public List<Nurse> getAllNurses() {
        return nurseService.getAllNurses();
    }

    @PutMapping
    public void updateNurseDetails(@RequestBody Nurse nurse) {
        nurseService.updateNurseDetails(nurse);
    }

    @DeleteMapping("/{id}")
    public void deleteNurse(@PathVariable Long id) {
        nurseService.deleteNurse(id);
    }
}
