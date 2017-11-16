package chap08.ryan;

abstract class Animal {
    int hunger;
    public abstract void eat();
}

class Hippo extends Animal {
    void makeNoise() {
        System.out.println("mooo");
    }
    public void eat() {
        System.out.println("Hippo is eating.");
    }
}

public class TestObject {
    public static void main(String[] args) {
        Animal a = new Hippo();
        System.out.println("a.hashCode() = " + Integer.toHexString(a.hashCode()));
        Class c = a.getClass();
        System.out.println("a.getClass() = " + c);
        System.out.println("a.getClass().getName() = " + c.getName());
        System.out.println("a.toString() = " + a.toString());
        System.out.println(a);

        a.eat();
    }
}