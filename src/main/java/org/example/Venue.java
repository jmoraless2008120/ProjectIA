package org.example;

public class Venue {

    public Venue(String name, String address, Integer capacity, Double cost) {
        Name = name;
        Address = address;
        Capacity = capacity;
        Cost = cost;
    }
String Name;
String Address;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Integer getCapacity() {
        return Capacity;
    }

    public void setCapacity(Integer capacity) {
        Capacity = capacity;
    }

    public Double getCost() {
        return Cost;
    }

    public void setCost(Double cost) {
        Cost = cost;
    }

    Integer Capacity;
Double Cost;
}
