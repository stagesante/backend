package com.stagee.proj.service;


import org.springframework.stereotype.Service;

import com.stagee.proj.model.Patient;
import com.stagee.proj.repo.PatientRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PatientService implements IPatientService{

	@Autowired
	private PatientRepository carRepo;
	
	
	


	
	
	
	public Patient saveCar(Patient newCar) {
		
		Patient Car=carRepo.save(newCar);
		return Car;
		
	}

	public Patient updateCar(int id,Patient car) {
		
		Optional<Patient> retrievedCar=carRepo.findById(id);
		
		if(retrievedCar==null)
			try {
				throw new Exception("Car not found");
			} catch (Exception e) {
				e.printStackTrace();
			}
		carRepo.save(car);
		return carRepo.findById(id).get();
		
	}
	
	public Patient deleteCar(int CarId) {
		
		Optional<Patient> retrievedCar=carRepo.findById(CarId);
		if(retrievedCar==null)
			try {
				throw new Exception("Car not found");
			} catch (Exception e) {
				e.printStackTrace();
			}
		carRepo.deleteById(CarId);
		return retrievedCar.get();
		
		
		
	}


	@Override
	public List<Patient> findAllPatients() {
		return carRepo.findAll();

	}


	@Override
	public Optional<Patient> findPatientById(int id) {
		return carRepo.findById(id);

	}


	@Override
	public Patient findByPatientPrenom(String prenom) {
      Patient Car=carRepo.findByPrenom(prenom);
		
		return Car;
	}

	

	







//	public void autoLogin(String CarName, String password) {
//		
//		CarDetails CarDetails=CarDetailsService.loadCarByCarname(CarName);
//		CarnamePasswordAuthenticationToken token= new CarnamePasswordAuthenticationToken(CarDetails,password,CarDetails.getAuthorities());
//		
//		authenticationManager.authenticate(token);
//		
//		if(token.isAuthenticated()) {
//			SecurityContextHolder.getContext().setAuthentication(token);
//		}
//				
//	}


//	@Autowired
//	private AuthenticationManager authenticationManager;
	
//	@Autowired
//	private CarDetailsService CarDetailsService;

	
	
	
}
