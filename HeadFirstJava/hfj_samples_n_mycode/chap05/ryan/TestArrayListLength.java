package chap05.ryan;

import java.util.ArrayList;

class TestArrayListLength {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(new Integer(0));
        a.add(new Integer(1));
        a.add(new Integer(2));
        a.add(new Integer(3));
        ArrayList<Integer> b = new ArrayList<Integer>(a);
        ArrayList<Integer> c = new ArrayList<Integer>(a);


        // TEST RESULT
// true
// false
        System.out.println(a.equals(b));
        System.out.println(a == b);

        // a
        // TEST RESULT
// Actions on a: for...a.size(), index no increment
// try removing 0
// removed 0
// try removing 1
// removed 1
// try removing 2
// removed 2
// try removing 3
// removed 3
        System.out.println("Actions on a: for...a.size(), index no increment");
        int i;
        for (i = 0; i < a.size(); ) {
            System.out.println("try removing " + a.get(i));
            System.out.println("removed " + a.remove(i));
        }

        // b
        // TEST RESULT
// Actions on b: for...b.size()
// try removing 0
// removed 0
// try removing 2
// removed 2
// i = 2
        System.out.println("\nActions on b: for...b.size()");
        for (i = 0; i < b.size(); i++) {
            System.out.println("try removing " + b.get(i));
            System.out.println("removed " + b.remove(i));
        }
        System.out.println("i = " + i);

        // c
        // TEST RESULT
// Actions on c: for...(int i : c)
// removed 0
// Exception in thread "main" java.util.ConcurrentModificationException
// 	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:782)
// 	at java.util.ArrayList$Itr.next(ArrayList.java:754)
// 	at chap05.ryan.TestArrayListLength.main(TestArrayListLength.java:40)
        System.out.println("\nActions on c: for...(int i : c)");
        int cnt = 0;
        for (int obj : c) {
            System.out.println("removed " + c.remove(obj));
            cnt++;
        }
        System.out.println("cnt = " + cnt);
    }
}