package chap12.ryan;

class MyOuter {
    private int x;
    MyInner inner = new MyInner();

    public void doStuff() {
        inner.go();
    }

    public class MyInner {
        void go() {
            x = 42;
        }
        void printX() {
            System.out.println(x);
        }
    } // close MyInner
}     // close MyOuter

public class TestInstInnerClass {
    public static void main(String[] args) {
        // !!!!!!!!
        // error: cannot find symbol MyInner
        // MyInner innerObj = new MyInner();
        
        // !!!!!!!!
        // error: an enclosing instance that contains MyOuter.MyInner is required
        // MyOuter.MyInner innerObj = new MyOuter.MyInner();

        // innerObj.go();
        // innerObj.printX();

        MyOuter outerObj = new MyOuter();
        MyOuter.MyInner innerObj = outerObj.new MyInner();
        innerObj.go();
        innerObj.printX();
    }
}
