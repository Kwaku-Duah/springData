package com.springdata.tutorial.Services;



import com.springdata.tutorial.Entities.StaffEntities.Ward;
import com.springdata.tutorial.Repositories.StaffRepositories.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WardService {

    @Autowired
    private WardRepository wardRepository;

    
    /** 
     * @param ward
     * @return Ward
     */
    public Ward saveWard(Ward ward) {
        return wardRepository.save(ward);
    }

    
    /** 
     * @param wardId
     * @return Optional<Ward>
     */
    public Optional<Ward> findWardById(Long wardId) {
        return wardRepository.findById(wardId);
    }

    public List<Ward> getAllWards() {
        return wardRepository.findAll();
    }

    public void deleteWard(Long wardId) {
        if (wardRepository.existsById(wardId)) {
            wardRepository.deleteById(wardId);
        } else {
            throw new IllegalArgumentException("Ward with id " + wardId + " does not exist.");
        }
    }
}
