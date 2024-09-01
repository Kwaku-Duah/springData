package com.springdata.tutorial.Repositories.StaffRepositories;

import com.springdata.tutorial.Entities.StaffEntities.DoctorRedisEntity;
import org.springframework.data.repository.CrudRepository;



public interface DoctorRedisRepository extends CrudRepository<DoctorRedisEntity, String> {
}
