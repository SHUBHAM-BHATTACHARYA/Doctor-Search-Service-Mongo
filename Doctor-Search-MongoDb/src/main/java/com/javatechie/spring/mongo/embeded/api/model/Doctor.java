package com.javatechie.spring.mongo.embeded.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "Doctor-Search-Service")
public class Doctor {
	@Id
	private String id;
	private long id2;
	private String username;
	private String name;
	private String gender;
	private String specialist;
	private String emailid;
	private String experience;
	private Address address;
	public Doctor(long id2,String username,String name,String gender,String specialist,String emailid,String experience,Address address) {
		this.id2=id2;
		this.username=username;
		this.name=name;
		this.gender=gender;
		this.specialist=specialist;
		this.emailid=emailid;
		this.experience=experience;
		this.address=address;
	}
	public Long getId() {
		return id2;
	}

	public void setId(Long id2) {
		this.id2 = id2;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	

}
