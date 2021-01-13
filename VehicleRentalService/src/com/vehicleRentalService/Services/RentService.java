package com.vehicleRentalService.Services;

import com.vehicleRentalService.Entities.Booking;
import com.vehicleRentalService.Entities.Branch;
import com.vehicleRentalService.Entities.Vehicle;
import com.vehicleRentalService.Repositories.BookingsRepository;
import com.vehicleRentalService.Repositories.BranchRepository;

import java.util.List;
import java.util.Optional;

public class RentService {
    public static void rentVehicle(Booking booking){
        Branch branch = BranchRepository.branchMap.get(booking.getBranchName());
        List<Vehicle> vehicles = branch.getVehicleList();
        Optional<Vehicle> v = vehicles.stream().filter(vehicle1 -> vehicle1.getName().equals(booking.getVehicleName())).findFirst();

        if(v.isPresent()){
            vehicles.forEach(vehicle1 -> {
                if(vehicle1.getName().equals(booking.getVehicleName())){
                    for(int i=booking.getStartTime();i<=booking.getEndTime();i++) {
                        if (vehicle1.getVehicleAvailability()[i] <= 0) {
                            System.out.println("All the vehicles have been rented out.");
                            return;
                        }
                    }

                    for(int i=booking.getStartTime();i<=booking.getEndTime();i++){
                        vehicle1.getVehicleAvailability()[i] -= 1;
                    }
                    BookingsRepository.bookings.add(booking);
                    System.out.println("Vehicle is rented!");
                }
            });
        }else{
            System.out.println("Vehicle is not present at the branch.");
        }
    }
}
