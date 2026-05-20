package com.pluralsight.dealership.contracts;

import com.pluralsight.dealership.Vehicle;

public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicle) {
        super(date, customerName, customerEmail, vehicle);
        this.expectedEndingValue = vehicle.getPrice() / 2;
        this.leaseFee = vehicle.getPrice() * 0.07;

    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {
        double totalPrice = 0;
        totalPrice = getVehicle().getPrice() + getLeaseFee();
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        double rate = 0.04 / 12;
        int month = 36;
        double monthlyPay = getTotalPrice() * (rate * Math.pow(1 + rate, month)) / (Math.pow(1 + rate, month) - 1);
        return monthlyPay;
    }
}
