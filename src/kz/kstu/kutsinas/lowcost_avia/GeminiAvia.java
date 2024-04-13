package kz.kstu.kutsinas.lowcost_avia;

import kz.kstu.kutsinas.entities.*;
import kz.kstu.kutsinas.utils.*;


import java.util.ArrayList;
import java.util.List;

public class GeminiAvia {
    public static void main(String[] args) {
        Manager manager = new Manager();
        List<Flight> flights = manager.getFlights(10);
        Reporter.print(flights);
        List<Client> clients = manager.getClients(10);
        Reporter.print(clients);
        List<Ticket> tickets = manager.getTickets(flights, 20);

        List<Ticket> soldTickets = new ArrayList<>();
        soldTickets = manager.createSoldTicketList(clients, tickets,soldTickets);

        Reporter.print(soldTickets);
        Reporter.print(clients);
        tickets = manager.updateTicketList(tickets, soldTickets);
        Reporter.print(tickets);

        Actions.additionalFunctionsExample(clients,flights);
        Actions.serializationExample(clients);
    }

}