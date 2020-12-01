package com.javatechie.spring.mongo.embeded.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.javatechie.spring.mongo.embeded.api.repository.*;
import com.javatechie.spring.mongo.embeded.api.model.*;
import com.javatechie.spring.mongo.embeded.api.service.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMongoEmbededApplicationTests {

	@Autowired
	private DoctorService service;

	@MockBean
	private DoctorRepository repository;

	@Test
	public void getDoctorsTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Doctor(1,"medikiosk","Dr Arvind Singh","Male","Audiologist","arvind44@gmail.com","8 years", null), new Doctor(1,"medikiosk","Dr Deepika Goyal","Female","Gynocologists","deepikagoyak@gmail.com","5 years",null)).collect(Collectors.toList()));
		assertEquals(2, service.getAll().size());
	}

	@Test
	public void getDoctorbyAddressTest() {
		String address = "Kolkata";
		when(repository.findByCity(address))
				.thenReturn(Stream.of(new Doctor(1,"medikiosk","Dr Arvind Singh","Male","Audiologist","arvind44@gmail.com","8 years", null)).collect(Collectors.toList()));
		assertEquals(1, service.getDoctorbyAddress(address).size());
	}
	
	@Test
	public void getDoctorbySpecialistTest() {
		String disease = "Audiologist";
		when(repository.findBySpecialist(disease))
				.thenReturn(Stream.of(new Doctor(1,"medikiosk","Dr Arvind Singh","Male","Audiologist","arvind44@gmail.com","8 years", null)).collect(Collectors.toList()));
		assertEquals(1, service.getBySpecialist(disease).size());
	}

	@Test
	public void saveDoctorTest() {
		Doctor doctor = new Doctor(1,"medikiosk","Dr Arvind Singh","Male","Audiologist","arvind44@gmail.com","8 years", null);
		when(repository.save(doctor)).thenReturn(doctor);
		assertEquals(doctor, service.addDoctor(doctor));
	}

	@Test
	public void deleteDoctorTest() {
		Doctor doctor = new Doctor(1,"medikiosk","Dr Arvind Singh","Male","Audiologist","arvind44@gmail.com","8 years", null);
		service.deleteDoctor(doctor);
		verify(repository, times(1)).delete(doctor);
	}

}