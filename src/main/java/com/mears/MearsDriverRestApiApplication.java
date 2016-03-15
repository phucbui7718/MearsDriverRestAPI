package com.mears;

import com.mears.entities.Driver;
import com.mears.entities.Schedule;
import com.mears.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.SystemEnvironmentPropertySource;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication

public class MearsDriverRestApiApplication implements CommandLineRunner{

	@Autowired
	private DriverRepository driverRepository;

	public static void main(String[] args)

	{
		SpringApplication.run(MearsDriverRestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

			driverRepository.deleteAll();
			List<Schedule> schedules;
			schedules = new ArrayList<Schedule>();
			driverRepository.save(new Driver("241", "Phuc", "Bui", "02/09/2015", "phucbui1", schedules ));

			System.out.println("Driver with id number: 241 ");
			System.out.println("-------------------------------------");
			System.out.println(driverRepository.findByDriverNum("241").toString());
	}
}
