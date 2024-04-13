package kz.kstu.kutsinas.utils.comparators;

import kz.kstu.kutsinas.entities.*;
import java.util.Comparator;


public class FlightDestinationComparator implements Comparator<Flight> {
    @Override
    public int compare(Flight o1, Flight o2) {
        return o1.getDestination().compareTo(o2.getDestination());
    }
}



