package com.company;

/**
 * Created by john on 05/08/2017.
 */
public class Mortgage {

    private double totalAmount;
    private double interestRate;
    private int householdId;
    private int bankId;

    public Mortgage(double totalAmount, double interestRate, int bankId, int houseHoldId){
        this.totalAmount = totalAmount;
        this.interestRate = interestRate / 100; //50.0% -> 0.5
        this.bankId = bankId;
        this.householdId = houseHoldId;
    }

    public double payLoan(double payAmount){
        if(payAmount >= totalAmount){
            totalAmount = 0;
            return payAmount - totalAmount;

        } else {
            totalAmount -= payAmount;
            return 0;
        }
    }

    //interest
    public void incrementInterest(){
        totalAmount = totalAmount * interestRate;
    }

    public int getHouseholdId(){
        return householdId;
    }


}
