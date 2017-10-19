/******************************************************************************
 *  Compilation:  javac PoisonParen.java
 *  Execution:    java PoisonParen
 *  
 *  29. Poison parentheses. Find a legal Java expression that leads to a
 *  compile-time error when you add parentheses around a subexpression to to
 *  document the order of evaluation that would take place in their absence.
 * 
 * Solution: The literal value 2147483648 (2^31) is permitted only as an
 * operand of the unary minus operator, i.e., -2147483648. Enclosing it in
 * parentheses, i.e., -(2147483648), leads to a compile-time error. Similar
 * ideas with the literal value 9223372036854775808L (2^63).
 *
 *  % java PoisonParen
 *  Error: The literal 2147483648 of type int is out of range
 *  Error: The literal 9223372036854775808L of type long is out of range
 *
 *
 ******************************************************************************/

public class PoisonParen {
    public static void main(String[] args) {
        int a = -(3);
        int b = -2147483648; // good
        int c = -(2147483648); // bad
        long d = -(9223372036854775808L); // bad
    }
}
