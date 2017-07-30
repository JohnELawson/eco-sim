package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Bank> banks = new ArrayList<Bank>(0);
    private static List<Household> households = new ArrayList<Household>(0);

    private static int noOfHouseholds = 1;
    private static int noOfBanks = 1;
    private static int noOfMonths = 10;

    public static void main(String[] args) {

        //init
        generateBanks();
        generateHouseholds();

        //run sim
        monthlyLoop();
    }

    private static void monthlyLoop(){
        for(int i=0; i<noOfMonths; i++){
            print("\n\nMonth: " + i + " of " + noOfMonths + ".");

            //monthly increments
            incrementInterest();
            incrementIncome();

            //attempt get loans/ pay loans
            getMortgages();

            //print monthly status
            getBankDetails();
            getHouseholdDetails();
        }
    }

    private static void generateBanks(){
        for(int i=0; i<noOfBanks; i++){
            //random number gen for liquidAssets, interest rate,
            double liquidAssets = 1000000.0;
            double interestRate = 3.0;
            banks.add(new Bank(liquidAssets, interestRate));
            int id =  banks.size() -1;
            print("Bank added: " + id + " - Liquid Assets: " + liquidAssets + ", Intrest Rate: " + interestRate);
        }
    }

    private static void generateHouseholds(){
        for(int i=0; i<noOfHouseholds; i++){
            //random number gen for income, savings..
            double income = 30000;
            double savings = 10000;
            households.add(new Household(income, savings));
            int id = households.size() -1;
            print("Household added: " + id + " - Income: " + income + ", Savings: " + savings);
        }
    }

    private static void getMortgages(){
//        for(int i=0; i<noOfHouseholds; i++){
//            //add random number of mortgage cost
//            double totalAmount = 250000;
//            double deposit = 25000;
//            banks.get(i).getMortgage(totalAmount, deposit);
//            print("Household got mortgage: " + i + " - Total Amount: " + totalAmount + ", Deposit: " + deposit);
//        }
    }

    private static void incrementInterest(){
        for(int i = 0; i< banks.size(); i++){
            banks.get(i).addLoanInterest();
        }
    }

    private static void incrementIncome(){
        for(int i = 0; i< households.size(); i++){
            households.get(i).getIncome();
        }
    }

    private static void getBankDetails(){
        for(int i = 0; i< banks.size(); i++){
            print(banks.get(i).getDetails());
        }
    }

    private static void getHouseholdDetails(){
        for(int i = 0; i< households.size(); i++){
            print(households.get(i).getDetails());
        }
    }

    private static void print(String line) {
        System.out.println(line);
    }
}
