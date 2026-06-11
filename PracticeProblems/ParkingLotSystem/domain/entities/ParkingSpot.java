package domain.entities;

import domain.enums.VehicleType;

public class ParkingSpot {
    private int parkingSpotId;
    private VehicleType vehicleType;
    private Vehicle parkedVehicle;

    public ParkingSpot(int parkingSpotId, VehicleType vehicleType){
        this.parkingSpotId = parkingSpotId;
        this.vehicleType = vehicleType;
    }

    public synchronized boolean park(Vehicle vehicle){
        if(!isFree() || vehicle.getVehicleType() != this.vehicleType) return false;

        parkedVehicle = vehicle;
        return true;
    }

    public synchronized boolean isFree(){
        return parkedVehicle == null;
    }

    public synchronized void removeVehicle(){
        parkedVehicle = null;
    }

    public int getParkingSpotId(){
        return parkingSpotId;
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }
}