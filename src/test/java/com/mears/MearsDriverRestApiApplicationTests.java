package com.mears;

import com.mears.entities.DriverRequest;
import com.mears.entities.DriverRequestType;
import com.mears.entities.DriverSchedule;
import com.mears.repositories.DriverRepository;
import com.mears.repositories.DriverRequestRepository;
import com.mears.repositories.DriverScheduleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MearsDriverRestApiApplication.class)
@WebAppConfiguration
public class MearsDriverRestApiApplicationTests {

	@Autowired
	private DriverRepository driverRepository;
	@Autowired
	private DriverScheduleRepository driverScheduleRepository;
	@Autowired
	private DriverRequestRepository driverRequestRepository;

	@Test
	public void testFetchSchedule() throws Exception {

		List<DriverSchedule> schedules;

		//driverScheduleRepository.findByDriverNum("1234");
//		driverScheduleRepository.save(new DriverSchedule(8, "1235", "03/11/2016", "12:00", "19:00"));
//		driverScheduleRepository.save(new DriverSchedule(9, "1236", "02/20/2016", "08:00", "16:30"));
//		driverScheduleRepository.save(new DriverSchedule(10, "241", "01/21/2016", "17:00", "23:00"));

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = GregorianCalendar.getInstance();
		Date today = new Date();
		Date schDate;
		long diff;
		long diffDays;

		String driverNum = "1236";

		schedules = driverScheduleRepository.findByDriverNum(driverNum);

		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("DriverSchedule for Driver number: " + driverNum);
		System.out.println(driverRepository.findByDriverNum(driverNum).toString());
		System.out.println("-----------------------------------------");
		if (schedules.size() > 0) {
			for (int i = 0; i < schedules.size(); i++) {
//				cal.setTime( today );
//				cal.add( );

				schDate = schedules.get(i).convertScheduleDate();
//				diff = Math.abs(schDate.getTime() - today.getTime());
//				diffDays = diff / (24 * 60 * 60 * 1000) + 1;


//				if (diffDays >= 0) {
				System.out.println(schedules.get(i).toString());
				System.out.println("Today: " + dateFormat.format(today));
				System.out.println("DriverSchedule date: " + dateFormat.format(schDate));
//					System.out.println("Days until scheduled date: " + diffDays);
				System.out.println("--------------------------------------");
//				}
			}
		} else {
			System.out.println("No schedules found for driver number " + driverNum);
		}
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

	@Test
	public void testFetchRequests() throws Exception {

		List<DriverRequest> requests;

		//driverScheduleRepository.findByDriverNum("1234");
//		driverRequestRepository.save(new DriverRequest(2, "1234", DriverRequestType.DAYOFF,
//				"04/28/2016", "Spy stuff"));
//		driverRequestRepository.save(new DriverRequest(3, "1235", DriverRequestType.WORK,
//				"05/20/2016", "Raising the Titanic"));
//		driverRequestRepository.save(new DriverRequest(4, "1234", DriverRequestType.DAYOFF,
//				"04/15/2016", "Taxes"));
		driverRequestRepository.save(new DriverRequest(5, "1236", DriverRequestType.WORK,
				"04/28/2016", "Need extra $"));

		String driverNum = "1234";

		requests = driverRequestRepository.findByDriverNum(driverNum);

		System.out.println("-----------------------------------------");
		System.out.println("Driver Request for Driver number: " + driverNum);
		System.out.println(driverRepository.findByDriverNum(driverNum).toString());
		if (requests.size() > 0) {
			for (int i = 0; i < requests.size(); i++) {
				System.out.println(requests.get(i).toString());
				System.out.println("--------------------------------------");
			}
		} else {
			System.out.println("No requests found for driver number " + driverNum);
		}
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetDriveNum() throws Exception {

	}

	@Test
	public void testSetDriverNum() throws Exception {

	}

	@Test
	public void testGetDriverFirstName() throws Exception {

	}

	@Test
	public void testSetFirstName() throws Exception {

	}

	@Test
	public void testGetDriverLastName() throws Exception {

	}

	@Test
	public void testSetLastName() throws Exception {

	}

	@Test
	public void testGetDriverNameFirstLast() throws Exception {

	}

	@Test
	public void testGetDriverNameLastFirst() throws Exception {

	}

	@Test
	public void testGetHireDate() throws Exception {

	}

	@Test
	public void testSetHireDate() throws Exception {

	}

	@Test
	public void testGetPassword() throws Exception {

	}

	@Test
	public void testSetPassword() throws Exception {

	}

	@Test
	public void testToString() throws Exception {

	}
}
