// We can have more than one static initializer in one class.
package chap10.ryan;

public class Bar {
    public static final double BAR_SIGN;
    public static final double PI;
    static {
        BAR_SIGN = (double) Math.random();
    }

    public static void main(String[] args) {
        System.out.println("BAR_SIGN = " + BAR_SIGN);
        System.out.println("PI = " + PI);
    }

    static {
        PI = (double) Math.PI;
    }
}