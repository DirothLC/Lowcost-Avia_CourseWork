package kz.kstu.kutsinas.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client implements Cloneable, Serializable {
    private String name;
   private String passID;
   private List<Ticket> tickets;
    private static final long serialVersionUID = 1001179985668205380L;
transient int example=23;
    public Client() {

    }

    public Client(String name, String passID) {
        this.name = name;
        this.passID = passID;
    }
public Client clone(){
        return new Client(this.getName(),this.getPassID());
}
    public String getName() {
        return name;
    }



    public List<Ticket> getTickets() {
        return tickets;
    }
    public String getPassID() {
        return passID;
    }




    @Override
    public String toString() {
        return "Клиент: " +
                " Имя: " + name + '\'' +
                ", паспортные данные: " + passID + '\''
                + " билет на рейс: "+tickets
                +" transient field "+example;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(passID, client.passID)  && Objects.equals(tickets, client.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passID, tickets);
    }

    public void buyTicket(Ticket ticket){
        if(tickets==null){
            tickets=new ArrayList<>();
        }
        if(ticket!=null){
            tickets.add(ticket);
        }
    }

    public void sellTicket(Ticket ticket){
        if(tickets!=null) {
            if (ticket != null) {
                tickets.remove(ticket);
            }
        }
    }
}
