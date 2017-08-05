package com.company;

/**
 * Created by john on 25/07/2017.
 */
public class Household {

    private double income;
    private double savings;
    private double percentSavings = 0.2;

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
        savings = savings + (income * percentSavings);
    }

    public boolean payMortgage(double amount) {
        if(amount >= savings){
            return false;
        } else {
            savings = savings - amount;
            return true;
        }
    }

    public String getDetails(){
        return "Income: " + income + ", Savings: " + savings + ".";
    }
}
