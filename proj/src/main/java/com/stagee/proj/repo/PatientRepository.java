package com.stagee.proj.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stagee.proj.model.Patient;



 


public interface PatientRepository extends MongoRepository<Patient,Integer>{
	

	Patient findByPrenom(String prenom);
}
