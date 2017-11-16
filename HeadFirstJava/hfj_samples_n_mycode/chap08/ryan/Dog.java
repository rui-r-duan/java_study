package chap08.ryan;

abstract class Animal { }   // different from class Animal from TestObject.java

abstract class Canine extends Animal {
    public void roam() {
        System.out.println("Canine roam.");
    }
    public abstract void bark();
}

class Dog extends Canine {
    public void roam() {
        System.out.println("Dog roam.");
    }

    public void bark() {
        System.out.println("Wah Wah...");
    }

    // Add eat() after compiling TestOldDog.java, TestOldDog.java doesn't need
    // to be recompiled.
    public void eat() {
        System.out.println("Dog eat.");
    }
}
