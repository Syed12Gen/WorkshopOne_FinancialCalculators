package com.ps; //Package Declaration

import java.util.Scanner;

public class Main { //this class can be accessed from other classes
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        // Prompt the user for the principal loan amount
        System.out.print("Enter the loan amount you want to apply for: ");
        double principalAmount = inputScanner.nextDouble();

        // Prompt the user for the annual interest rate (as a percentage)
        System.out.print("Enter the annual interest rate: ");
        double annualInterestRate = inputScanner.nextDouble();
        double monthlyInterestRate = (annualInterestRate / 100) / 12;

        // Prompt the user to choose between entering the loan term in years or months
        System.out.print("Enter 'Y' to input the loan term in years, or 'M' to input in months: ");
        char termInputType = inputScanner.next().charAt(0);
        int totalNumberOfPayments;

        if (termInputType == 'Y' || termInputType == 'y') {
            System.out.print("Enter the loan term in years: ");
            int loanTermInYears = inputScanner.nextInt();
            totalNumberOfPayments = loanTermInYears * 12;
        } else if (termInputType == 'M' || termInputType == 'm') {
            System.out.print("Enter the loan term in months: ");
            totalNumberOfPayments = inputScanner.nextInt();
        } else {
            System.out.println("Invalid input. Please enter 'Y' for years or 'M' for months.");
            inputScanner.close();
            return;
        }

        // Calculate the monthly mortgage payment
        double monthlyMortgagePayment = calculateMonthlyMortgagePayment(principalAmount, monthlyInterestRate, totalNumberOfPayments);

        // Calculate the total interest paid over the life of the loan
        double totalInterestPaid = (monthlyMortgagePayment * totalNumberOfPayments) - principalAmount;

        // Display the results
        System.out.printf("Monthly Mortgage Payment: $%.2f%n", monthlyMortgagePayment);
        System.out.printf("Total Interest Paid Over the Life of the Loan: $%.2f%n", totalInterestPaid);

        // Close the Scanner object
        inputScanner.close();
    }

    public static double calculateMonthlyMortgagePayment(double principalAmount, double monthlyInterestRate, int totalNumberOfPayments) {
        return (principalAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -totalNumberOfPayments));
    }
}
