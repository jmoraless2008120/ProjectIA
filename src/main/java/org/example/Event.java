package org.example;

public class Event {
    int date;
    int peopleInvited;

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
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

    public String getHourAvailability() {
        return hourAvailability;
    }

    public void setHourAvailability(String hourAvailability) {
        this.hourAvailability = hourAvailability;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    double ticketPrice;
    String hourAvailability;
    String eventType;

    public Event(int date, int peopleInvited, double ticketPrice, String hourAvailability, String eventType) {
        this.date = date;
        this.peopleInvited = peopleInvited;
        this.ticketPrice = ticketPrice;
        this.hourAvailability = hourAvailability;
        this.eventType = eventType;
    }


}
