package chap09.ryan;

// protected is not allowed here
// private is not allowed here
    interface A {
    void saySth();
    int returnSth();
}

class B implements A {
    public void saySth() {
        System.out.println("I implemented saySth().");
    }

    public int returnSth() {
        return 5;
    }
}

class PrivateInterface {
    public static void main(String[] args) {
        new B().saySth();
        System.out.println(new B().returnSth());
    }
}