package com.mears;

import com.mears.entities.*;
import com.mears.repositories.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
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
	@Autowired
	private IdCounterRepository idCounterRepository;

	@Test
	public void testCounter() {
		IdCounter idCounter = idCounterRepository.findById("DriverRequest");
		System.out.println();
		System.out.println("---------------------");
		DriverRequest req = new DriverRequest(idCounter.getNextSequenceValue(), "1236", DriverRequestType.DAYOFF,
				"04/15/2016", "Cruise");
		try {
			idCounterRepository.save(idCounter);
			driverRequestRepository.save(req);
			System.out.println("Request saved.");
			System.out.println(req.toString());
		} catch (Exception e) {
			System.out.println("Request not saved.");
		}
		System.out.println("---------------------");

	}

	@Test
	public void testDateCheck() throws ParseException {
		/** The date at the end of the last century */
		SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
		String reqDate = "2016-02-09";
		Date myBDay = sd.parse(reqDate.replaceAll("-", "/"));
		Calendar cal = Calendar.getInstance();
		cal.setTime(myBDay);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		Date d1 = new GregorianCalendar(year, month, day).getTime();
		/** Today's date */
		Date today = new Date();

		/** Get msec from each, and subtract. */
		long diff = today.getTime() - d1.getTime();
		diff = (diff / (1000 * 60 * 60 * 24));

		System.out.println();
		System.out.println("------------------------");
		System.out.println(d1.toString());
		System.out.println("Days: " + diff);
		System.out.println("------------------------");
	}

	@Test
	public void testFetchSchedule() throws Exception {

		List<DriverSchedule> driverSchedules;

		//driverScheduleRepository.findByDriverNum("1234");
//		driverScheduleRepository.save(new DriverSchedule(8, "1235", "03/11/2016", "12:00", "19:00"));
//		driverScheduleRepository.save(new DriverSchedule(9, "1236", "02/20/2016", "08:00", "16:30"));
//		driverScheduleRepository.save(new DriverSchedule(10, "241", "01/21/2016", "17:00", "23:00"));

//		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//		Date schDate;

		String driverNum = "241";

		driverSchedules = driverScheduleRepository.findByDriverNum(driverNum);

		System.out.println();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.print("Schedule for Driver: ");
		System.out.println(driverRepository.findByDriverNum(driverNum).toString());
		if (driverSchedules.size() > 0) {
			Collections.sort(driverSchedules, new Comparator<DriverSchedule>() {
				@Override
				public int compare(DriverSchedule o1, DriverSchedule o2) {
					return o1.convertScheduleDate().compareTo(o2.convertScheduleDate());
				}
			});
			for (DriverSchedule sch: driverSchedules) {
				System.out.println("-----------------------------------------");
				System.out.println(sch.toString());

			}
/*
			for (int i = 0; i < driverSchedules.size(); i++) {
				System.out.println("-----------------------------------------");
//				schDate = driverSchedules.get(i).convertScheduleDate();
				System.out.println(driverSchedules.get(i).toString());
//				System.out.println("DriverSchedule date: " + dateFormat.format(schDate));
			}
*/
		} else {
			System.out.println("No schedules found for driver number " + driverNum);
		}
		System.out.println("-----------------------------------------");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

	@Test
	public void testFetchRequests() throws Exception {

		List<DriverRequest> requests;
		DriverRequestType testType;
		testType = DriverRequestType.DAYOFF;
		System.out.println("");
		System.out.println("-----------------------------------------");
		System.out.println(testType.getId());

		//driverScheduleRepository.findByDriverNum("1234");
//		driverRequestRepository.save(new DriverRequest(2, "1234", DriverRequestType.DAYOFF,
//				"04/28/2016", "Spy stuff"));
//		driverRequestRepository.save(new DriverRequest(3, "1235", DriverRequestType.WORK,
//				"05/20/2016", "Raising the Titanic"));
//		driverRequestRepository.save(new DriverRequest(4, "1234", DriverRequestType.DAYOFF,
//				"04/15/2016", "Taxes"));
//		driverRequestRepository.save(new DriverRequest(5, "1236", DriverRequestType.WORK,
//				"04/28/2016", "Need extra $"));

		String driverNum = "1234";

		requests = driverRequestRepository.findByDriverNum(driverNum);

		System.out.println("-----------------------------------------");
		System.out.println("Driver Requests");
		System.out.println(driverRepository.findByDriverNum(driverNum).toString());
		if (requests.size() > 0) {
			for (DriverRequest req : requests) {
				System.out.println(req.toString());
				System.out.println("--------------------------------------");
			}
/*
			for (int i = 0; i < requests.size(); i++) {
				System.out.println(requests.get(i).toString());
				System.out.println("--------------------------------------");
			}
*/
		} else {
			System.out.println("No requests found for driver number " + driverNum);
		}
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

	@Test
	public void testNewDriver() {
		String driverNum = "241";
		Driver driver = driverRepository.findByDriverNum(driverNum);
		List<DriverSchedule> driverSchedule = driverScheduleRepository.findByDriverNum(driverNum);
		int scheduleSize = driverSchedule.size();
		System.out.println();
		System.out.println("Driver: " + driver.toString());

		if (scheduleSize > 0) {
			for (DriverSchedule sch : driverSchedule) {
				System.out.println("--------------------------------------");
				System.out.println(sch.toString());
			}
/*
			for (int i = 0; i < scheduleSize; i++) {
				System.out.println("--------------------------------------");
				System.out.println(driverSchedule.get(i).toString());
			}
*/
		}
		System.out.println("--------------------------------------");

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
