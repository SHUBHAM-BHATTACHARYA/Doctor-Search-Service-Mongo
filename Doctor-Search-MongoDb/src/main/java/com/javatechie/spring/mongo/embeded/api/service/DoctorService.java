package com.javatechie.spring.mongo.embeded.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.spring.mongo.embeded.api.model.Doctor;
import com.javatechie.spring.mongo.embeded.api.repository.DoctorRepository;

@Service
public class DoctorService {
   
	@Autowired
	private DoctorRepository doctorRepository;
	
	public Doctor addDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	//Retrieve operation
	public List<Doctor> getAll(){
		return doctorRepository.findAll();
	}
	public Doctor getByName(String name) {
		return doctorRepository.findByName(name);
	}
	public Doctor getById2(long id2) {
		return doctorRepository.findById2(id2);
	}
	public List<Doctor> getBySpecialist(String disease) {
		return doctorRepository.findBySpecialist(disease);
	}
	//Update operation
	public Doctor update(Doctor doctor,String name) {
		Doctor p = doctorRepository.findByName(name);
		p.setId(doctor.getId());
		p.setUsername(doctor.getUsername());
		p.setName(doctor.getName());
		p.setGender(doctor.getGender());
		p.setSpecialist(doctor.getSpecialist());
		p.setEmailid(doctor.getEmailid());
		p.setExperience(doctor.getExperience());
		p.setAddress(doctor.getAddress());
		return doctorRepository.save(p);
	}
	
	public List<Doctor> getDoctorbyAddress(String address) {
		return doctorRepository.findByCity(address);
	}
	
	//Delete operation
	public void deleteAll() {
		doctorRepository.deleteAll();
	}
	public void delete(String name) {
		Doctor p = doctorRepository.findByName(name);
		doctorRepository.delete(p);
	}
	
	public void deleteDoctor(Doctor doctor) {
		doctorRepository.delete(doctor);
	}
	 
}
