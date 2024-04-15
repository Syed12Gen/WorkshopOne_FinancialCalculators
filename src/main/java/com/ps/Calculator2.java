package com.ps;

import java.util.Scanner;

public class Calculator2 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Future Value Calculator");
        futureValueCalculator();
    }

    private static void futureValueCalculator() {
        // Accept the deposit amount from the user
        System.out.print("Enter the deposit amount: ");
        double depositAmount = scanner.nextDouble();

        // Accept the annual interest rate from the user and convert it to a daily rate
        System.out.print("Enter the annual interest rate (in percent): ");
        double annualInterestRate = scanner.nextDouble();
        double dailyInterestRate = annualInterestRate / 100 / 365;

        // Accept the number of years from the user and convert to total days
        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();
        int totalDays = years * 365;

        // Calculate the future value using the formula for daily compounding interest
        double futureValue = depositAmount * Math.pow(1 + dailyInterestRate, totalDays);

        // Calculate the total interest earned
        double totalInterestEarned = futureValue - depositAmount;

        // Display the future value and total interest earned
        System.out.printf("The future value of the CD is: $%.2f\n", futureValue);
        System.out.printf("The total interest earned is: $%.2f\n", totalInterestEarned);
    }
}

