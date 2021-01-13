package com.vehicleRentalService;

import com.vehicleRentalService.Entities.Booking;
import com.vehicleRentalService.Entities.Branch;
import com.vehicleRentalService.Entities.Vehicle;
import com.vehicleRentalService.Repositories.BranchRepository;
import com.vehicleRentalService.Services.BranchService;
import com.vehicleRentalService.Services.RentService;
import com.vehicleRentalService.Services.VehicleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        while (true) {
            String command = sc.nextLine();
            String[] s = command.split(" ");
            switch (s[0]) {
                case "add_branch":{
                    Branch branch = new Branch();
                    branch.setName(s[1]);
                    List<Vehicle> vehicles = new ArrayList<>();
                    for(int i=2;i<s.length;i++){

                        String[] vehicle = s[i].split(",");
                        Vehicle v = new Vehicle();
                        v.setOrignalCount(Integer.parseInt(vehicle[0]));
                        v.setName(vehicle[1]);
                        v.setPrice(Integer.parseInt(vehicle[3]));
                        vehicles.add(v);
                    }
                    branch.setVehicleList(vehicles);
                    BranchService.addNewBranch(branch);
                    break;
                }
                case "add_vehicle":{
                    Vehicle v = new Vehicle();
                    v.setName(s[3]);

                    VehicleService.addNewVehicle(s[1], v, Integer.parseInt(s[2]));
                    break;
                }
                case "rent_vehicle":{
                    Booking b = new Booking();
                    b.setBranchName(s[1]);
                    b.setVehicleName(s[2]);
                    b.setStartTime(Integer.parseInt(s[3]));
                    b.setEndTime(Integer.parseInt(s[4]));

                    RentService.rentVehicle(b);
                    break;
                }
                case "get_available_vehicles":{
                    BranchService.getAvailableVehicle(s[1], Integer.parseInt(s[2]),Integer.parseInt(s[3]));
                    break;
                }
                case "print_system_view":{
                    break;
                }
            }
        }
    }
}
