# Financial Calculators

This application provides a set of financial calculators to help users with common financial computations such as mortgage payments, future value of investments, and present value calculations. It's designed to be simple, user-friendly, and informative.

## Features

- **Mortgage Calculator**: Calculate your monthly mortgage payments based on principal, interest rate, and term.
- **Future Value Calculator**: Find out the future value of a deposit after a certain number of years with a specified interest rate.
- **Present Value Calculator**: Determine how much you need to deposit now to achieve a desired payout in the future.

One interesting piece of code is the function to calculate the monthly mortgage payment. This is intriguing because it shows how a mathematical formula can be translated into a Java method. The formula requires careful conversion of percentages and terms into their decimal and monthly equivalents, respectively.

```java
private static double calculateMonthlyMortgagePayment(int principal, double annualInterestRate, int termInYears) {
    double monthlyRate = (annualInterestRate / 100) / 12.0;
    int termInMonths = termInYears * 12;
    return (principal * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -termInMonths));
}
```
