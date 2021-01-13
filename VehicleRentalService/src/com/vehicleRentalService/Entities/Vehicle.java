package com.vehicleRentalService.Entities;

public class Vehicle {
    int vehicleId;
    String name;
    int price;
    int orignalCount;
    int presentCount;

    public int[] getVehicleAvailability() {
        return vehicleAvailability;
    }

    public void setVehicleAvailability(int[] vehicleAvailability) {
        this.vehicleAvailability = vehicleAvailability;
    }

    int[] vehicleAvailability = new int[24];

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOrignalCount() {
        return orignalCount;
    }

    public void setOrignalCount(int orignalCount) {
        this.orignalCount = orignalCount;
    }

    public int getPresentCount() {
        return presentCount;
    }

    public void setPresentCount(int presentCount) {
        this.presentCount = presentCount;
    }
}
