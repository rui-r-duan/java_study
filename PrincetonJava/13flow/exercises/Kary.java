/******************************************************************************
 *  Compilation:  javac Kary.java
 *  Execution:    java Binary n k
 *  
 *  Prints out n in base k.
 *  n = d_m * k^n + d_(m-1) * k^(m-1) + ... + d_2 * k^2 + d_1 * k + d_0
 * 
 *  % java Binary 5 5
 *  101
 *
 *  % java Binary 106
 *  1101010
 *
 *  % java Binary 0
 *  0
 * 
 *  % java Binary 16
 *  10000
 *
 *  Limitations
 *  -----------
 *  Does not handle negative integers.
 *
 ******************************************************************************/

public class Kary { 
    public static void main(String[] args) { 

        // read in the command-line argument
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        
        if (k > 36) {
            // because the digit cannot be simply displayed by [0-9] or [a-z]
            throw new RuntimeException("This program cannot handle K > 36");
        }

        // set power to the largest power of k that is <= n
        int power = 1;
        while (power <= n/k) {
            power *= k;
        }
  
        // check for presence of powers of k in n, from largest to smallest
        while (power > 0) {

            int digit = n / power; // it could be 0 if n < power
            
            if (digit >= 0 && digit < 10) {
                System.out.print(digit);
            }
            else if (digit >= 10 && digit <= 10 + 25) {
                char digitChar = (char)('a' + (digit - 10));
                System.out.print(digitChar);
            }
            else {
                // digit < 0 cannot happen for positive n and k
                // digit > 35 is prevented by the previous (k >= 36) checking
                throw new RuntimeException("Bad logic! It shouldn't run to this place!");
            }
            
            n -= power * digit;

            // next smallest power of k
            power /= k;
        }

        System.out.println();
    }
}