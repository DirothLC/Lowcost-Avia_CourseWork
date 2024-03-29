package kz.kstu.kutsinas.utils;

import kz.kstu.kutsinas.entities.*;
import kz.kstu.kutsinas.utils.comparators.*;

import java.util.Collections;
import java.util.List;

public class Actions {

    public static void serializationExample(List<Client>clients){
        Manager manager=new Manager();
        manager.clientsSerialization(clients);
        clients.clear();
        System.out.println(clients.isEmpty());
        clients=manager.clientsDeserialization();
        Reporter.print(clients);
    }
    public static void cloneExample(List<Flight>flights){
        System.out.println(flights.get(1));
        Flight cloned=flights.get(1);
        try {
            Flight cloned1=cloned.clone();
            System.out.println(cloned1);
            System.out.println(cloned1==cloned);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void collectionSortExample(List<Flight>flights){
        Collections.sort(flights,new FlightDestinationComparator());
        Reporter.print(flights);
    }
}
