package chap09.ryan;

class A {
    protected int state = 0;
    public A() {
        System.out.println("\nDefault A()");
    }
    public A(int s) {
        System.out.println("\nA ctor");
        System.out.println("state = " + state);
        state = s;
        System.out.println("state = " + state);
    }
}

class B extends A {
    private double length = 0.0;
    public B() {
        // It doesn't need to call super() here, JVM calls A() automatically.
        System.out.println("Default B()");
    }
    public B(int s, double len) {
        super(s);       // call to super must be first statement in constructor
        // We can also omit 'super(s)', the compiler will call super() for us.
        System.out.println("B ctor");
        length = len;
        System.out.println("state = " + state);
    }
}

class TestCtor {
    public static void main(String[] args) {
        A a = new A(20);
        A b = new B(20, 58.295);
        A aa = new A();
        B bb = new B();
    }
}