package chap10.ryan;

import java.util.Calendar;

public class MyFullMoon {
    final static int DAY_MILLIS = 24 * 60 * 60 * 1000;
    final static double PERIOD = 29.52;
    final static int YEARS_CNT = 60;

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2004, 0, 7, 15, 40, 44);
        long tmpDayTime = c.getTimeInMillis();
        for (int i = 0; i < YEARS_CNT; i++) {
            tmpDayTime += DAY_MILLIS * PERIOD;
            c.setTimeInMillis(tmpDayTime);
            System.out.println(String.format("full moon on %tc", c));
        }
    }
}