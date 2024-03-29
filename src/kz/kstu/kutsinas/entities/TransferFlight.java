package kz.kstu.kutsinas.entities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public final class TransferFlight extends Flight {
    private String transferSite;
    private Duration flightTimeAfterTransfer;
    private Duration flightTimeBeforeTransfer;


    public TransferFlight(String transferSite, Duration flightTimeAfterTransfer, Duration flightTimeBeforeTransfer) {
        this.transferSite = transferSite;
        this.flightTimeAfterTransfer = flightTimeAfterTransfer;
        this.flightTimeBeforeTransfer=flightTimeBeforeTransfer;
    }

    public TransferFlight(int flightNumber, LocalDateTime departureDate, Duration flightTime, String destination, String depart, int numberOfPassengers, String transferSite, Duration flightTimeAfterTransfer, Duration flightTimeBeforeTransfer) {
        super(flightNumber, departureDate, flightTime, destination, depart, numberOfPassengers);
        this.transferSite = transferSite;
        this.flightTimeAfterTransfer = flightTimeAfterTransfer;
        this.flightTimeBeforeTransfer=flightTimeBeforeTransfer;
    }
public TransferFlight clone() throws CloneNotSupportedException {
        return new TransferFlight(this.getFlightNumber(), this.getDepartureDate(), this.getFlightTime(), this.getDestination(), this.getDepart(), this.getNumberOfPassengers(),this.getTransferSite(),this.getFlightTimeAfterTransfer(),this.getFlightTimeBeforeTransfer());
}
    public String getTransferSite() {
        return transferSite;
    }

    public Duration getFlightTimeAfterTransfer() {
        return flightTimeAfterTransfer;
    }

    public Duration getFlightTimeBeforeTransfer() {
        return flightTimeBeforeTransfer;
    }

    @Override
    public String toString() {
        return super.toString()+
                " место пересадки: " + transferSite +
                ", время полета после пересадки: " + flightTimeAfterTransfer +
                ", время полета до пересадки: " + flightTimeBeforeTransfer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TransferFlight that = (TransferFlight) o;
        return Objects.equals(transferSite, that.transferSite) && Objects.equals(flightTimeAfterTransfer, that.flightTimeAfterTransfer) && Objects.equals(flightTimeBeforeTransfer, that.flightTimeBeforeTransfer)&& Objects.equals(departureDate, that.departureDate) && Objects.equals(destination, that.destination) && Objects.equals(depart, that.depart) && Objects.equals(flightTime, that.flightTime) && Objects.equals(numberOfPassengers, that.numberOfPassengers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), transferSite, flightTimeAfterTransfer, flightTimeBeforeTransfer);
    }
}
