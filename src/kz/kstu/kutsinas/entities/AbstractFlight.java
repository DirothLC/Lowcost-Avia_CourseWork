package kz.kstu.kutsinas.entities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class AbstractFlight implements Cloneable,Comparable<AbstractFlight> {
    protected int flightNumber;
    protected LocalDateTime departureDate;
    protected String destination;
    protected String depart;

    public int getFlightNumber() {
        return flightNumber;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepart() {
        return depart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractFlight that = (AbstractFlight) o;
        return flightNumber == that.flightNumber && Objects.equals(departureDate, that.departureDate) && Objects.equals(destination, that.destination) && Objects.equals(depart, that.depart);
    }



    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, departureDate, destination, depart);
    }

}
