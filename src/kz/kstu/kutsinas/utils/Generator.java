package kz.kstu.kutsinas.utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kz.kstu.kutsinas.entities.*;
import java.nio.file.*;
import java.io.IOException;

public class Generator {

    public static List<Ticket> generateTickets(int n) {
        List<Ticket> tickets = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            double basePrice = 20.0;
            double priceRange = 150.0;
            double randomFactor = random.nextDouble();
            double price = basePrice + randomFactor * priceRange;

            char row = (char) ('A' + random.nextInt(10));
            int seatNumber = random.nextInt(20) + 1;
            String seat = String.valueOf(row) + seatNumber;

            String[] advices ={
                    "Отсутствуют","Багаж","Приоритет на посадку","Багаж, приоритетом на посадку"
            };
            int adviceID= random.nextInt(advices.length);
            String advice=advices[adviceID];
             if (adviceID==1) {
                price+=20;
            } else if (adviceID==2) {
                price+=30;
            } else if (adviceID==3) {
                price+=50;
            }

            Ticket ticket = new Ticket(price, seat,advice);
            tickets.add(ticket);

        }

        return tickets;
    }
    public static List<Ticket> generateTickets(List<Flight> flights,int n) {
        List<Ticket> tickets = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < flights.size(); i++) {
            Flight flight=flights.get(i);
            for (int j = 0; j < n; j++) {
                double basePrice = 20.0;
                double priceRange = 150.0;
                double randomFactor = random.nextDouble();
                double price = basePrice + randomFactor * priceRange;

                char row = (char) ('A' + random.nextInt(10));
                int seatNumber = random.nextInt(20) + 1;
                String seat = String.valueOf(row) + seatNumber;

                String[] advices = {
                        "Отсутствуют", "Багаж", "Приоритет на посадку", "Багаж, приоритетом на посадку"
                };
                int adviceID = random.nextInt(advices.length);
                String advice = advices[adviceID];
                if (adviceID == 1) {
                    price += 20;
                } else if (adviceID == 2) {
                    price += 30;
                } else if (adviceID == 3) {
                    price += 50;
                }


                Ticket ticket = new Ticket(price,flight, seat, advice);
                tickets.add(ticket);

            }
        }
        return tickets;
    }

    public static List<Client> generateClients(int n) {
        List<Client> clients = new ArrayList<>();
        Random random = new Random();
        String filePathN="ClientNames.txt";
        String filePathS="ClientSurnames.txt";
        try {
            String contentN = new String(Files.readAllBytes(Paths.get(filePathN)));
            String[] names = contentN.split(", ");
            String contentS = new String(Files.readAllBytes(Paths.get(filePathS)));
            String[] surnames = contentS.split(", ");

            for (int i = 0; i < n; i++) {
                int nameID = random.nextInt(names.length);
                int surnameID = random.nextInt(surnames.length);
                String name = names[nameID] +" "+ surnames[surnameID];

                StringBuilder generatePassID = new StringBuilder(12);
                for (int j = 0; j < 12; j++) {
                    int digit = random.nextInt(10);
                    generatePassID.append(digit);
                }
                String passID = generatePassID.toString();

                Client client = new Client(name, passID);
                clients.add(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return clients;
    }
    

    public static List<Flight> generateFlights(int n) {
        List<Flight> flights = new ArrayList<>();
        Random random = new Random();
        String filePathDestinations="Destinations.txt";
        String filePathDeparts="Departs.txt";
        try {
            String contentDestination = new String(Files.readAllBytes(Paths.get(filePathDestinations)));
            String[] destinations = contentDestination.split(", ");
            String contentDepart = new String(Files.readAllBytes(Paths.get(filePathDeparts)));
            String[] departs = contentDepart.split(", ");

            for (int i = 0; i < n; i++) {
                int flightNumber = random.nextInt(100,999);

                LocalDateTime currentDate = LocalDateTime.now();
                int days = (int) (Math.random() * 31);
                int hours = (int) (Math.random() * 24);
                int minutes = (int) (Math.random() * 60);
                LocalDateTime departureDate = currentDate.plusDays(days).plusHours(hours).plusMinutes(minutes);

                int hoursDuration = random.nextInt(2,12);
                Duration flightTime = Duration.ofHours(hoursDuration);

                int city = random.nextInt(destinations.length);
                String destination = destinations[city];

                int departCity = random.nextInt(departs.length);
                String depart = departs[departCity];


                int numberOfPassengers = random.nextInt(10, 20);

                Flight flight = new Flight(flightNumber, departureDate, flightTime, destination, depart, numberOfPassengers);
                flights.add(flight);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }


        return flights;

    }

    public static List<TransferFlight> generateTransferFlights(int n) {
        List<TransferFlight> flights = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int flightNumber = (int) (Math.random() * 1000);

            LocalDateTime currentDate = LocalDateTime.now();
            int days = (int) (Math.random() * 31);
            int hours = (int) (Math.random() * 24);
            int minutes = (int) (Math.random() * 60);
            LocalDateTime departureDate = currentDate.plusDays(days).plusHours(hours).plusMinutes(minutes);

            int hoursDuration = (int) (Math.random() * 12);
            Duration flightTime = Duration.ofHours(hoursDuration);
            ;

            String[] destinations = { //String destination;
                    "Москва", "Санкт-Питербург", "Москва", "Пекин"
            };
            int city = random.nextInt(destinations.length);
            String destination = destinations[city];

            String[] departs = {
                    "Астана", "Алмата", "Караганда"
            };
            int departCity = random.nextInt(departs.length);
            String depart = departs[departCity];

            String[] transferSites = { //String destination;
                    "Берлин","Сидней","Бангладеш"
            };
            int site = random.nextInt(transferSites.length);
            String transferSite = transferSites[site];

            int hoursTransfer = (int) (Math.random() * 6);
            Duration afterTransfer = flightTime.minusHours(hoursTransfer);

            Duration beforeTransfer = flightTime.minus(afterTransfer);

            int numberOfPassengers = random.nextInt(90, 120);

            TransferFlight flight = new TransferFlight(flightNumber, departureDate, flightTime, destination, depart, numberOfPassengers, transferSite, afterTransfer, beforeTransfer);
            flights.add(flight);
        }
        return flights;

    }
}
