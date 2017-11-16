package chap10.ryan;

import java.util.ArrayList;

public class TestArrayListInteger {
    public static void doNumsNewWay() {
        ArrayList<Integer> listOfNums = new ArrayList<Integer>();
        listOfNums.add(3);
        listOfNums.add(4);
        int num = listOfNums.get(0);
        System.out.println(listOfNums.get(0) + listOfNums.get(1));
    }
    public static void main(String[] args) {
        doNumsNewWay();
    }
}