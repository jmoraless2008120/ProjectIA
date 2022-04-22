package org.example;

public class Venue {

    public Venue(String name, String address, Integer capacity, Double cost) {
        name = name;
        address = address;
        capacity = capacity;
        cost = cost;
    }
String name;
String address;

    public Venue() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        address = address;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        capacity = capacity;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        cost = cost;
    }

    Integer capacity;
Double cost;
}
