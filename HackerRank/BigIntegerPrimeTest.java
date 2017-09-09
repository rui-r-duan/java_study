// https://www.hackerrank.com/challenges/java-primality-testmal
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger n = in.nextBigInteger();
        in.close();
        // Write your code here.
        System.out.println(n.isProbablePrime(10));
    }
}
