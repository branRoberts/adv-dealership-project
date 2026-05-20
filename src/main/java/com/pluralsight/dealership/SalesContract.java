package com.pluralsight.dealership;

public class SalesContract extends Contract{

    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee;
    private boolean financeOption;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicle, boolean financeOption) {
        super(date, customerName, customerEmail, vehicle);
        this.salesTaxAmount = getVehicle().getPrice() * 0.05;
        this.recordingFee = 100;
        if (getVehicle().getPrice() >= 10000){
            this.processingFee = 495;
        }else {
            this.processingFee = 295;
        }
        this.financeOption = financeOption;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanceOption() {
        return financeOption;
    }

    public void setFinanceOption(boolean financeOption) {
        this.financeOption = financeOption;
    }

    @Override
    public double getTotalPrice() {
        double totalPrice = 0;
        totalPrice += getVehicle().getPrice() + salesTaxAmount + recordingFee + processingFee;

        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        double rate;
        int month;

        if (!financeOption) {return 0;}
        if(getTotalPrice() >= 10000){
            rate = 0.0425 /12;
            month = 48;
        }else {
            rate = 0.0525 / 12;
            month = 24;
        }
        double monthlyPay = getTotalPrice() * (rate * Math.pow(1 + rate, month)) / (Math.pow(1 + rate, month) - 1);

        return monthlyPay;
    }
}
