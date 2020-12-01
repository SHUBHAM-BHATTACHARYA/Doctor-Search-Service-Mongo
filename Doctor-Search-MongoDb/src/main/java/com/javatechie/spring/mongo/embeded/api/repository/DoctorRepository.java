package com.javatechie.spring.mongo.embeded.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.javatechie.spring.mongo.embeded.api.model.Doctor;


public interface DoctorRepository extends MongoRepository<Doctor, String>{

	public Doctor findByName(String name);
	
	public Doctor findById2(long id2);
	
	public List<Doctor> findBySpecialist(String disease);
	

	@Query("{'Address.city':?0}")
	public List<Doctor> findByCity(String city);


}
