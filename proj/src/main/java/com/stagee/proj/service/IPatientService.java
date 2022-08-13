package com.stagee.proj.service;

import java.util.List;
import java.util.Optional;

import com.stagee.proj.model.Patient;


public interface IPatientService {

	
	public List<Patient> findAllPatients() ;

	public Optional<Patient> findPatientById(int id);
	
	public Patient findByPatientPrenom(String prenom) ;
}
