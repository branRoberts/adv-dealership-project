package com.pluralsight.dealership.contracts;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ContractFileManager {
    public void saveContract(Contract contract) {
        try {
            FileWriter fw = new FileWriter("contracts.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            if (contract instanceof SalesContract) {
                SalesContract sc = (SalesContract) contract;
                bw.write("SALE|" + sc.getDate() + "|" + sc.getCustomerName() + "|" + sc.getCustomerEmail() + "|" + sc.getVehicleSold().getVin() + "|" + sc.getVehicleSold().getYear() +
                        "|" + sc.getVehicleSold().getMake() + "|" + sc.getVehicleSold().getModel() + "|" + sc.getVehicleSold().getVehicleType() + "|" + sc.getVehicleSold().getColor()
                        + "|" + sc.getVehicleSold().getOdometer() + "|" + sc.getVehicleSold().getPrice() +
                        "|" + sc.getSalesTaxAmount() + "|" + sc.getRecordingFee() + "|" + sc.getProcessingFee() + "|"
                        + sc.getTotalPrice() + "|" + sc.isFinanceOption() + "|" + sc.getMonthlyPayment() + "\n");

            } else if (contract instanceof LeaseContract) {
                LeaseContract lc = (LeaseContract) contract;
                bw.write("LEASE|" + lc.getDate() + "|" + lc.getCustomerName() + "|" + lc.getCustomerEmail() + "|" + lc.getVehicleSold().getVin()
                        + "|" + lc.getVehicleSold().getYear() + "|" + lc.getVehicleSold().getMake() + "|" + lc.getVehicleSold().getModel()
                        + "|" + lc.getVehicleSold().getVehicleType() + "|" + lc.getVehicleSold().getColor() + "|" + lc.getVehicleSold() .getOdometer()
                        + "|" + lc.getVehicleSold() .getPrice()+ "|" + lc.getExpectedEndingValue() + "|" + lc.getLeaseFee() + "|" + lc.getTotalPrice()
                        + "|" + lc.getMonthlyPayment() + "\n");
            }
            bw.close();

        }catch (Exception e){
            System.out.println("Error while saving contract.csv");
        }
    }
}
