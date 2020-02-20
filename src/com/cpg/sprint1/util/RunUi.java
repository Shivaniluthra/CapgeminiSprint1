package com.cpg.sprint1.util;

import java.util.ArrayList;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.cpg.sprint1.DaoImpl.AppointmentDaoImpl;
import com.cpg.sprint1.DaoImpl.Diagnostic_centerDaoImpl;
import com.cpg.sprint1.DaoImpl.TestDaoImpl;
import com.cpg.sprint1.DaoImpl.UserDao;
import com.cpg.sprint1.ServiceImpl.AppointmentServiceImpl;
import com.cpg.sprint1.ServiceImpl.Diagnostic_centerServiceImpl;
import com.cpg.sprint1.ServiceImpl.ServiceImpl;
import com.cpg.sprint1.ServiceImpl.TestServiceImpl;
import com.cpg.sprint1.entities.Appointment;
import com.cpg.sprint1.entities.Diagnostic_center;
import com.cpg.sprint1.entities.Test;
import com.cpg.sprint1.entities.User;
import com.cpg.sprint1.exceptions.*;
import com.cpg.sprint1.services.IAppointmentService;
import com.cpg.sprint1.services.IDiagnostic_centerService;
import com.cpg.sprint1.services.IService;
import com.cpg.sprint1.services.ITestService;

public class RunUi {
	public static Scanner s = new Scanner(System.in);
	public static IService service = new ServiceImpl(new UserDao());
	public static IDiagnostic_centerService service1 = new Diagnostic_centerServiceImpl(new Diagnostic_centerDaoImpl());
	public static ITestService service2 = new TestServiceImpl(new TestDaoImpl());
	public static IAppointmentService service3 = new AppointmentServiceImpl(new AppointmentDaoImpl());

	public static void main(String[] args) {
		do {
			System.out.println("********************** WELCOME TO THE HEALTHCARE CENTER *************************");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("Enter choice:");
			int i = s.nextInt();
			switch (i) {
			case 1:
				register();
				break;
			case 2:
				String s1 = login();
				validate(s1);
				break;
			default:
				System.out.println("You are exiting now");
				System.exit(0);

			}
		} while (true);
	}

	public static void validate(String s1) {
		if (s1.equalsIgnoreCase("admin"))
			admin();
		else
			customer();
	}

	public static void register() {
		try {
			System.out.println("************************* FILL REGISTRATION FORM **************************");
			System.out.println("Enter the UserName");
			String a2 = s.next();
			System.out.println("Enter the UserEmail");
			String a3 = s.next();
			System.out.println("Enter the UserPassword");
			String a4 = s.next();
			System.out.println("Enter the Contact No");
			long a5 = s.nextLong();
			System.out.println("Enter the Gender");
			String a6 = s.next();
			System.out.println("Enter the Age");
			int a7 = s.nextInt();
			System.out.println("Enter the User_Role (admin or customer)");
			String a8 = s.next();
			User user = new User(a2, a3, a4, a5, a6, a7, a8);
			User u = service.register(user);
			System.out.println();
		} catch (AppointmentNotFoundException e) {
			System.out.println("Appointment not found");
		} catch (CenterNotFoundException c) {
			System.out.println("Center not found");
		} catch (NullArgumentException n) {
			System.out.println("Null Argument is found");
		} catch (TestNotFoundException t) {
			System.out.println("Test is not Found");
		}
	}

	public static void customer() {
		try {
			do {
				System.out.println("1 Make an Appointment.");
				System.out.println("2 Logout");
				int ch = s.nextInt();
				switch (ch) {
				case 1:
						List<Diagnostic_center> list = service1.centerList();
						if (list.size() == 0) {
							System.out.println("No center found");
							System.exit(0);
						}
						System.out.println();
						System.out.println("Avaialable Center are :");
						for (Diagnostic_center d : list) {
							System.out.println("Center ID Center Name");
							System.out.println(d.getCenterId() + " " + d.getCenterName());
						}
						System.out.println("Select center id: ");
						String id = s.next();
						List<Test> tList = service2.testList(id);
						if (tList.size() == 0) {
							System.out.println("No test found");
							System.exit(0);
						}
						System.out.println();
						System.out.println("Avaialable Tests are :");
						for (Test t : tList) {
							System.out.println("Test ID Test Name");
							System.out.println(t.getTestId() + " " + t.getTestName());
						}
						System.out.println("Enter test id:");
						String tid = s.next();
						System.out.println("Enter the date in format dd-mon-yy");
						String date = s.next();
						Appointment a = new Appointment(id, tid, date);
						Appointment ap = service3.addAppointment(a);
						service3.appList(date);
						System.out.println("Appointment added successfully with id " + ap.getAppointmentId());
						break;
				case 2:
					System.out.println("Thank you visit again");
					System.exit(0);
				}
			} while (true);
		} catch (AppointmentNotFoundException e) {
			System.out.println("Appointment not found");
		} catch (CenterNotFoundException c) {
			System.out.println("Center not found");
		} catch (NullArgumentException n) {
			System.out.println("Null Argument is found");
		} catch (TestNotFoundException t) {
			System.out.println("Test is not Found");
		}
	}

