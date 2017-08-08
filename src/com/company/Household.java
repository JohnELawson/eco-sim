package com.company;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by john on 25/07/2017.
 */
public class Household {

    private double income;
    private double savings;
    private double percentSavings = 0.08333; //income / 12
    NumberFormat formatter = new DecimalFormat("#0.00");

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

    public void getPaid(double amount) {
        savings = savings + amount;
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
        return "Income: " + formatter.format(income) + ", Savings: " + formatter.format(savings) + ".";
    }

    public String getCSV(){
        return formatter.format(income) + ", " + formatter.format(savings) + ", ";
    }
}
