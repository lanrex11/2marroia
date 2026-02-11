package businessLogic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;

import javax.persistence.*;

import domain.ConcreteFlight;
import domain.Flight;

import dataAccess.FlightDataAccess;

public class FlightManager implements FlightManagerInterface{

	private FlightDataAccess db;

	public FlightManager () {
		db = new FlightDataAccess();
		db.open();
	}

	public List<String> getAllDepartingCities(){
		return db.getAllDepartingCities();
	}

	public List<String> getArrivalCitiesFrom(String departingCity){
		return db.getArrivalCitiesFrom(departingCity);
					
	}

	public Collection<ConcreteFlight> getConcreteFlights(String departingCity, String arrivingCity, Date date) {
		return db.getConcreteFlights(departingCity, arrivingCity, date);
	}
	public void updateSeats(String type, ConcreteFlight flight) {
		db.updateSeats(flight, type);
	}
	

}
