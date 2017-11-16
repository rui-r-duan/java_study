package chap10.ryan;

public class Foo5 {
    static final int x = 12;
    public void go(final int x) {
        System.out.println(x);
        // x = 5;  final parameter x may not be assigned
    }
    public int getX() {
        return x;
    }

    public static void main(String[] args) {
        new Foo5().go(new Foo5().getX());
    }
}