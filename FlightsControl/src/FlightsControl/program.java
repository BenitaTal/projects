package FlightsControl;

import java.io.FileNotFoundException;
import java.util.Scanner;

import FlightsControl.Flight.eStatus;
import FlightsControl.Flight.eType;

//http://localhost:8000/departures?outformat=html&country=france&city=paris&airport=CDG&airline=elal&day1=4&month1=6&year1=2020&day2=31&month2=7&year2=2020&sunday=true&monday=false&tuesday=false&wednesday=true&thursday=false&friday=false&saturday=false
public class program {

	public static void main(String[] args) throws FileNotFoundException {
		if(args.length > 0) {
			FlightsControl control = new FlightsControl();
			control.addHardCode();
			//			boolean isHtml = args[0].equalsIgnoreCase("html");
			boolean isDepartures = args.length > 1 && args[1].equalsIgnoreCase("departures");
			if (isDepartures) {
				System.out.println("<h1>Departures</h1");
				control.removeFilters();
				control.filterByFlightType(eType.Departure);
				//				control.filterByArgs(airline, country, city, airport, startDate, endDate, dayOFWeek, gate, status);
				System.out.println(control.showFlightsTable());
			}
			else {
				System.out.println("<h1>Arrivals</h1");
				control.removeFilters();
				control.filterByFlightType(eType.Arrival);
				//				control.filterByArgs(airline, country, city, airport, startDate, endDate, dayOFWeek, gate, status);
				System.out.println(control.showFlightsTable());
			}
		}
		//		else {
		//		String fileName  = "FlightsControl\\FlightControlFile.txt";
		//		Scanner scanFile = new Scanner(fileName);
		//		FlightsControl controlFile = new FlightsControl(scanFile);
		//		ProgramHandle.performMainAction(controlFile, scanFile);

		FlightsControl controlSystem = new FlightsControl();
		Scanner scanSystem = new Scanner(System.in);
		ProgramHandle.startMain(controlSystem, scanSystem);
	}
	

}
