package com.vehicleRentalService.Services;

import com.vehicleRentalService.Entities.Branch;
import com.vehicleRentalService.Repositories.BranchRepository;

import java.util.concurrent.atomic.AtomicInteger;

public class BranchService {
    public static void addNewBranch(Branch branch){
        BranchRepository.branchMap.put(branch.getName(), branch);
        System.out.println("Branch is saved!");
    }

    public static void getAvailableVehicle(String branchName, int startTime, int endTime){
        AtomicInteger count= new AtomicInteger(100000);
        BranchRepository.branchMap.get(branchName).getVehicleList().forEach(vehicle -> {
            for(int i=startTime;i<=endTime;i++){
                count.set(Math.min(count.get(), vehicle.getVehicleAvailability()[i]));
            }

            System.out.println(count+" "+vehicle.getName()+" available for Rs"+vehicle.getPrice());
        });
    }


}
