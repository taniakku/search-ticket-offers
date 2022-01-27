package SearchAndFilter.domain;

import java.util.Objects;

public class RouteOffer implements Comparable<RouteOffer> {
    private int id;
    private int price;
    private String airportFrom;
    private String airportTo;
    private int flightTime;

    public RouteOffer() {
    }

    public RouteOffer(int id, int price, String airportFrom, String airportTo, int flightTime) {
        this.id = id;
        this.price = price;
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
        this.flightTime = flightTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAirportFrom() {
        return airportFrom;
    }

    public void setAirportFrom(String airportFrom) {
        this.airportFrom = airportFrom;
    }

    public String getAirportTo() {
        return airportTo;
    }

    public void setAirportTo(String airportTo) {
        this.airportTo = airportTo;
    }

    public int getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }


    @Override
    public int compareTo(RouteOffer o) {
        return this.price - o.price;
    }
}
