package com.lld.practice.CarRental.model;

import com.lld.practice.CarRental.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Branch {
    private final String id;
    private final String city;

    public Branch(String id, String city) {
        this.id =  id;
        this.city = city;
    }

    private final Map<VehicleType, List<Vehicle>> vehicles = new HashMap<>();

    public List<Vehicle> getVehiclesByType(VehicleType type) {
        return vehicles.get(type);
    }

    public void addVehicle(Vehicle vehicle) {
        if(vehicle == null) return;

        VehicleType type = vehicle.getType();
        vehicles.computeIfAbsent(type, k -> new ArrayList<>()).add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        if(vehicle == null) return;

        List<Vehicle> vehicleList = vehicles.get(vehicle.getType());

        if(vehicleList != null){
            vehicleList.remove(vehicle);

            if(vehicleList.isEmpty()) {
                vehicles.remove(vehicle.getType());
            }
        }
    }
}
