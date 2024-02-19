package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** Mortage Calculator **/

public class MortageCalculator {

    private String customer;
    private double totalLoan;
    private double interestRate;
    private int years;
    private double monthlyPayment;

    public static void main(String[] args) {

        MortageCalculator mortageCalculator = new MortageCalculator();

        // read the input file
        mortageCalculator.readFile();

        // display the mortage plan
        mortageCalculator.displayMonthlyPlan();
    }

    private void readFile() {

        // change to path of the input file
        String pathname = "prospects.txt";

        try {
            Scanner fileScanner = new Scanner(new File(pathname));

            // the first line shows the order of the input, which can be skipped
            fileScanner.nextLine();

            while (fileScanner.hasNextLine()) {

                // track data validity
                boolean isValidData = true;

                String line = fileScanner.nextLine();
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                if (data.length == 4) {
                    customer = data[0];
                    totalLoan = Double.parseDouble(data[1]);
                    interestRate = Double.parseDouble(data[2]);
                    years = Integer.parseInt(data[3]);
                } else {
                    System.out.println("Invalid data format: " + line);
                    System.out.println("");
                    //set to false because data is not valid format
                    isValidData = false;
                }

                // calculate monthly payment and display the mortage plan only for valid data
                if (isValidData) {
                    monthlyPaymentCalc();
                    displayMonthlyPlan();
                    System.out.println("");
                }
            }

            // close scanner
            fileScanner.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void monthlyPaymentCalc() {
        double monthlyInterestRate = interestRate / 12;
        int totalPayments = years * 12;

        // calculate fixed monthly payment using the mortage formula E = U[b(1 + b)^p] / [(1 + b)^p - 1]
        monthlyPayment = Math.round((totalLoan * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -totalPayments)));
    }

    public void displayMonthlyPlan() {
        System.out.println("Mortage Plan:");
        System.out.println("Customer: " + customer);
        System.out.println("Loan Amount: " + totalLoan + "€");
        System.out.println("Yearly Interest Rate: " + interestRate + "%");
        System.out.println("Number of Years: " + years);
        System.out.println("Monthly Payment: " + monthlyPayment + "€");
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public double getTotalLoan() {
        return totalLoan;
    }

    public void setTotalLoan(double totalLoan) {
        this.totalLoan = totalLoan;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
}