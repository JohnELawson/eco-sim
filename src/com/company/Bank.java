package com.company;

/**
 * Created by john on 25/07/2017.
 */
public class Bank {

    private double capitalAssets;
    private double liquidAssets;
    private double interestRate;

    public Bank(double newLiquidAssets, double newInterestRate) {
        liquidAssets = newLiquidAssets;
        interestRate = newInterestRate;
    }

    public double getInterestRate(){
        return interestRate;
    }

    public double getliquidAssets(){
        return interestRate;
    }

    public String getDetails(){
        return "Liquid Assets: " + liquidAssets + ", Interest Rate: " + interestRate + ".";
    }
}
