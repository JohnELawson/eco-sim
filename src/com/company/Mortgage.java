package com.company;

/**
 * Created by john on 05/08/2017.
 */
public class Mortgage {

    private double totalAmount;
    private double payBackAmount;
    private double interestRate;
    private int householdId;
    private int bankId;

    //mortgage configs
    private static double mortgagePayMonths = 360; //30y * 12m

    public Mortgage(double totalAmount, double interestRate, int bankId, int houseHoldId){
        this.totalAmount = totalAmount;
        this.interestRate = interestRate;
        this.bankId = bankId;
        this.householdId = houseHoldId;
        this.payBackAmount =  totalAmount / mortgagePayMonths;
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

    public double getTotalAmount() {
        return totalAmount;
    }

    public int getBankId(){
        return bankId;
    }

    public double getInterestRate(){
        return interestRate;
    }

    public double getPayBackAmount(){
        return payBackAmount;
    }
}
