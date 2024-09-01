package com.springdata.tutorial.Services;

import com.springdata.tutorial.Entities.StaffEntities.Patient;
import com.springdata.tutorial.Repositories.StaffRepositories.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PlatformTransactionManager transactionManager;

    public void savePatient(Patient patient) {
        TransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(definition);

        try {
            patientRepository.save(patient);
            transactionManager.commit(status);
        } catch (Exception ex) {
            transactionManager.rollback(status);
            throw ex; 
        }
    }

    public Optional<Patient> findPatientById(Long patientId) {
        return patientRepository.findById(patientId);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public void deletePatient(Long patientId) {
        TransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(definition);

        try {
            if (patientRepository.existsById(patientId)) {
                patientRepository.deleteById(patientId);
                transactionManager.commit(status);
            } else {
                throw new IllegalArgumentException("Patient with id " + patientId + " does not exist.");
            }
        } catch (Exception ex) {
            transactionManager.rollback(status);
            throw ex;
        }
    }
}
