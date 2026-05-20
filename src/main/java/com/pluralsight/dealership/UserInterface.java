package com.pluralsight.dealership;


import com.pluralsight.dealership.contracts.ContractFileManager;
import com.pluralsight.dealership.contracts.LeaseContract;
import com.pluralsight.dealership.contracts.SalesContract;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    Scanner input = new Scanner(System.in);
    private void init(){
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealership = dealershipFileManager.getDealership();
    }

    public void display(){

        init();
        while(true){
            System.out.println("Welcome to the Vehicle Menu");
            System.out.println("1. Find Vehicle within price range");
            System.out.println("2. Find Vehicle make/model");
            System.out.println("3. Find Vehicle year range");
            System.out.println("4. Find vehicle by color");
            System.out.println("5. Find vehicle mileage range");
            System.out.println("6. Find vehicle by type");
            System.out.println("7. List all vehicles");
            System.out.println("8. Add vehicle");
            System.out.println("9. Remove vehicle");
            System.out.println("10. Sale and Lease request");
            System.out.println("99. Exit");

            String choice = input.nextLine();
            switch(choice){
                case "1" -> processPriceRangeRequest();
                case "2" -> processMakeModelRequest();
                case "3" -> processYearRangeRequest();
                case "4" -> processColorRequest();
                case "5" -> processMileageRangeRequest();
                case "6" -> processVehicleTypeRequest();
                case "7" -> processAllVehiclesRequest();
                case "8" -> processAddVehicleRequest();
                case "9" -> processRemoveVehicleRequest();
                case "10" -> processSaleLeaseRequest();
                case "99" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }

        }
    }
    public void displayVehicles(ArrayList<Vehicle> vehicles){
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }
    }
    public void processPriceRangeRequest(){
        System.out.println("Please enter the Min price range for this vehicle");
        double minPrice = Double.parseDouble(input.nextLine());
        System.out.println("Please enter the Max price range for this vehicle");
        double maxPrice = Double.parseDouble(input.nextLine());
        displayVehicles(dealership.getVehiclesByPrice(minPrice, maxPrice));
    }
    public void processMakeModelRequest(){
        System.out.println("Please enter the Make for this vehicle");
        String vehicleMake = input.nextLine();
        System.out.println("Please enter the Model for this vehicle");
        String vehicleModel = input.nextLine();
        displayVehicles(dealership.getVehiclesByMakeModel(vehicleMake,vehicleModel));

    }
    public void processYearRangeRequest(){
        System.out.println("Please enter the Min Year for this vehicle");
        int minYear = Integer.parseInt(input.nextLine());
        System.out.println("Please enter the Max Year for this vehicle");
        int maxYear = Integer.parseInt(input.nextLine());
        displayVehicles(dealership.getVehiclesByYearRange(minYear,maxYear));
    }
    public void processColorRequest(){
        System.out.println("Please enter the Color for this vehicle");
        String vehicleColor = input.nextLine();
        displayVehicles(dealership.getVehiclesByColor(vehicleColor));
    }
    public void processMileageRangeRequest(){
        System.out.println("Please enter the Min Mileage for this vehicle");
        int minMileage = Integer.parseInt(input.nextLine());
        System.out.println("Please enter the Max Mileage for this vehicle");
        int maxMileage = Integer.parseInt(input.nextLine());
        displayVehicles(dealership.getVehiclesByMileageRange(minMileage,maxMileage));
    }
    public void processVehicleTypeRequest(){
        System.out.println("Please enter the Vehicle Type for this vehicle");
        String vehicleType = input.nextLine();
        displayVehicles(dealership.getVehiclesVehicleType(vehicleType));
    }
    public void processAllVehiclesRequest(){
        displayVehicles(dealership.getAllVehicles());
    }
    public void processAddVehicleRequest(){
        System.out.println("Please enter the Vin Number for this vehicle");
        int vin = Integer.parseInt(input.nextLine());
        System.out.println("Please enter the Year Number for this vehicle");
        int year = Integer.parseInt(input.nextLine());
        System.out.println("Please enter the Make for this vehicle");
        String make = input.nextLine();
        System.out.println("Please enter the Model for this vehicle");
        String model = input.nextLine();
        System.out.println("Please enter the Vehicle Type for this vehicle");
        String vehicleType = input.nextLine();
        System.out.println("Please enter the Color for this vehicle");
        String color = input.nextLine();
        System.out.println("Please enter the Mileage for this vehicle");
        int mileage = Integer.parseInt(input.nextLine());
        System.out.println("Please enter the Price for this vehicle");
        double price = Double.parseDouble(input.nextLine());

        dealership.addVehicle(new Vehicle(vin,year,make,model,vehicleType,color,mileage,price));
        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(dealership);
    }
    public void processRemoveVehicleRequest(){
        Vehicle lineInCsv = null;
        System.out.println("Please enter the Vin Number for this vehicle");
        int vin = Integer.parseInt(input.nextLine());
        for(Vehicle vehicle : dealership.getAllVehicles()){
            if (vin == vehicle.getVin()){
                lineInCsv = vehicle;
            }
        }
        if (lineInCsv != null){
            dealership.removeVehicle(lineInCsv);
            DealershipFileManager fileManager = new DealershipFileManager();
            fileManager.saveDealership(dealership);
        }else
            System.out.println("Couldn't find the vehicle");
    }
    public void processSaleLeaseRequest(){
        System.out.println("Please enter the Vin Number Number for this vehicle");
        int vin = Integer.parseInt(input.nextLine());
        Vehicle vehicle = dealership.findVehicleByVin(vin);
       if (vehicle == null){
           System.out.println("Vehicle not found");
           return;
       }
        System.out.println("Please enter the date");
       String date = input.nextLine();
        System.out.println("Enter your name");
        String name = input.nextLine();
        System.out.println("Please enter your email");
        String email = input.nextLine();
        System.out.println("Is this a sale or lease?");
        String userChoice = input.nextLine();
        if (userChoice.equalsIgnoreCase("sale")){
            System.out.println("Do you want to finance? yes or no");
            String financeChoice = input.nextLine();

            if (financeChoice.equalsIgnoreCase("yes")){
                boolean financeOption = financeChoice.equalsIgnoreCase("yes");
                SalesContract salesContract = new SalesContract(date,name,email,vehicle,financeOption);
                ContractFileManager fileManager = new ContractFileManager();
                fileManager.saveContract(salesContract);
                dealership.removeVehicle(vehicle);
                DealershipFileManager dealershipFileManager = new DealershipFileManager();
                dealershipFileManager.saveDealership(dealership);
            }
        }
        else if (userChoice.equalsIgnoreCase("lease")){
            if (LocalDate.now().getYear() - vehicle.getYear() > 3){
                System.out.println("Cannot save the lease for this vehicle");
                return;
            }
            LeaseContract leaseContract = new LeaseContract(date,name,email,vehicle);
            ContractFileManager fileManager = new ContractFileManager();
            fileManager.saveContract(leaseContract);
            dealership.removeVehicle(vehicle);
            DealershipFileManager dealershipFileManager = new DealershipFileManager();
            dealershipFileManager.saveDealership(dealership);

        }
        else {System.out.println("Invalid input");}


    }
}