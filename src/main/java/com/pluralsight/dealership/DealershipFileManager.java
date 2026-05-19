package com.pluralsight.dealership;

import java.io.*;

public class DealershipFileManager {
    String fileName = "dealership.csv";
    public Dealership getDealership() {
        String line;
        Dealership dealership = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String firstLine = reader.readLine();
            String dealershipData[] = firstLine.split("\\|");
            dealership = new Dealership(dealershipData[0], dealershipData[1], dealershipData[2]);

            while ((line = reader.readLine()) != null) {
                String[] values = line.split("\\|");
                int vin = Integer.parseInt(values[0]);
                int year = Integer.parseInt(values[1]);
                String make = values[2];
                String model = values[3];
                String vehicleType = values[4];
                String color = values[5];
                int odometer = Integer.parseInt(values[6]);
                double price = Double.parseDouble(values[7]);
                dealership.addVehicle(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));


            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error reading dealership.csv");
        }
        return dealership;
    }
    public void saveDealership(Dealership dealership) {
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone() + "\n");
            for (Vehicle vehicle : dealership.getAllVehicles() ) {
                bw.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake()+ "|" + vehicle.getModel()+ "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice() + "\n");
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}