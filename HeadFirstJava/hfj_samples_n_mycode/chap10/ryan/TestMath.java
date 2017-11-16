package chap10.ryan;

class TestMath {
    public static void main(String[] args) {
        System.out.println(Math.ulp(3.542718));
        System.out.println(Math.ulp(0/0.0));
        System.out.println("\n" + Float.MIN_VALUE);
        System.out.println(Float.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
    }
}