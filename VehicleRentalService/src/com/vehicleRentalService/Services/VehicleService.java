package com.vehicleRentalService.Services;

import com.vehicleRentalService.Entities.Branch;
import com.vehicleRentalService.Entities.Vehicle;
import com.vehicleRentalService.Repositories.BranchRepository;

import java.util.List;
import java.util.Optional;

public class VehicleService {
    public static void addNewVehicle(String branchName, Vehicle vehicle, int count){
        Branch branch = BranchRepository.branchMap.get(branchName);
        if(branch == null){
            System.out.println("Branch doesnot exist.");
            return;
        }
        List<Vehicle> vehicles = branch.getVehicleList();

        Optional<Vehicle> v = vehicles.stream().filter(vehicle1 -> vehicle1.getName().equals(vehicle.getName())).findFirst();

        if(v.isPresent()){
            //increase count
            vehicles.forEach(vehicle1 -> {
                if(vehicle1.getName().equals(vehicle.getName())){
                    for(int i=0;i<24;i++){
                        vehicle1.getVehicleAvailability()[i]+= count;
                    }
                }
            });
        }else{
            //Added a new vehicle
            System.out.println("Vehicle category is not present.");
            return;
        }

        System.out.println("Vehicle is added!");
    }
}
