/*
 *  UCF COP3330 Summer 2021 Assignment 26 Solution
 *  Copyright 2021 Brandon Barbour
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("What is your balance? ");
        Scanner input = new Scanner(System.in);
        double bal = input.nextDouble();
        System.out.print("What is the APR on the card (as a percent)? ");
        double apr100 = input.nextDouble();
        double apr = apr100 / 100 / 365;
        System.out.print("What is the monthly payment you can make? ");
        double mpay = input.nextDouble();

        double n = PaymentCalculator.calculateMonthsUntilPaidOff(bal, apr, mpay);

        System.out.printf("It will take you %.0f months to pay off this card.", n);

    }
}

class PaymentCalculator {
    public static double calculateMonthsUntilPaidOff(double bal, double apr, double mpay) {
        double n = -(1.000000 / 30.000000) * (java.lang.Math.log(1 + (bal / mpay) * (1 - java.lang.Math.pow((1 + apr), 30)))) / java.lang.Math.log(1 + apr);
        if((n % 1) != 0) { //round up months
            n++;
        }
        return n;
    }
}
