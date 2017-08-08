package com.company;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by john on 25/07/2017.
 */
public class Bank {

    private double capitalAssets;
    private double liquidAssets;
    private double interestRate;
    private NumberFormat formatter = new DecimalFormat("#0.00");

    public Bank(double newLiquidAssets, double newInterestRate) {
        liquidAssets = newLiquidAssets;
        interestRate = newInterestRate;
    }

    public double getInterestRate(){
        return interestRate;
    }

    public double getliquidAssets(){
        return liquidAssets;
    }

    public void recievePayment(double amount){
        liquidAssets = liquidAssets + amount;
    }

    public void makePayment(double amount){
        liquidAssets = liquidAssets - amount;
    }

    public String getDetails(){
        return "Liquid Assets: " + formatter.format(liquidAssets) + ", Interest Rate: " + formatter.format(interestRate) + ".";
    }

    public String getCSV(){
        return formatter.format(liquidAssets) + ", "; // + formatter.format(interestRate) + ", ";
    }
}
