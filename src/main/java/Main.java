/*
 *  UCF COP3330 Summer 2021 Assignment 26 Solution
 *  Copyright 2021 Brandon Barbour
 */

import java.util.Scanner;

public class PaymentCalculator {
    public static int calculateMonthsUntilPaidOff(double bal, double apr, double mpay) {
        int n = -(1 / 30) * java.lang.Math.log(1 + (bal / mpay) * (1 - java.lang.Math.pow((1 + apr), 30)) / java.lang.Math.log(1 + apr);
        return n;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.print("What is your balance?");
        Scanner input = new Scanner(System.in);
        double bal = input.nextDouble();
        System.out.print("What is the APR on the card (as a percent)?");
        double apr100 = input.nextDouble();
        double apr = apr100 / 100 / 365;
        System.out.print("What is the monthly payment you can make?");
        double mpay = input.nextDouble();

        int n = PaymentCalculator.calculateMonthsUntilPaidOff(bal, apr, mpay);
        System.out.printf("It will take you %d months to pay off this card.", n);

        //BigDecimal tax = new BigDecimal(Double.toString(amount * 0.055));
        //tax = tax.setScale(2, RoundingMode.UP);
        //total = amount + tax.doubleValue();
    }
}
