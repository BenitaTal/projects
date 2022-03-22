package FlightsControl;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import FlightsControl.Flight.eStatus;
import FlightsControl.Flight.eType;

public class FlightsControl {
	private ArrayList<Flight> flights;
	private ArrayList<Flight> presentationFlights;

	public FlightsControl() {
		this.flights = new ArrayList<>();
		this.presentationFlights = new ArrayList<>();
	}
	
	public FlightsControl(Scanner scan) throws FileNotFoundException {
		int flightsSize = scan.nextInt();
		this.flights = new ArrayList<>(flightsSize);
		for(int i = 0; i < flightsSize; i++) {
			this.flights.set(i, new Flight(scan));
		}
	}
	
	public void save(String fileName) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fileName);
		pw.println("Total flights: "+this.flights.size() + "\n");
		for(Flight flight : this.flights) {
			flight.save(pw);
		}
		pw.close();
	}
	
	/// save data to file///
	
	public void save(PrintWriter pw) throws FileNotFoundException {
		pw.println(this.flights.size() + "\n");
		for(Flight flight : this.flights) {
			flight.save(pw);
		}
		pw.close();
	}
	/// save data to file///
	

	///Sorting
	public void sortFlightsByDate(){
		int n = this.presentationFlights.size(); 
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-i-1; j++) { 
				if (this.presentationFlights.get(j).getFlightDate().isAfter(this.presentationFlights.get(j+1).getFlightDate())) { 
					Flight temp = this.presentationFlights.get(j); 
					this.presentationFlights.set(j, this.presentationFlights.get(j+1)); 
					this.presentationFlights.set(j+1, temp); 
				} 
			}
		}
	}

	public void sortFlightsByFlightType(){
		int n = this.presentationFlights.size(); 
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-i-1; j++) { 
				if (this.presentationFlights.get(j).getType().ordinal() > this.presentationFlights.get(j+1).getType().ordinal()) { 
					Flight temp = this.presentationFlights.get(j); 
					this.presentationFlights.set(j, this.presentationFlights.get(j+1)); 
					this.presentationFlights.set(j+1, temp); 
				} 
			}
		}
	}
	
	public void sortFlightsByStatus() {
		int n = this.presentationFlights.size(); 
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-i-1; j++) { 
				if (this.presentationFlights.get(j).getStatus().ordinal() > this.presentationFlights.get(j+1).getStatus().ordinal()) { 
					Flight temp = this.presentationFlights.get(j); 
					this.presentationFlights.set(j, this.presentationFlights.get(j+1)); 
					this.presentationFlights.set(j+1, temp); 
				} 
			}
		}
	}
	
	///Filtering
	
	public void filterByFlightType(eType type) {
		for(int i = 0; i < this.presentationFlights.size(); i++) {
			if(!this.presentationFlights.get(i).getType().equals(type)) {
				this.presentationFlights.remove(i);
				i--;
			}
		}
	}
	
	public void filterByAirLine(String airline) {
		for(int i = 0; i < this.presentationFlights.size(); i++) {
			if(!this.presentationFlights.get(i).getAirline().equals(airline)) {
				this.presentationFlights.remove(i);
				i--;
			}
		}
	}
	
	public void filterByCountry(String country) {
		for(int i = 0; i < this.presentationFlights.size(); i++) {
			if(!this.presentationFlights.get(i).getDestination().equals(country)) {
				this.presentationFlights.remove(i);
				i--;
			}
		}
	}
	
	public void filterByCity(String city) {
		for(int i = 0; i < this.presentationFlights.size(); i++) {
			if(!this.presentationFlights.get(i).getCity().equals(city)) {
				this.presentationFlights.remove(i);
				i--;
			}
		}
	}
	
	public void filterByAirport(String airport) {
		for(int i = 0; i < this.presentationFlights.size(); i++) {
			if(!this.presentationFlights.get(i).getAirport().equals(airport)) {
				this.presentationFlights.remove(i);
				i--;
			}
		}
	}

	public void filterByFlightDateMargin(LocalDate start, LocalDate end) {
		for(int i = 0; i < this.presentationFlights.size(); i++) {
			if(!(this.presentationFlights.get(i).getFlightDate().isAfter(start) && this.presentationFlights.get(i).getFlightDate().isBefore(end))) {
				this.presentationFlights.remove(i);
				i--;
			}
		}
	}
	
	public void filterByDayOfWeek(String dayOfWeek) {
		for(int i = 0; i < this.presentationFlights.size(); i++) {
			if(!this.presentationFlights.get(i).getFlightDate().getDayOfWeek().toString().equalsIgnoreCase(dayOfWeek)) {
				this.presentationFlights.remove(i);
				i--;
			}
		}
	}
	
	public void filterByGate(String gate) {
		for(int i = 0; i < this.presentationFlights.size(); i++) {
			if(!this.presentationFlights.get(i).getGate().equals(gate)) {
				this.presentationFlights.remove(i);
				i--;
			}
		}
	}
	public void filterByStatus(eStatus status) {
		for(int i = 0; i < this.presentationFlights.size(); i++) {
			if(!this.presentationFlights.get(i).getStatus().equals(status)) {
				this.presentationFlights.remove(i);
				i--;
			}
		}
	}
	
	public void removeFilters() {
		this.presentationFlights = this.flights;
	}
	
	public void filterByArgs(eType type, String airline, String country, String city, String airport, LocalDate startDate, LocalDate endDate, String dayOFWeek, String gate, eStatus status) {
		this.filterByFlightType(type);
		this.filterByAirLine(airline);
		this.filterByCountry(country);
		this.filterByCity(city);
		this.filterByAirport(airport);
		this.filterByFlightDateMargin(startDate, endDate);
//		this.filterByDayOfWeek(dayOFWeek);
		this.filterByGate(gate);
		this.filterByStatus(status);
	}
	
	/// arithmetic
	
	public ArrayList<Flight> getFlights() {
		return this.flights;
	}
	
	public ArrayList<Flight> getPresentationFlights() {
		return this.presentationFlights;
	}
	
    public static String generateFlightNumber(int n) 
    { 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"; 
  
        StringBuilder sb = new StringBuilder(n); 
 
        for (int i = 0; i < n; i++) { 
            int index 
                = (int)(AlphaNumericString.length() * Math.random()); 
  
            sb.append(AlphaNumericString.charAt(index)); 
        } 
        return sb.toString(); 
    }

	public boolean addFlight(Flight flight) {
		String flightNum = "";
		boolean b = false;
		while(!b) {
			flightNum = generateFlightNumber(8);
			if(!isFlightNumExist(flightNum))
				b = true;
		}
		flight.setFlightNumber(flightNum);
		this.flights.add(flight);
		this.presentationFlights.add(flight);
		return true;
	} 
	
	private boolean isFlightNumExist(String flightNum) {
		for(Flight flight : this.flights)
			if(flight.getFlightNumber().equals(flightNum))
				return true;
		return false;
	}

	public boolean cancelFlight(String flightNumber) {
		for(int i = 0; i < this.flights.size(); i++) {
			if(this.flights.get(i).getFlightNumber().equals(flightNumber)) {
				this.flights.get(i).setStatus(eStatus.Canceled);
				return true;
			}
		}
		return false;
	}
	
	private void refresh() {
		Flight temp = null;
		
		for(int i = 0; i < this.flights.size(); i++) {
			if(!this.flights.get(i).getFlightDate().isAfter(LocalDate.now())) {
				temp = this.flights.get(i);
				this.flights.remove(i);
				i--;
				removeFlightFromPresentList(temp);
			}
		}
	}

	private void removeFlightFromPresentList(Flight flight) {
		for(int i = 0; i < this.presentationFlights.size(); i++) {
			if(this.presentationFlights.get(i).equals(flight))
				this.presentationFlights.remove(i);
		}
	}
	
	///Displaying

	public String showFlights() {
		refresh();
		
		StringBuffer str = new StringBuffer("Flights: \n");
		for(int i = 0; i < presentationFlights.size(); i++) {
			str.append((i+1) +"- "+presentationFlights.get(i).toString() + "\n");
		}
		
		return str.toString();
	}
	
	public String showFlightsTable() {
		refresh();
		
		StringBuffer str = new StringBuffer("<h2>Flights:</h2> <br>");
		str.append("<table style='width:100%'>");
		str.append("<tr align='left'><th>Airline</th>");
		str.append("<th>Flight number</th>");
		str.append("<th>Flight date</th>");
		str.append("<th>Flight day</th>");
		str.append("<th>Country</th>");
		str.append("<th>Airport</th>");
		str.append("<th>City</th>");
		str.append("<th>Gate</th>");
		str.append("<th>Status</th></tr>");
		for(int i = 0; i < presentationFlights.size(); i++) {
			str.append("<tr>"+ presentationFlights.get(i).toStringTable() + "</tr>");
		}
		str.append("</table>");
		
		return str.toString();
	}
	
	public void addHardCode() {
		///hard code///

		//1
		LocalDate ld= LocalDate.of(2021, 5, 14);
		Flight f = new Flight("El Al", eType.Departure, "Spain", "Madrid", "Barajas", ld, "A1");
		this.addFlight(f);
		//2
		LocalDate ld1= LocalDate.of(2021, 6, 26);
		Flight f1 = new Flight("Air France", eType.Arrival, "France", "Paris", "Charles de Gaulle", ld1, "B5");
		this.addFlight(f1);
		//3
		LocalDate ld2= LocalDate.of(2021, 1, 10);
		Flight f2 = new Flight("Air India", eType.Departure, "India", "Delhi", "Indira Gandhi", ld2, "C2");
		this.addFlight(f2);
		//4
		LocalDate ld3= LocalDate.of(2021, 4, 10);
		Flight f3 = new Flight("Turkish Airlines", eType.Departure, "Turkey", "Istanbul", "Istanbul", ld3, "A2");
		this.addFlight(f3);
		//5
		LocalDate ld4= LocalDate.of(2021, 3, 28);
		Flight f4 = new Flight("Air Canada", eType.Arrival, "Canada", "Toronto", "Pearson", ld4, "B2");
		this.addFlight(f4);
		//6
		LocalDate ld5= LocalDate.of(2021, 8, 16);
		Flight f5 = new Flight("Thai Airways", eType.Arrival, "Thailand", "Bangkok", "Suvarnabhumi ", ld5, "C1");
		this.addFlight(f5);
		//7
		LocalDate ld6= LocalDate.of(2021, 10, 10);
		Flight f6 = new Flight("Pegasus Airlines", eType.Departure, "Greece", "Athens", "Eleftherios Venizelos", ld6, "C3");
		this.addFlight(f6);
		//8 
		LocalDate ld7= LocalDate.of(2021, 12, 3);
		Flight f7 = new Flight("Israir", eType.Arrival, "Italy", "Rome", "Aeroporto Leonardo da Vinci di Fiumicino", ld7, "A3");
		this.addFlight(f7);
		//9
		LocalDate ld8= LocalDate.of(2021, 7, 28);
		Flight f8 = new Flight("Vietnam Airlines", eType.Departure, "Vietnam", "Hanoi", "Noi Bai", ld8, "B3");
		this.addFlight(f8);
		//10
		LocalDate ld9= LocalDate.of(2021, 2, 7);
		Flight f9 = new Flight("El Al", eType.Departure, "Austria", "Vienna", "Vienna", ld9, "A1");
		this.addFlight(f9);
		//11
		LocalDate ld10= LocalDate.of(2021, 4, 15);
		Flight f10 = new Flight("Turkish Airlines", eType.Arrival, "United States", "New York", "JFK", ld10, "B1");
		this.addFlight(f10);
		//12
		LocalDate ld11= LocalDate.of(2021, 5, 19);
		Flight f11 = new Flight("El Al", eType.Departure, "England", "London", "Heathrow", ld11, "B17");
		this.addFlight(f11);

		///hard code///
	}
}
