package com.mears;

import com.mears.entities.*;
import com.mears.repositories.*;
import com.mears.services.DriverRequestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SuppressWarnings("ALL")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MearsDriverRestApiApplication.class)
@WebAppConfiguration
public class MearsDriverRestApiApplicationTests {

	@Autowired
	public DriverRepository driverRepository;
	@Autowired
	private DriverScheduleRepository driverScheduleRepository;
	@Autowired
	private DriverRequestRepository driverRequestRepository;
	@Autowired
	DriverRequestService driverRequestService;


	@Test
	public void testDriverRequestService() {
		DriverRequest driverRequest = new DriverRequest("1234", DriverRequestType.WORK,
				"06-01-2016", "Vac money");
		String message = driverRequestService.insertRequest(driverRequest);
		System.out.println();
		System.out.println("---------------------");
		System.out.println(message);
		System.out.println("---------------------");
	}

	@Test
	public void testDateCheck() throws ParseException {
		/** The date at the end of the last century */
		SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
		String reqDate = "2016-04-09";
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
		long diff = d1.getTime() - today.getTime();
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
					return o1.toDate().compareTo(o2.toDate());
				}
			});
			for (DriverSchedule sch: driverSchedules) {
				System.out.println("-----------------------------------------");
				System.out.println(sch.toString());

			}
		} else {
			System.out.println("No schedules found for driver number " + driverNum);
		}
		System.out.println("-----------------------------------------");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

	@Test
	public void testFetchRequests() throws Exception {

		List<DriverRequest> driverRequests;
		DriverRequestType testType;
		SimpleDateFormat df= new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		String dateString = "";
		System.out.println("");

		String driverNum = "1235";

		driverRequests = driverRequestRepository.findByDriverNum(driverNum);
		Collections.sort(driverRequests, new Comparator<DriverRequest>() {
			@Override
			public int compare(DriverRequest o1, DriverRequest o2) {
				return o1.getRequestDate().compareTo(o2.getRequestDate());
			}
		});

		System.out.println("-----------------------------------------");
		System.out.println("Driver Requests");
		System.out.println(driverRepository.findByDriverNum(driverNum).toString());
		if (driverRequests.size() > 0) {
			for (DriverRequest req : driverRequests) {
				System.out.println(req.toString());
				Date reqDate = req.getRequestDate();

				Date boundDate = req.getRequestType().getLatestDateToSubmitRequest(reqDate);
				cal.setTime(boundDate);
				dateString = (cal.get(Calendar.MONTH) + 1) + "/" +
						cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.YEAR);
				System.out.println("Latest date to submit: " + dateString);

				boundDate = req.getRequestType().getEarliestDateToSubmitRequest(reqDate);
				cal.setTime(boundDate);
				dateString = (cal.get(Calendar.MONTH) + 1) + "/" +
						cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.YEAR);
				System.out.println("Earliest date to submit: " + dateString);

				System.out.println("Is within date bounds: " + req.getRequestType().isWithinDateBounds(reqDate));
				System.out.println("--------------------------------------");
			}
		} else {
			System.out.println("No driverRequests found for driver number " + driverNum);
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
