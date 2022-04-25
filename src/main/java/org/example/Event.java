package org.example;

public class Event {

    public Event(int peopleInvited, double ticketPrice, double hourAvailability, String eventType) {
        this.peopleInvited = peopleInvited;
        this.ticketPrice = ticketPrice;
        this.hourAvailability = hourAvailability;
        this.eventType = eventType;
    }

    int peopleInvited;
    double ticketPrice;
    double hourAvailability;
    String eventType;


    public Event() {

    }
}
