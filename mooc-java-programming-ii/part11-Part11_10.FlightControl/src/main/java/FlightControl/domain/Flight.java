package FlightControl.domain;

public class Flight {

    private Airplane airplane;
    private Place departureAirport;
    private Place arrivalAirport;

    public Flight(Airplane airplane, Place departureAirport, Place arrivalAirport) {
        this.airplane = airplane;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public Place getDepartureAirport() {
        return departureAirport;
    }

    public Place getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public String toString() {
        return this.airplane.toString() + " (" + this.departureAirport + "-" + this.arrivalAirport + ")";
    }
}
