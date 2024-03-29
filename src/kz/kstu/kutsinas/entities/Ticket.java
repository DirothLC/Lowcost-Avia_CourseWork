package kz.kstu.kutsinas.entities;

import java.io.Serializable;
import java.util.Objects;
import java.text.DecimalFormat;
public class Ticket implements Cloneable, Serializable {
    private static final long serialVersionUID = 8219020434551423081L;
    double cost;
    Client pass;
    Flight flight;
    String seat;
    String advice;

    public Ticket() {
    }

    public Ticket(double cost, Client pass, Flight flight, String seat) {
        this.cost = cost;
        this.pass = pass;
        this.flight = flight;
        this.seat = seat;
    }

    public Ticket(double cost, Client pass, Flight flight, String seat, String advice) {
        this.cost = cost;
        this.pass = pass;
        this.flight = flight;
        this.seat = seat;
        this.advice = advice;
    }

    public Ticket(double cost, Flight flight, String seat, String advice) {
        this.cost = cost;
        this.flight = flight;
        this.seat = seat;
        this.advice = advice;
    }

    public Ticket(double cost, String seat, String advice) {
        this.cost = cost;
        this.seat = seat;
        this.advice = advice;
    }

public Ticket clone(){
        return new Ticket(this.getCost(),this.getPass(),this.getFlight(),this.getSeat());
}
    public Client getPass() {
        return pass;
    }
    public String getAdvice() {
        return advice;
    }

    public Flight getFlight() {
        return flight;
    }

    public String getSeat() {
        return seat;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
       if(cost!=0) this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(flight, ticket.flight) && Objects.equals(seat, ticket.seat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flight, seat);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#." + "0".repeat(2));
        String formattedCost= df.format(cost);
        String p="";
        if(pass!=null){ p=pass.getPassID() +"  "+ pass.getName();}
        return "Билет: " +
                " цена: " + formattedCost +"$ "+
                " данные о покупателе: " + p+
                ", на рейс: " + flight.getFlightNumber() +
                ", место: " + seat + '\''+
                " Дополнения: "+advice;
    }

}
