package com.company;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by john on 05/08/2017.
 */
public class Mortgage {

    private double totalAmount;
    private double amountLeft;
    private double payBackAmount;
    private double interestRate;
    private double depositAmount;
    private int householdId;
    private int bankId;

    //mortgage configs
    private static double mortgagePayMonths = 360; //30y * 12m

    public Mortgage(int bankId, int houseHoldId, double totalAmount, double interestRate, double deposit){
        this.totalAmount = totalAmount;
        this.amountLeft = totalAmount;
        this.interestRate = interestRate;
        this.depositAmount = deposit;
        this.bankId = bankId;
        this.householdId = houseHoldId;
        this.payBackAmount =  totalAmount / mortgagePayMonths;
    }

    public double payMortgage(){
        if(payBackAmount >= amountLeft){
            amountLeft = 0;
            return payBackAmount - amountLeft;
        } else {
            amountLeft -= payBackAmount;
            return 0;
        }
    }

    public void incrementInterest(){
        amountLeft = amountLeft + (amountLeft * interestRate);
        payBackAmount = totalAmount / mortgagePayMonths;
    }

    public int getHouseholdId(){
        return householdId;
    }

    public double getAmountLeft() {
        return amountLeft;
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

    public String getCSV(){
        NumberFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(bankId) + ", " + formatter.format(householdId) + ", " + formatter.format(totalAmount) + ", " + formatter.format(amountLeft) + ", " + formatter.format(interestRate) + ", " + formatter.format(payBackAmount) + ", ";
    }
}
