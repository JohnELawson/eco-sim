package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 25/07/2017.
 */
public class Bank {

    private double liquidAssets;
    private double interestRate;
    private List<Double> loans = new ArrayList<Double>(0);

    public Bank(double newLiquidAssets, double newInterestRate) {
        liquidAssets = newLiquidAssets;
        interestRate = newInterestRate;
    }

    public double payMortgage(int loanId, double payAmount){
        double loanValue = loans.get(loanId);
        if (loanValue > payAmount) {
            loans.set(loanId, loanValue - payAmount);
        } else {
            loans.remove(loanId);
        }
        return payAmount - loanValue;
    }

    public int getMortgage(double totalAmount, double deposit){
        loans.add(totalAmount - deposit);
        return loans.size() -1;
    }

    public void addLoanInterest(){
        for(int i=0; i<loans.size(); i++){
            loans.set(i, loans.get(i) * interestRate);
        }
    }

    public String getDetails(){
        return "Liquid Assets: " + liquidAssets + ", Interest Rate: " + interestRate + ".";
    }
}
