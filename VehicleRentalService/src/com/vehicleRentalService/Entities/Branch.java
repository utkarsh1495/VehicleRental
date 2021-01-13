package com.vehicleRentalService.Entities;

import java.util.List;

public class Branch {
    String name;
    List<Vehicle> vehicleList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }
}
