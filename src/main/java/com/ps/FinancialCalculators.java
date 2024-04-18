package com.ps; //Package Declaration

import java.util.Scanner;

public class FinancialCalculators {

    private static double calculateMonthlyMortgagePayment(int principal, double annualInterestRate, int termInYears) {
        // Convert annual interest rate to monthly and decimal form
        double monthlyRate = (annualInterestRate / 100) / 12.0;
        // Convert term in years to months
        int termInMonths = termInYears * 12;
        // Calculate monthly payment
        return (principal * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -termInMonths));
    }

    private static double calculateFutureValue(double deposit, double annualInterestRate, int years) {
        // Assuming daily compounding
        int compoundingFrequency = 365;
        // Convert annual interest rate to daily and decimal form
        double dailyRate = (annualInterestRate / 100) / compoundingFrequency;
        // Calculate future value
        return deposit * Math.pow(1 + dailyRate, years * compoundingFrequency);
    }

    private static double calculatePresentValue(double monthlyPayout, double annualInterestRate, int years) {
        // Convert annual interest rate to monthly and decimal form
        double monthlyRate = (annualInterestRate / 100) / 12.0;
        // Total number of payments
        int payments = years * 12;
        // Calculate present value
        return monthlyPayout * ((1 - Math.pow(1 + monthlyRate, -payments)) / monthlyRate);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Financial Calculators");
        System.out.println("=====================");
        System.out.println("1. Mortgage Calculator");
        System.out.println("2. Future Value Calculator");
        System.out.println("3. Present Value Calculator");
        System.out.print("Choose a calculator (1-3): ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1: // Mortgage Calculator
                System.out.print("Enter the principal amount: ");
                int principal = scanner.nextInt();
                System.out.print("Enter the annual interest rate (percentage): ");
                double annualInterestRate = scanner.nextDouble();
                System.out.print("Enter the term (years): ");
                int termInYears = scanner.nextInt();
                double monthlyPayment = calculateMonthlyMortgagePayment(principal, annualInterestRate, termInYears);
                System.out.printf("Monthly payment: $%.2f\n", monthlyPayment);
                break;
            case 2: // Future Value Calculator
                System.out.print("Enter the deposit amount: ");
                double deposit = scanner.nextDouble();
                System.out.print("Enter the annual interest rate (percentage): ");
                annualInterestRate = scanner.nextDouble();
                System.out.print("Enter the number of years: ");
                int years = scanner.nextInt();
                double futureValue = calculateFutureValue(deposit, annualInterestRate, years);
                System.out.printf("Future value: $%.2f\n", futureValue);
                break;
            case 3: // Present Value Calculator
                System.out.print("Enter the monthly payout amount: ");
                double monthlyPayout = scanner.nextDouble();
                System.out.print("Enter the annual interest rate (percentage): ");
                annualInterestRate = scanner.nextDouble();
                System.out.print("Enter the number of years to payout: ");
                years = scanner.nextInt();
                double presentValue = calculatePresentValue(monthlyPayout, annualInterestRate, years);
                System.out.printf("Present value: $%.2f\n", presentValue);
                break;
            default:
                System.out.println("Invalid choice. Please select a number between 1 and 3.");
                break;
        }

        scanner.close();
    }
}


