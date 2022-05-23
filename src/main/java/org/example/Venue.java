package org.example;

public class Venue {

    String name;
    String address;
    Integer capacity;
    Double cost;

    public Venue(String name, String address, Integer capacity, Double cost) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.cost = cost;
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

}