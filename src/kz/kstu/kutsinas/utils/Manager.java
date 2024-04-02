package kz.kstu.kutsinas.utils;

import kz.kstu.kutsinas.entities.*;
import kz.kstu.kutsinas.utils.exceptions.EmptyTicketListExсeption;

import java.io.FileOutputStream;
import java.io.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Manager {

    public List<Flight> getFlights(int n) {
        return Generator.generateFlights(n);
    }

public List<Client> getClients(int n){
    return Generator.generateClients(n);
}

public List<Ticket> getTickets(int n){
    return Generator.generateTickets(n);
}
    public List<Ticket> getTickets(List<Flight> flights,int n){
        return Generator.generateTickets(flights, n);
    }
public Ticket sellTicket(Client client, Ticket ticket) {
        Flight flight=ticket.getFlight();
    int ticketsCount = flight.getNumberOfPassengers();
    if (ticketsCount > 0) {
        double cost = ticket.getCost();
        String seat = ticket.getSeat();
        String advice=ticket.getAdvice();
        ticket = new Ticket(cost, client, flight, seat,advice);
        client.buyTicket(ticket);
        ticketsCount--;
        flight.setNumberOfPassengers(ticketsCount);
    }
    return ticket;
}

    public List<Ticket> createSoldTicketList(List<Client> clients, List<Ticket> tickets,List<Ticket> soldTickets) {

        try {
            if (tickets.isEmpty()) {
                throw new EmptyTicketListExсeption();
            }
            int counter = 0;
            Random random = new Random();
            for (int i = 0; i < tickets.size(); i++) {

            counter++;
           if(counter%5==0){i+=2;}

                Ticket ticket = tickets.get(i);
                Flight flight = ticket.getFlight();
                Client client = clients.get(random.nextInt(0, clients.size()));

                Ticket soldTicket = sellTicket(client, ticket);
                soldTicket = new Ticket(soldTicket.getCost(), client, soldTicket.getFlight(), soldTicket.getSeat(), soldTicket.getAdvice());
                soldTickets.add(soldTicket);

            }
        } catch (EmptyTicketListExсeption e) {
            System.err.println(e.getMessage());
        }

        return soldTickets;

    }
    public List<Ticket> updateTicketList(List<Ticket> tickets, List<Ticket> soldTickets){
        for(int i=0;i<soldTickets.size();i++){
            tickets.remove(soldTickets.get(i));
        }
        tickets=changeTicketsCost(tickets);
        return tickets;
    }
public void acceptReturns(Client client,Flight flight){
    List<Ticket> tickets=client.getTickets();
    for(int i=0;i<tickets.size();i++){
        Ticket ticket=tickets.get(i);
        Flight curFlight=ticket.getFlight();
        if(flight.equals(curFlight)){
            client.sellTicket(ticket);
            flight.setNumberOfPassengers(flight.getNumberOfPassengers()+1);
            break;
        }
    }
}
public void clientsSerialization(List<Client> clients){
try(FileOutputStream fileOut=new FileOutputStream("clients.ser");
ObjectOutputStream out=new ObjectOutputStream(fileOut)){
    out.writeObject(clients);
    out.close();
    System.out.println("Serialization successful");

}catch (IOException e){System.err.println(e);}

}
public List<Client> clientsDeserialization(){
    List<Client>clients=new ArrayList<>();
        try(FileInputStream fileIn=new FileInputStream("clients.ser");
        ObjectInputStream in=new ObjectInputStream(fileIn)){
            clients=(List<Client>)in.readObject();
            in.close();
            System.out.println("Deserialization successful");
        }catch (IOException e){System.err.println(e);} catch (ClassNotFoundException e) {
            System.err.println(e);;
        }
        return clients;
}
public List<Ticket> changeTicketsCost(List<Ticket> tickets){
   for(int i=0; i<tickets.size();i++){
       Ticket ticket=tickets.get(i);
       double cost=ticket.getCost();
       Flight flight=ticket.getFlight();
       LocalDateTime departureDate=flight.getDepartureDate();
       LocalDateTime currentDate=LocalDateTime.now();
       long daysUntilDeparture= ChronoUnit.DAYS.between(currentDate,departureDate);

       double priceIncreaseFactor=1.01;//цена на билет растет на 1% за каждый день до вылета
       double updatedCost=cost*Math.pow(priceIncreaseFactor,daysUntilDeparture);
       ticket.setCost(updatedCost);

   }
   return tickets;
}
}

