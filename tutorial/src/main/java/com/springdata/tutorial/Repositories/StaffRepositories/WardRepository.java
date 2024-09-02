package com.springdata.tutorial.Repositories.StaffRepositories;

import com.springdata.tutorial.Entities.StaffEntities.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WardRepository extends JpaRepository<Ward, Long> {

    @Query("SELECT w FROM Ward w LEFT JOIN FETCH w.department LEFT JOIN FETCH w.supervisor WHERE w.id = :id")
    Ward findByIdWithDetails(@Param("id") Long id);
}
