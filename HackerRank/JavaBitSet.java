import java.io.*;
import java.util.*;

public class JavaBitSet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        BitSet[] b = new BitSet[2];
        b[0] = new BitSet(n);
        b[1] = new BitSet(n);

        String op;
        int operand1;
        int operand2;
        for (int i = 0; i < m; i++) {
            op = sc.next();
            operand1 = sc.nextInt();
            operand2 = sc.nextInt();

            if (op.equals("AND")) {
                b[operand1 - 1].and(b[operand2 - 1]);
            }
            else if (op.equals("OR")) {
                b[operand1 - 1].or(b[operand2 - 1]);
            }
            else if (op.equals("XOR")) {
                b[operand1 - 1].xor(b[operand2 - 1]);
            }
            else if (op.equals("FLIP")) {
                b[operand1 - 1].flip(operand2);
            }
            else if (op.equals("SET")) {
                b[operand1 - 1].set(operand2);
            }

            System.out.println(b[0].cardinality() + " " + b[1].cardinality());
        }
        sc.close();
    }
}
