package FlightsControl;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Scanner;

import FlightsControl.Flight.eStatus;
import FlightsControl.Flight.eType;

public class ProgramHandle {
	static int choice = -1;

	public static void startMain(FlightsControl control, Scanner scan) throws FileNotFoundException {
		System.out.println("---------------------HELLO AND WELCOME----------------------");
		System.out.println("--------------You Enter To FlightControlApp 2.0--------------");
		System.out.println("Lets get started!");
		control.addHardCode();

		while(choice != 10)
			showMainMenu(control, scan);
	}

	private static boolean performMainAction(FlightsControl control, Scanner scan) throws FileNotFoundException  {
		switch (choice) {
		case 10:
			System.out.println("Have a nice day!");
			return false;
		case 1:
			return addFlight(control, scan);
		case 2:
			return cancelFlight(control, scan);
		case 3:
			return performSortAction(control, scan);
		case 4:
			return performFilterAction(control, scan);
		case 5:
			System.out.println(control.showFlights());
			return true;
		case 6:
			saveDataToFile(control, scan);
		default:
			System.out.println("Wrong input! try again");
			return performFilterAction(control, scan);
		}
	}
	///File Save///
	private static void saveDataToFile(FlightsControl control, Scanner scan) throws FileNotFoundException {
		System.out.println("please enter file name (EX: flight.txt):");
		String fileName = scan.next();
		control.save(fileName);
		showMainMenu(control, scan);
	}
	///File Save///

	///arithmetic///

	private static boolean addFlight(FlightsControl control, Scanner scan) {
		String airlineName;
		eType flightType;
		String country;
		String city;
		String airport;
		int year = 0;
		int month = 0;
		int day = 0;
		LocalDate flightDate;
		String gate;
		boolean b = false;
		scan.nextLine();

		System.out.println("Enter Airline name: ");
		airlineName = scan.nextLine();
		
		System.out.println("Enter Flight Type: (Departure, Arrival)");
		flightType = eType.valueOf(scan.nextLine());

		System.out.println("Enter the country: ");
		country = scan.nextLine();

		System.out.println("Enter the city: ");
		city  = scan.nextLine();
		
		System.out.println("Enter the airport: ");
		airport  = scan.nextLine();

		while(!b) {
			System.out.println("Enter departure date: ");
			System.out.println("Year: ");
			year = scan.nextInt();

			System.out.println("Month: ");
			month = scan.nextInt();

			System.out.println("Day: ");
			day = scan.nextInt();

			if(checkDate(year, month, day))
				b = true;
			else
				System.out.println("Invalid date!");
		}

		flightDate = LocalDate.of(year, month, day); 


		scan.nextLine();
		System.out.println("Enter gate number (ex: A1)");
		gate = scan.next();

		Flight flight = new Flight(airlineName, flightType, country, city, airport, flightDate, gate);
		return control.addFlight(flight);
	}

	private static boolean cancelFlight(FlightsControl control, Scanner scan) {
		int flightChoice = 0;
		boolean b = false;
		while(!b) {
			System.out.println("Choose a flight to cancel");
			
			control.filterByStatus(eStatus.OnTime);
			System.out.println(control.showFlights());
			control.removeFilters();
			
			flightChoice = scan.nextInt();
			if(flightChoice >= 1 || flightChoice <= control.getFlights().size())
				b = true;
			else
				System.out.println("Wrong input");
		}
		return control.cancelFlight(control.getFlights().get(flightChoice-1).getFlightNumber());
	}

	///arithmetic///

	///Sort///

	private static boolean performSortAction(FlightsControl control, Scanner scan)  {
		showSortMenu();

		choice = scan.nextInt();

		switch (choice) {
		case 0:
			return false;
		case 1:
			sortFlightsByDate(control);
			return true;
		case 2:
			sortFlightsByFlightType(control);
			return true;
		case 3:
			sortFlightsByStatus(control);
			return true;
		default:
			System.out.println("Wrong input! try again");
			return performSortAction(control, scan);
		}
	}

	private static void sortFlightsByDate(FlightsControl control) {
		control.sortFlightsByDate();
		System.out.println(control.showFlights());	
	}
	
	private static void sortFlightsByFlightType(FlightsControl control) {
		control.sortFlightsByFlightType();
		System.out.println(control.showFlights());	
	}

	private static void sortFlightsByStatus(FlightsControl control) {
		control.sortFlightsByStatus();
		System.out.println(control.showFlights());
	}

	///sort///


	///Filter///

	private static boolean performFilterAction(FlightsControl control, Scanner scan)  {
		showFilterMenu();

		choice = scan.nextInt();

		switch (choice) {
		case 0:
			System.out.println(control.showFlights());
			return true;
		case 1:
			filterByAirline(control, scan);
			return performFilterAction(control, scan);
		case 2:
			filterByCountry(control, scan);
			return performFilterAction(control, scan);
		case 3:
			filterByCity(control, scan);
			return performFilterAction(control, scan);
		case 4:
			filterByAirport(control, scan);
			return performFilterAction(control, scan);
		case 5:
			filterByFlightDate(control, scan);
			return performFilterAction(control, scan);
		case 6:
			filterByDayOfWeek(control, scan);
			return performFilterAction(control, scan);
		case 7:
			filterByGate(control, scan);
			return performFilterAction(control, scan);
		case 8:
			filterByStatus(control, scan);
			return performFilterAction(control, scan);
		case 9: 
			control.removeFilters();
			return true;
		default:
			System.out.println("Wrong input! try again");
			return performFilterAction(control, scan);

		}
	}

