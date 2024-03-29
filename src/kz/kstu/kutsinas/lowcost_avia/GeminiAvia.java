package kz.kstu.kutsinas.lowcost_avia;

import kz.kstu.kutsinas.entities.*;
import kz.kstu.kutsinas.utils.*;
import kz.kstu.kutsinas.utils.comparators.*;
import kz.kstu.kutsinas.utils.exceptions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeminiAvia {
    public static void main(String[] args) {
        Manager manager = new Manager();
        List<Flight> flights = manager.getFlights(10);
        Reporter.print(flights);
        List<Client> clients=manager.getClients(10);
        Reporter.print(clients);
        List<Ticket> tickets=manager.getTickets(flights,20);
        List<Ticket> soldTickets= new ArrayList<>();

        soldTickets = manager.createSoldTicketList(clients,tickets);

        Reporter.print(soldTickets);
        Reporter.print(clients);
        tickets=manager.updateTicketList(tickets,soldTickets);
Reporter.print(tickets);
System.out.println("\n");
        List<Ticket>soldTickets1 = manager.createSoldTicketList(clients,tickets);
        Reporter.print(soldTickets1);
Actions.serializationExample(clients);
    }

}