package kz.kstu.kutsinas.utils.comparators;

import kz.kstu.kutsinas.entities.Flight;

import java.util.Comparator;

public class FlightDepartureDateComparator implements Comparator<Flight> {
    public int compare(Flight o1, Flight o2) {
        return o1.getDepartureDate().compareTo(o2.getDepartureDate());
    }

}
