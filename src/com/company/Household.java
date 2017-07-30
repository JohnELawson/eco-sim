package com.company;

/**
 * Created by john on 25/07/2017.
 */
public class Household {

    private double income;
    private double savings;
    private int loanId = -1;
    private double percentSavings = 50;

    public Household(double newIncome, double newSavings){
        income = newIncome;
        savings = newSavings;
    }

    public int getLoanId(){
        return loanId;
    }

    public void getIncome(){
        savings += income * (percentSavings / 100);
    }

    public String getDetails(){
        return "Income: " + income + ", Savings: " + savings + ".";
    }
}
