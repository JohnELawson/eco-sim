package com.company;

/**
 * Created by john on 25/07/2017.
 */
public class Household {

    private double income;
    private double savings;
    private double percentSavings = 50;

    public Household(double newIncome, double newSavings){
        income = newIncome;
        savings = newSavings;
    }

    public double getIncome() {
        return income;
    }

    public double getSavings(){
        return savings;
    }

    public void setSavings(double savings){
        this.savings = savings;
    }

    public void getPaid() {
        savings += income * (percentSavings / 100);
    }

    public String getDetails(){
        return "Income: " + income + ", Savings: " + savings + ".";
    }
}
