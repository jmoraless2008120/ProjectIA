package org.example;

import java.util.Date;

public class Event {
    Date date; //calendar box to input date of event
    int peopleInvited; //integer for guests (whole numbers e.g. 100,155,3444, etc.)
    double ticketPrice; // e.g. 150.50, 85.30, etc. price of ticket can be inputted with decimals
    int hourAvailability; //inputted as amount of hours the event is going to last
    String eventType; //e.g. concert, party, disco, bar, birthday, etc.

    public Event(Date date, int peopleInvited, double ticketPrice, int hourAvailability, String eventType) {
        this.date = date;
        this.peopleInvited = peopleInvited;
        this.ticketPrice = ticketPrice;
        this.hourAvailability = hourAvailability;
        this.eventType = eventType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPeopleInvited() {
        return peopleInvited;
    }

    public void setPeopleInvited(int peopleInvited) {
        this.peopleInvited = peopleInvited;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getHourAvailability() {
        return hourAvailability;
    }

    public void setHourAvailability(int hourAvailability) {
        this.hourAvailability = hourAvailability;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }


}