package chap10.ryan;

import java.util.Locale;
import java.util.Date;
import java.util.Calendar;

public class TestFormat {
    public static void main(String[] args) {
        double a = 476578.09876;
        String s = String.format("I have %, .2f bugs to fix.", a);  // space
        String ss = String.format("I have %%,.2f bugs to fix.", a); // escape %
        System.out.println(s + ss);
        System.out.println(Locale.getDefault());
        System.out.println(String.format("%X",42));
        System.out.println();
        Date t = new Date();
        System.out.println(String.format("%tc", t));
        System.out.println(String.format("%tr", t));
        System.out.println(String.format("%tA, %<tB %<td", t));
        System.out.println();
        Calendar c = Calendar.getInstance();
        int r = c.get(Calendar.ZONE_OFFSET);
        System.out.println(r);
    }
}