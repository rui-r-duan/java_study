package chap10.ryan;

public class Foo6 {
    int x = 12;

    public static void go(final int x) {
        // x = 5;  final parameter x may not be assigned
        System.out.println(x);
    }

    public int getX() {
        return x;
    }

    public static void main(String[] args) {
        Foo6.go(new Foo6().getX());
    }
}