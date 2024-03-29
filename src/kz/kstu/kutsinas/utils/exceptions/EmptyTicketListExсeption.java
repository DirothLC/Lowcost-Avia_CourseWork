package kz.kstu.kutsinas.utils.exceptions;

public class EmptyTicketListExсeption extends Exception{
    public EmptyTicketListExсeption(String message) {
        super(message);
    }

    public EmptyTicketListExсeption(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyTicketListExсeption(){
super("Error: no tickets available for sale");
    }
}