	public static void admin() {
		try {
			do {
				System.out.println("1 Remove Appointment");
				System.out.println("2 Approve Appointment");
				System.out.println("3 Add Test");
				System.out.println("4 Remove Test");
				System.out.println("5 Add Center");
				System.out.println("6 Remove Center");
				System.out.println("7 Logout");
				System.out.println("Enter choice: ");
				int ch = s.nextInt();
				switch (ch) {
				case 1:
					System.out.println("*******Remove Appointment********");
					System.out.println("Enter appointment id");
					Double id = s.nextDouble();
					if (service3.removeAppointment(id)) {
						System.out.println("Appointment removed");
					} else {
						System.out.println("Unable to remove appointment");
					}
					break;

				case 2:
					System.out.println("*******Approve Appointment********");
					System.out.println("Enter date in format dd-MON-yy format");
					String date= s.next();
					List<Appointment> alist= new ArrayList<>();
					alist= service3.appList(date);
					for(Appointment i: alist) {
							System.out.println("AppointmentID TestID Status");
							System.out.println(i.getAppointmentId()+" "+i.getTest_id()+" "+i.getStatus());
					}
					System.out.println("Enter appointment id");
					Double id1 = s.nextDouble();
					System.out.println("Enter status(Yes or No):");
					String status = s.next();
					System.out.println(service3.approveAppointment(id1, status));
					break;

				case 3:
					System.out.println("************Add Test************");
					System.out.println("Enter testName");
					String testname = s.next();
					System.out.println("Enter center id:");
					String center_id = s.next();
					Test test = new Test(testname, center_id);
					System.out.println(service2.addTest(test));
					break;

				case 4:
					System.out.println("**********Remove Test********");
					List<Diagnostic_center> list = service1.centerList();
					if (list.size() == 0) {
						System.out.println("No center found to remove test from");
						System.exit(0);
					}
					System.out.println();
					System.out.println("Avaialable Center are :");
					for (Diagnostic_center d : list) {
						System.out.println("Center ID Center Name");
						System.out.println(d.getCenterId() + " " + d.getCenterName());
					}
					System.out.println("Select center id: ");
					String id2 = s.next();
					List<Test> tList = service2.testList(id2);
					if (tList.size() == 0) {
						System.out.println("No test found");
						System.exit(0);
					}
					System.out.println();
					System.out.println("Avaialable Tests are :");
					for (Test t : tList) {
						System.out.println("Test ID Test Name");
						System.out.println(t.getTestId() + " " + t.getTestName());
					}
					System.out.println("Enter testId");
					String testid1 = s.next();
					boolean b = service2.removeTest(testid1);
					if (b) {
						System.out.println("Test Deleted");
					} else {
						System.out.println("Test not Deleted");
					}
					break;

				case 5:
					System.out.println("**************Add Center************");
					System.out.println("Enter the CenterName");
					String cen2 = s.next();
					System.out.println("Enter the Contact Details");
					int contact = s.nextInt();
					System.out.println("Enter the Address");
					String address = s.next();
					Diagnostic_center center = new Diagnostic_center(cen2, contact, address);
					service1.addCenter(center);
					break;

				case 6:
					System.out.println("********Remove Center********");
					List<Diagnostic_center> list1 = service1.centerList();
					if (list1.size() == 0) {
						System.out.println("No center found");
						System.exit(0);
					}
					System.out.println();
					System.out.println("Avaialable Center are :");
					for (Diagnostic_center d : list1) {
						System.out.println("Center ID Center Name");
						System.out.println(d.getCenterId() + " " + d.getCenterName());
					}
					System.out.println("Enter the centerId");
					String cen = s.next();
					if (service1.removeCenter(cen)) {
						System.out.println("Center Removed");
					} else {
						System.out.println("Center not Removed");
					}
					break;
				case 7:
					System.out.println("Logged out");
					System.exit(0);

				default:
					System.out.println("Enter valid choice.");
					break;
				}
			} while (true);
		} catch (AppointmentNotFoundException e) {
			System.out.println("Appointment not found");
		} catch (CenterNotFoundException c) {
			System.out.println("Center not found");
		} catch (NullArgumentException n) {
			System.out.println("Null Argument is found");
		} catch (TestNotFoundException t) {
			System.out.println("Test is not Found");
		}
	}

	public static String login() {
		System.out.println("Enter the UserId");
		String a1 = s.next();
		System.out.println("Enter the UserPassword");
		String a2 = s.next();
		User u = service.validateUser(a1, a2);
		if (u == null)
			System.out.println("Invalid ID or Password");
		else
			System.out.println("Welcome " + u.getUserName() + " to The HealthCare System");
		String s1 = u.getUser_role();
		return s1;
	}

}