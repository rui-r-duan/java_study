/******************************************************************************
 *  Compilation:  javac ExprMax.java
 *  Execution:    java ExprMax
 *  
 * Barring overflow, give a code fragment to compute the maximum of two
 * integers a and b without using Math.max() or if.
 * 
 *  % java ExprMax 3 5
 *  5
 *
 *
 ******************************************************************************/

public class ExprMax {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int max = (a + b + Math.abs(a - b)) / 2;
        System.out.println(max);
    }
}
