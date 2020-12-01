package com.javatechie.spring.mongo.embeded.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.mongo.embeded.api.model.Doctor;
import com.javatechie.spring.mongo.embeded.api.repository.DoctorRepository;
import com.javatechie.spring.mongo.embeded.api.service.DoctorService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8082" })
@RestController
@RequestMapping("/doctor-service")
public class DoctorController {

	@Autowired
	private DoctorRepository repository;
	
	@Autowired
	private DoctorService doctorService;

	@PostMapping("/addDoctor")
	public void placeOrder(@RequestBody Doctor user) {
		repository.save(user);
		return;
	}

	@GetMapping("/getUserByName/{name}")
	public Doctor getUserbyName(@PathVariable String name) {
		return doctorService.getByName(name);
	}
	
	@GetMapping("/getDoctorById2/{id2}")
	public Doctor getUserbyId2(@PathVariable long id2) {
		return doctorService.getById2(id2);
	}
	
	@GetMapping("/getUserBySpecialist/{disease}")
	public List<Doctor> getUserbySpecialist(@PathVariable String disease) {
		return doctorService.getBySpecialist(disease);
	}

	@GetMapping("/getUserByAddress/{city}")
	public List<Doctor> getUserbyAddress(@PathVariable String city) {
		return repository.findByCity(city);
	}
	
	//Retrieve all
	@RequestMapping("/getAll")
	public List<Doctor> getAll(){
		return repository.findAll();
	}
	//Update operation
	@PutMapping("/update/{name}")
	public void update(@RequestBody Doctor doctor,@PathVariable String name) {
        doctorService.update(doctor,name);
		return;
	}
	@DeleteMapping("/delete/{name}")
	public void delete(@PathVariable String name) {
		doctorService.delete(name);
		return;
	}	
	
	//Delete operation
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		doctorService.deleteAll();
		return;
			
	}

}
