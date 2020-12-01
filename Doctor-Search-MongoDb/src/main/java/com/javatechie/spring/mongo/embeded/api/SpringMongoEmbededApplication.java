package com.javatechie.spring.mongo.embeded.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringMongoEmbededApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoEmbededApplication.class, args);
	}
}
