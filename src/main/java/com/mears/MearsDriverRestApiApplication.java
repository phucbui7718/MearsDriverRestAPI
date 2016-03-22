package com.mears;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MearsDriverRestApiApplication implements CommandLineRunner{

	public static void main(String[] args)
	{
		SpringApplication.run(MearsDriverRestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {}
}