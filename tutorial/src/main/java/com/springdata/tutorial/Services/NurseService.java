package com.springdata.tutorial.Services;

import com.springdata.tutorial.Entities.StaffEntities.Nurse;
import com.springdata.tutorial.Repositories.StaffRepositories.NurseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class NurseService {

    @Autowired
    private NurseRepository nurseRepository;

    
    /** 
     * @param nurse
     * @return Nurse
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public Nurse saveNurse(Nurse nurse) {
        return nurseRepository.save(nurse);
    }

    @Transactional(readOnly = true)
    public Optional<Nurse> findNurseById(Long nurseId) {
        return nurseRepository.findById(nurseId);
    }

    @Transactional(readOnly = true)
    public List<Nurse> getAllNurses() {
        return nurseRepository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public void updateNurseDetails(Nurse nurse) {
        if (nurseRepository.existsById(nurse.getId())) {
            nurseRepository.save(nurse);
        } else {
            throw new IllegalArgumentException("Nurse with id " + nurse.getId() + " does not exist.");
        }
    }

    @Transactional
    public void deleteNurse(Long nurseId) {
        if (nurseRepository.existsById(nurseId)) {
            nurseRepository.deleteById(nurseId);
        } else {
            throw new IllegalArgumentException("Nurse with id " + nurseId + " does not exist.");
        }
    }
}
