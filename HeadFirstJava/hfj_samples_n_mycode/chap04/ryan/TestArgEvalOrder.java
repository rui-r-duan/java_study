package chap04.ryan;

public class TestArgEvalOrder {
    // private int y = x + 1;      // illegal forward reference: x
    private int x = 9;          // evaluated before the constructor
    private int y = x + 1;

    private TestArgEvalOrder(int a, int b) { // PRIVATE constructor 
        System.out.println("   Constructing an object:");
        System.out.println("x = " + x + " y = " + y); // 9, 10
        x = a;
        y = b;
        System.out.println("x = " + x + " y = " + y);
    }

    public int incX() {
        return x = x + 1;
    }

    public int altY() {
        return y = x + y;
    }

    // STATIC method
    public static int multiplyXY(int x, int y) {
        System.out.println("multiplyXY:\nx = " + x + " y = " + y);
        return x * y;
    }

    public static void main(String[] args) {
        TestArgEvalOrder p = new TestArgEvalOrder(0, 1);
        TestArgEvalOrder q = new TestArgEvalOrder(0, 1);

        // The arguments passed to a method are evaluated from left to right.
        System.out.println(TestArgEvalOrder.multiplyXY(p.incX(),
                                                       p.altY())); // 2
        System.out.println(TestArgEvalOrder.multiplyXY(q.altY(),
                                                       q.incX())); // 1

        System.out.println("p: " + p);
        System.out.println("q: " + q);
    }
}