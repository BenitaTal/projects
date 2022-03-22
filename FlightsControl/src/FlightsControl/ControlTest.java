package FlightsControl;

import java.awt.List;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import FlightsControl.Flight.eStatus;
import FlightsControl.Flight.eType;



public class ControlTest {
	private final FlightsControl control = new FlightsControl();
		
	///Arithmetic
	@Test
	public void addFlightTest() {
		Flight flight = new Flight("TestAirline", eType.Departure, "TestCountry", "TestCity", "TestAirport", LocalDate.of(1, 1, 1), "A1");
		control.addFlight(flight);
		assertTrue(control.getFlights().contains(flight));
	}

	@Test
	public void cancelFlightTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Departure, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(1, 1, 1), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Arrival, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(2, 2, 2), "B2");
		control.addFlight(flight1);
		control.addFlight(flight2);
		control.cancelFlight(flight1.getFlightNumber());
		assertTrue(flight1.getStatus().equals(eStatus.Canceled));
		assertTrue(flight2.getStatus().equals(eStatus.OnTime));
		control.cancelFlight(flight2.getFlightNumber());
		assertTrue(flight2.getStatus().equals(eStatus.Canceled));
		
	}

	///Arithmetic


	///Sort
	@Test
	public void sortFlightsByDateTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Arrival, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(2, 2, 2), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Departure, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(1, 1, 1), "B2");

		control.addFlight(flight1);
		control.addFlight(flight2);
		control.sortFlightsByDate();
		Flight[] test = {flight2, flight1};
		assertArrayEquals(test, control.getPresentationFlights().toArray());
	}

	@Test
	public void sortFlightsByFlightTypeTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Arrival, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(2, 2, 2), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Departure, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(1, 1, 1), "B2");

		control.addFlight(flight1);
		control.addFlight(flight2);
		control.sortFlightsByFlightType();
		Flight[] test = {flight2, flight1};
		assertArrayEquals(test, control.getPresentationFlights().toArray());
	}

	@Test
	public void sortFlightsByStatusTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Arrival, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(2, 2, 2), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Departure, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(1, 1, 1), "B2");

		control.addFlight(flight1);
		control.cancelFlight(flight1.getFlightNumber());
		control.addFlight(flight2);
		control.sortFlightsByStatus();
		Flight[] test = {flight2, flight1};
		assertArrayEquals(test, control.getPresentationFlights().toArray());
	}

	///Sort

	///Filter

	@Test
	public void filterByAirlineTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Arrival, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(2, 2, 2), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Departure, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(1, 1, 1), "B2");

		control.addFlight(flight1);
		control.addFlight(flight2);
		control.filterByAirLine("TestAirline1");
		Flight[] test = {flight1};
		assertArrayEquals(test, control.getPresentationFlights().toArray());
	}

	@Test
	public void filterByCountryTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Arrival, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(2, 2, 2), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Departure, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(1, 1, 1), "B2");

		control.addFlight(flight1);
		control.addFlight(flight2);
		control.filterByCountry("TestCountry1");
		Flight[] test = {flight1};
		assertArrayEquals(test, control.getPresentationFlights().toArray());
	}

	@Test
	public void filterByCityTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Arrival, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(2, 2, 2), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Departure, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(1, 1, 1), "B2");

		control.addFlight(flight1);
		control.addFlight(flight2);
		control.filterByCity("TestCity1");
		Flight[] test = {flight1};
		assertArrayEquals(test, control.getPresentationFlights().toArray());
	}

	@Test
	public void filterByAirportTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Arrival, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(2, 2, 2), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Departure, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(1, 1, 1), "B2");

		control.addFlight(flight1);
		control.addFlight(flight2);
		control.filterByAirport("TestAirport1");
		Flight[] test = {flight1};
		assertArrayEquals(test, control.getPresentationFlights().toArray());
	}
	
	

	@Test
	public void filterByFlightDateMarginTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Arrival, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(20, 2, 2), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Departure, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(10, 1, 1), "B2");

		control.addFlight(flight1);
		control.addFlight(flight2);
		control.filterByFlightDateMargin(LocalDate.of(11,1,1), LocalDate.of(30, 1, 1));
		Flight[] test = {flight1};
		assertArrayEquals(test, control.getPresentationFlights().toArray());
	}
	
	@Test
	public void filterByFlightDayOfWeekTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Arrival, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(2020, 6, 12), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Departure, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(10, 1, 2), "B2");

		control.addFlight(flight1);
		control.addFlight(flight2);
		control.filterByDayOfWeek("Friday");
		Flight[] test = {flight1};
		assertArrayEquals(test, control.getPresentationFlights().toArray());
	}
	


	@Test
	public void filterByGateTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Arrival, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(2, 2, 2), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Departure, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(1, 1, 1), "B2");

		control.addFlight(flight1);
		control.addFlight(flight2);
		control.filterByGate("A1");
		Flight[] test = {flight1};
		assertArrayEquals(test, control.getPresentationFlights().toArray());
	}

	@Test
	public void filterByStatusTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Arrival, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(2, 2, 2), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Departure, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(1, 1, 1), "B2");

		control.addFlight(flight1);
		control.addFlight(flight2);
		control.cancelFlight(flight2.getFlightNumber());
		control.filterByStatus(eStatus.OnTime);
		Flight[] test = {flight1};
		assertArrayEquals(test, control.getPresentationFlights().toArray());
	}

	///Filter

	///Show
/*	@Test
	public void showFlighsTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Arrival, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(2021, 4, 4), Duration.ofMinutes(4), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Departure, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(2021, 3, 3), Duration.ofMinutes(3), "B2");
		Flight flight3 = new Flight("TestAirline3", eType.Arrival, "TestCountry3", "TestCity3", "TestAirport3", LocalDate.of(2021, 2, 2), Duration.ofMinutes(2), "C3");
		Flight flight4 = new Flight("TestAirline4", eType.Departure, "TestCountry3", "TestCity4", "TestAirport4", LocalDate.of(2021, 1, 1), Duration.ofMinutes(1), "D4");
		control.addFlight(flight1);
		control.addFlight(flight2);
		control.cancelFlight(flight2.getFlightNumber());
		control.addFlight(flight3);
		control.addFlight(flight4);
		
		StringBuffer str = new StringBuffer("Flights: \n");
		str.append("1- Flight number: "+ flight1.getFlightNumber() +" of Airline: TestAirline1 | "
				   + "Arrival from: TestAirport1 airport- TestCity1, TestCountry1 "
				   + "in gate: A1 at 2021-04-04 | Flight duration: 4 minutes | Current status: OnTime\n");
		
		str.append("2- Flight number: "+ flight2.getFlightNumber() +" of Airline: TestAirline2 | "
				   + "Departure from: TestAirport2 airport- TestCity2, TestCountry2 "
				   + "in gate: B2 at 2021-03-03 | Flight duration: 3 minutes | Current status: Canceled\n");
		
		str.append("3- Flight number: "+ flight3.getFlightNumber() +" of Airline: TestAirline3 | "
				   + "Arrival from: TestAirport3 airport- TestCity3, TestCountry3 "
				   + "in gate: C3 at 2021-02-02 | Flight duration: 2 minutes | Current status: OnTime\n");
		
		str.append("4- Flight number: "+ flight4.getFlightNumber() +" of Airline: TestAirline4 | "
				   + "Departure from: TestAirport4 airport- TestCity4, TestCountry4 "
				   + "in gate: D4 at 2021-01-01 | Flight duration: 1 minutes | Current status: OnTime\n");
		
		String t = control.showFlights();
		assertEquals(str.toString(), t);
		
	}*/

	///Show
}
