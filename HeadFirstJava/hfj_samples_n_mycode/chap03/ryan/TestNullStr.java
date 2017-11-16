package chap03.ryan;

import chap03.*;

public class TestNullStr {
    public static void main(String[] args) {
        System.out.println(new String());
        System.out.println(new String() + "");
        System.out.println(new String() + " says:");

        // chap03/ryan/TestNullStr.java:10: name is not public in chap03.Dog;
        // cannot be accessed from outside package
        // System.out.println(new Dog().name + " says:");
        new Dog().bark();

        String s = null;
        System.out.println(s);
    }
}