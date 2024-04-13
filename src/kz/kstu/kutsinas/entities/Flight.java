package kz.kstu.kutsinas.entities;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.util.Objects;
import java.util.Random;

public class Flight extends AbstractFlight implements Serializable {
    private static final long serialVersionUID = 3926081639289348764L;
    protected Duration flightTime;
    protected int numberOfPassengers;


    public Flight() {
    }

    public Flight(int flightNumber, LocalDateTime departureDate, Duration flightTime, String destination, String depart, int numberOfPassengers) {
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.flightTime = flightTime;
        this.destination = destination;
        this.depart = depart;
        this.numberOfPassengers = numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public Duration getFlightTime() {
        return flightTime;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    @Override
    public void flightDelay() {
        Random random=new Random();
        this.departureDate=this.departureDate.plusHours(random.nextInt(1,5));
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return "Рейс: " + flightNumber +
                "  Дата отправления: " + departureDate.format(dateTimeFormatter) +
                ", Время полета: " + flightTime.toHours() + " часов" +
                ", Пункт назначения: '" + destination + '\'' +
                ", Пункт отправления: '" + depart + '\'' +
                ", Количество пассажиров: " + numberOfPassengers;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight that = (Flight) o;
        return flightNumber == that.flightNumber && Objects.equals(departureDate, that.departureDate) && Objects.equals(destination, that.destination) && Objects.equals(depart, that.depart) && Objects.equals(flightTime, that.flightTime) && Objects.equals(numberOfPassengers, that.numberOfPassengers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), flightTime, numberOfPassengers);
    }

    public Flight clone() throws CloneNotSupportedException {

        return new Flight(this.getFlightNumber(), this.getDepartureDate(), this.getFlightTime(), this.getDestination(), this.getDepart(), this.getNumberOfPassengers());
    }
    public int compareTo(AbstractFlight o) {
        return this.depart.compareTo(o.getDepart());
    }


}




