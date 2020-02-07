package com.assignment1.Real.Estate;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.assignment1.Real.Estate.getStat;

@SpringBootApplication
public class RealEstateApplication {

	public static void main(String[] args) throws IOException {
		getStat.parseData();
		SpringApplication.run(RealEstateApplication.class, args);

	}

}