	private static void filterByAirline(FlightsControl control, Scanner scan) {
		System.out.println("Enter desired air line: ");
		scan.nextLine();
		String airline = scan.nextLine();
		control.filterByAirLine(airline);
	}

	private static void filterByCountry(FlightsControl control, Scanner scan) {
		System.out.println("Enter desired country: ");
		scan.nextLine();
		String country = scan.nextLine();
		control.filterByCountry(country);
	}

	private static void filterByCity(FlightsControl control, Scanner scan) {
		System.out.println("Enter desired city: ");
		scan.nextLine();
		String city = scan.nextLine();
		control.filterByCity(city);
	}
	
	private static void filterByAirport(FlightsControl control, Scanner scan) {
		System.out.println("Enter desired airport: ");
		scan.nextLine();
		String airport = scan.nextLine();
		control.filterByAirport(airport);
	}

	private static void filterByFlightDate(FlightsControl control, Scanner scan) {
		boolean b = false;
		int year1 = 0, year2 = 0;
		int month1 = 0, month2 = 0;
		int day1 = 0, day2 = 0;

		while(!b) {
			System.out.println("Enter start date: ");
			System.out.println("Year: ");
			year1 = scan.nextInt();

			System.out.println("Month: ");
			month1 = scan.nextInt();

			System.out.println("Day: ");
			day1 = scan.nextInt();

			if(checkDate(year1, month1, day1))
				b = true;
			else
				System.out.println("Invalid date!");
		}
		
		b = false;
		while(!b) {
			System.out.println("Enter end date: ");
			System.out.println("Year: ");
			year2 = scan.nextInt();

			System.out.println("Month: ");
			month2 = scan.nextInt();

			System.out.println("Day: ");
			day2 = scan.nextInt();

			if(checkDate(year2, month2, day2))
				b = true;
			else
				System.out.println("Invalid date!");
		}

		LocalDate start = LocalDate.of(year1, month1, day1);
		LocalDate end = LocalDate.of(year2, month2, day2);
		control.filterByFlightDateMargin(start, end);
	}
	
	private static void filterByDayOfWeek(FlightsControl control, Scanner scan) {
		System.out.println("Enter desired day of week: ");
		String dayOfWeek = scan.next();
		control.filterByDayOfWeek(dayOfWeek);
	}

	private static void filterByGate(FlightsControl control, Scanner scan) {
		System.out.println("Enter desired gate number: ");
		String gate = scan.next();
		control.filterByGate(gate);
	}

	private static void filterByStatus(FlightsControl control, Scanner scan) {
		System.out.println("Enter desired status: ");
		String status = scan.next();
		control.filterByStatus(eStatus.valueOf(status));
	}

	///Filter///

	///show menus///

	private static void showMainMenu(FlightsControl control, Scanner scan) throws FileNotFoundException {
		System.out.println("\nMENU: please enter the number of the desired action:");
		System.out.println("1: Add Flight");
		System.out.println("2: Cancel Flight");
		System.out.println("3: Sort Flights");
		System.out.println("4: Filter Flights");
		System.out.println("5: Show Flights");
		System.out.println("6: Save Data To File");
		System.out.println("10: EXIT");

		choice = scan.nextInt();
		if ((choice <= 6 && choice >= 1) || choice == 10) {
			if (performMainAction(control, scan))
				System.out.println("Action performed successfuly!!");

			else
				System.out.println("No action performed");
		}
	}

	private static void showSortMenu() {
		System.out.println("\nSort menu: please enter the number of the desired action:");
		System.out.println("0: Go Back To Menu");
		System.out.println("1: Sort Flights By Date");
		System.out.println("2: Sort Flights By Flight Type");
		System.out.println("3: Sort By Status");
	}

	private static void showFilterMenu() {
		System.out.println("\nFilter menu: please enter the number of the desired action:");
		System.out.println("0: Go Back To Menu and see filtered flights");
		System.out.println("1: Filter Flights By Air Line");
		System.out.println("2: Filter Flights By Country");
		System.out.println("3: Filter Flights By City");
		System.out.println("4: Filter Flights By Airport");
		System.out.println("5: Filter Flights By Flight Date");
		System.out.println("6: Filter Flights By Day Of week");
		System.out.println("7: Filter Flights By Gate");
		System.out.println("8: Filter Flights By Status");
		System.out.println("9: Remove Filters");
	}

	///show menus///

	private static boolean checkDate(int year, int month, int day) { // check if date is from now on
		int currentYear = LocalDate.now().getYear();
		int currentMonth = LocalDate.now().getMonthValue();
		int currentDay = LocalDate.now().getDayOfMonth();

		if (day < 1 || day > 31)
			return false;
		if (month < 1 || month > 12)
			return false;
		if (year < currentYear)
			return false;
		if (year == currentYear && month < currentMonth)
			return false;
		if (year == currentYear && month == currentMonth && day < currentDay)
			return false;
		return true;
	}
}
