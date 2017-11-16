// Instance variables are not overridden because they don't need to be.
package chap07.ryan;

class SuperClass {
    int size;
    SuperClass() {
        System.out.println("SuperClass ctor.");
        size = 5;
    }
    public int getSize() {
        return size;
    }
}

class SubClassOne extends SuperClass {
    SubClassOne() {
        // We don't need to call super() explicitely.
        size = 1;
    }
}

class SubClassTwo extends SuperClass {
    int size = 9999;
    SubClassTwo() {
        System.out.println("Inside ctor of SubClassTwo: size = " + size);
    }
}

class SubClassThree extends SuperClass {
    int size = 3333;
    SubClassThree() {
        System.out.println("Inside ctor of SubClassThree: size = " + size);
    }
    public int getSize() {
        return super.getSize();
    }
}
        
class SubClassFour extends SuperClass {
    int size;
    SubClassFour() {
        System.out.println("Inside ctor of SubClassFour: size = " + size);
    }
    public int getSuperSize() {
        return super.size;
    }
    public int getSize() {
        return size;
    }
}

class TestOverrideField extends SuperClass {
    public static void main(String[] args) {
        System.out.println("Now a is SubClassFour:");
        SubClassFour a = new SubClassFour();
        System.out.println("a.getSize() = " + a.getSize());
        System.out.println("((SuperClass)a).getSize() = " + ((SuperClass)a).getSize());
        System.out.println("a.getSuperSize() = " + a.getSuperSize());

        System.out.println("\nNow b is SubClassOne:");
        SubClassOne b = new SubClassOne();
        System.out.println("b.getSize() = " + b.getSize());
        System.out.println("((SuperClass)b).getSize() = " + ((SuperClass)b).getSize());

        System.out.println("\nNow c is SubClassTwo:");
        SubClassTwo c = new SubClassTwo();
        System.out.println("c.getSize() = " + c.getSize());
        System.out.println("((SuperClass)c).getSize() = " + ((SuperClass)c).getSize());

        System.out.println("\nNow d is SubClassThree:");
        SubClassThree d = new SubClassThree();
        System.out.println("d.getSize() = " + d.getSize());
        System.out.println("((SuperClass)d).getSize() = " + ((SuperClass)d).getSize());
    }
}