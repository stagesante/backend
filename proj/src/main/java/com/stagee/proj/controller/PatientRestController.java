package com.stagee.proj.controller;

import java.awt.PageAttributes.MediaType;
import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stagee.proj.model.Patient;
import com.stagee.proj.service.PatientService;


@RestController
@RequestMapping("/v1")
public class PatientRestController {
	
	@Autowired
	PatientService carservice;
	@PreAuthorize("hasRole('ROLE_MEDECIN') or hasRole('ROLE_INFERMIER')")
	@GetMapping("/cars")
	public ResponseEntity<List<Patient>> getAllCars() {
		return ResponseEntity.ok().body(carservice.findAllPatients());
		
	}

	@GetMapping("/cars/owned")
	@PostFilter("filterObject.owner==authentication.name")
	public List<Patient> getCarsOwnedBy() {
		return carservice.findAllPatients();
		
	}
	
	@PostMapping("/cars")
	public ResponseEntity<Patient> saveCars(@RequestBody Patient newCar,Authentication auth) {
		System.out.println(newCar.getPrenom()+"  "+auth.getName());
		return ResponseEntity.status(HttpStatus.CREATED).body((carservice.saveCar(newCar)));
		
	}
	
	@GetMapping("/cars/{id}")
	public ResponseEntity<Patient> getCarById(@PathVariable("id") int carId) {
		return ResponseEntity.ok().body(carservice.findPatientById(carId).get());
		
	}
	
	@PutMapping("/cars/{id}")
	public ResponseEntity<Patient> updateCar(@PathVariable("id") int carId,@RequestBody Patient newCar) {
		return ResponseEntity.ok().body(carservice.updateCar(carId,newCar));
		
	}
	
	@DeleteMapping("/cars/{id}")
	public ResponseEntity<Object> deleteCar(@PathVariable("id") int carId) {
		 carservice.deleteCar(carId);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
	
	@GetMapping("/cars/search")
	public ResponseEntity<?> userDetails(Authentication auth, @RequestParam("cname") String cName) {
		System.out.println(auth.getName().toString());
		Patient car=carservice.findByPatientPrenom(cName);
		if(car==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("car not found");
		}
		return ResponseEntity.ok().body(car);
		
	}
	

}
