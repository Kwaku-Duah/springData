package com.springdata.tutorial.Repositories.MongoRepositories;




import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springdata.tutorial.Entities.MongoDBEntities.Patient;



@Repository
public interface PatientMongoRepository extends MongoRepository<Patient, String> {
 
}
