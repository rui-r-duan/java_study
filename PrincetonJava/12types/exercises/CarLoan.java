/******************************************************************************
 *  Compilation:  javac CarLoan.java
 *  Execution:    java CarLoan principal years rate
 *
 *  Calculate the monthly payments if you take out a $principal loan for
 *  the specified number of years at the specified interest rate,
 *  where interested is compounded monthly.
 *
 *                  principal * rate
 *     payment =  -------------------      where n = 12 * years, r = rate / 12 / 100
 *                1  - (1 + r)^(-n)
 *
 *
 *  % java CarLoan 20000 5 6
 *  Monthly payments = 386.6560305885655
 *  Total interest   = 3199.361835313932
 *
 *
 *  Bugs - fixed
 *  ----
 *  Does not work if rate = 0% interest. Easy to fix if you know about
 *  if-else statements.
 *
 ******************************************************************************/

public class CarLoan {
    public static void main(String[] args) {
        double principal = Double.parseDouble(args[0]);
        double years = Double.parseDouble(args[1]);
        double rate = Double.parseDouble(args[2]);

        if (rate - 0 < 0.000001) {
            System.out.println("Bad argument: interest rate cannot be zero.");
            return;
        }
        
        double r = rate / 12 / 100;    // monthly interest rate
        double n = 12 * years;      // number of months

        double payment  = (principal * r) / (1 - Math.pow(1+r, -n));
        double interest = payment * n - principal;

        System.out.println("Monthly payments = " + payment);
        System.out.println("Total interest   = " + interest);
    }

}