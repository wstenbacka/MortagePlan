package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import main.MortageCalculator;

public class MortageCalculatorTest {

    @Test
    public void testMonthlyPaymentCalc() {
        MortageCalculator mortageCalculator = new MortageCalculator();

        // Set test data
        mortageCalculator.setTotalLoan(1000);
        mortageCalculator.setInterestRate(5);
        mortageCalculator.setYears(2);

        // Call the method to calculate monthly payment
        mortageCalculator.monthlyPaymentCalc();

        // Validate the result with an expected value
        assertEquals(417.0, mortageCalculator.getMonthlyPayment());
    }

    @Test
    public void testDisplayMonthlyPlan() {
        MortageCalculator mortageCalculator = new MortageCalculator();

        // Set test data
        mortageCalculator.setCustomer("Jim Smith");
        mortageCalculator.setTotalLoan(2000);
        mortageCalculator.setInterestRate(7.5);
        mortageCalculator.setYears(3);

        // Call the method to calculate monthly payment
        mortageCalculator.monthlyPaymentCalc();

        // Validate the result with an expected value
        //assertEquals();
    }
}