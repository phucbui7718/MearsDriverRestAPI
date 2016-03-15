package com.mears;

import com.mears.entities.Driver;
import com.mears.entities.Schedule;
import com.mears.repositories.DriverRepository;
import com.mears.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class MearsDriverRestApiApplication implements CommandLineRunner{

	@Autowired
	private DriverRepository driverRepository;
	@Autowired
	private ScheduleRepository scheduleRepository;

	public static void main(String[] args)
	{
		SpringApplication.run(MearsDriverRestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		driverRepository.deleteAll();
//		List<Schedule> schedules;
//		schedules = new ArrayList<Schedule>();
//		driverRepository.save(new Driver("241", "Phuc", "Bui", "02/09/2015", "phucbui1" ));
//		driverRepository.save(new Driver("1234", "James", "Bond", "05/08/1963", "bond007" ));
//		driverRepository.save(new Driver("1235", "Dirk", "Pitt", "10/26/1976", "numa1" ));
//		driverRepository.save(new Driver("1236", "Temperence", "Brennan", "09/01/1997", "LML1" ));

		//scheduleRepository.findByDriverNum("1234");
		scheduleRepository.save(new Schedule(2, "1235", "04/10/2016", "17:00", "23:00"));
		scheduleRepository.save(new Schedule(3, "1236", "04/09/2016", "12:00", "22:00"));
		scheduleRepository.save(new Schedule(4, "241", "04/11/2016", "17:00", "23:00"));
		System.out.println("-----------------------------------------");
		System.out.println("Schedule for Driver with id number: 1234 ");
		System.out.println(driverRepository.findByDriverNum("1234").toString());
		System.out.println(scheduleRepository.findByDriverNum("1234").toString());
		System.out.println("-----------------------------------------");
	}
}