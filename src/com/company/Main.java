package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    //lists of simulation assets
    private static List<Bank> banks = new ArrayList<Bank>(0);
    private static List<Household> households = new ArrayList<Household>(0);
    private static List<Mortgage> mortgages = new ArrayList<Mortgage>(0);

    //loop config
    private static int noOfMonths = 10;

    //simulation assets configs
    private static int noOfHouseholds = 10;
    private static int noOfBanks = 1;

    //household configs
    private static double minWage = 20000.00;
    private static double maxWage = 250000.00;
    private static double housePriceMultiplier = 10;
    private static double houseSavingsMultiplier = 0.1;
    private static double houseDepositMultiplier = 0.08;



    public static void main(String[] args) {

        //init
        generateBanks();
        generateHouseholds();

        //run sim
        monthlyLoop();
    }

    private static void monthlyLoop(){
        for(int i=0; i<noOfMonths; i++){
            print("\n\nMonth: " + (i + 1) + " of " + noOfMonths + ".\n");

            //monthly increments
            incrementInterest();
            getPaid();

            //attempt get loans/ pay loans
            getMortgages();

            //print monthly status
            print("");
            getBankDetails();
            getHouseholdDetails();
        }
    }

    private static void generateBanks(){
        //probably read data from a file instead of random

        for(int i=0; i<noOfBanks; i++){
            //random number gen for liquidAssets, interest rate,
            double liquidAssets = 1000000.0;
            double interestRate = 3.0;
            banks.add(new Bank(liquidAssets, interestRate));
            int id =  banks.size() -1;
            print("Bank added: " + id + " - Liquid Assets: " + liquidAssets + ", Interest Rate: " + interestRate);
        }
    }

    private static void generateHouseholds(){
        for(int i=0; i<noOfHouseholds; i++){

            //gen household income and savings
            double income = minWage + (int)(Math.random() * maxWage);
            double savings = income * houseSavingsMultiplier;

            households.add(new Household(income, savings));

            int id = households.size() -1;
            print("Household added: " + id + " - Income: " + income + ", Savings: " + savings);
        }
    }

    private static void getMortgages(){
        for(int i=0; i<noOfHouseholds; i++){

            if(hasMortgage(i) == -1) {
                //if the household does not have a mortgage

                double houseCost = households.get(i).getIncome() * housePriceMultiplier;
                double householdSavings = households.get(i).getSavings();
                double houseDeposit = houseDepositMultiplier * houseCost;

                //make this random or something later
                int bankId = 0;

                if (householdSavings > houseDeposit) {
                    //get mortgage
                    mortgages.add(new Mortgage(houseCost, houseDeposit,bankId, i));

                    //pay deposit
                    households.get(i).setSavings(householdSavings - houseDeposit);

                    print("Household: " + i + " got mortgage - House Cost: " + houseCost + ", Deposit: " + houseDeposit + ", Bank Id: " + bankId + ", with savings of " + householdSavings);
                } else {
                    //cant afford house yet
                    print("Household: " + i + " cannot afford a mortgage of " + houseCost + ", with savings of " + householdSavings);
                }

            } else {
                Mortgage mortgage = mortgages.get(hasMortgage(i));
                print("Household: " + i + " already has a mortgage - Cost: " + mortgage.getTotalAmount() + ", Interest: " + mortgage.getInterestRate() + ", BankId: " + mortgage.getBankId());
            }
        }
    }

    private static void payMortgages(){
        for(int i = 0; i< mortgages.size(); i++){
            int householdId = hasMortgage(i);
            if(householdId != -1){
                Mortgage mortgage = mortgages.get(i);
                double payBackAmount = mortgage.getPayBackAmount();

                //make household pay
                households.get(householdId).payMortgage(payBackAmount);
                //update mortgage value
                mortgage.payLoan(payBackAmount);
                //update bank capital
                //###
            }
        }
    }

    private static int hasMortgage(int householdId) {
        for(int i = 0; i< mortgages.size(); i++){
            if(mortgages.get(i).getHouseholdId() == householdId){
                return i;
            }
        }
        return -1;
    }

    private static void incrementInterest(){
        for(int i = 0; i< mortgages.size(); i++){
           mortgages.get(i).incrementInterest();
        }
    }

    private static void getPaid(){
        for(int i = 0; i< households.size(); i++){
            households.get(i).getPaid();
        }
    }

    private static void getBankDetails(){
        for(int i = 0; i< banks.size(); i++){
            print("Bank:      " + i + ", " + banks.get(i).getDetails());
        }
    }

    private static void getHouseholdDetails(){
        for(int i = 0; i< households.size(); i++){
            print("Household: " + i + ", " + households.get(i).getDetails());
        }
    }

    private static void print(String line) {
        System.out.println(line);
    }
}
