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
            System.out.println("Проверка через == :");
            System.out.println(cloned1==cloned);
            System.out.println("Проверка через equals :");
            System.out.println(cloned1.equals(cloned));
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void collectionSortExample(List<Flight>flights){
        Collections.sort(flights,new FlightDestinationComparator());
        Reporter.print(flights);
    }
    public static void additionalFunctionsExample(List<Client> clients,List<Flight> flights){
        Manager manager=new Manager();
        System.out.println("\n ");
        System.out.println("Клонирование: ");
        cloneExample(flights);
        System.out.println("Пример сортировки рейсов: ");
        collectionSortExample(flights);
        System.out.println("Клиент захотел вернуть билет: ");
        System.out.println(clients.isEmpty());
        Client client=clients.get(2);
        System.out.println(client);
        Ticket ticket=client.getTickets().get(0);
        Flight flight=ticket.getFlight();
        System.out.println(flight);
        manager.acceptReturns(client,flight);
        System.out.println(client);
        System.out.println(flight);
        System.out.println("\n ");
        System.out.println("Реализация интерфейса: ");
        flight.flightDelay();
        System.out.println(flight);
        System.out.println("\n ");


    }
}
