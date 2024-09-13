
package FlightControl.logic;

import FlightControl.domain.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FlightControl {
    private HashMap<String, Airplane> airplanes;
    private HashMap<String, Flight> flights;
    private Map<String, Place> places;

    public FlightControl() {
        this.airplanes = new HashMap<>();
        this.flights = new HashMap<>();
        this.places = new HashMap<>();
    }
    
    public void addAirplane(String ID, int capacity) {
        airplanes.put(ID, new Airplane(ID, capacity));
    }
    
    public void addFlight(Airplane plane, String departureId, String arrivalId) {
        places.putIfAbsent(departureId, new Place(departureId));
        places.putIfAbsent(arrivalId, new Place(arrivalId));
        
        Flight flight = new Flight(plane, places.get(departureId), places.get(arrivalId));
        flights.put(flight.toString(), flight);           
    }

    public Collection<Airplane> getAirplanes() {
        return airplanes.values();
    }
    
    public Collection<Flight> getFlights() {
        return flights.values();
    }
    
    public Airplane getAirplane(String id) {
        return airplanes.get(id);
    }
    
    
}
