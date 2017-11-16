package chap05.ryan;

import java.util.HashMap;
import java.util.Map;

final class PhoneNumber {
    private final int areaCode;
    private final int exchange;
    private final int extension;

    public PhoneNumber(int areaCode, int exchange, int extension) {
        rangeCheck(areaCode, 999, "area code");
        rangeCheck(exchange, 99999999, "exchange");
        rangeCheck(extension, 9999, "extension");
        this.areaCode = areaCode;
        this.exchange = exchange;
        this.extension = extension;
    }

    private static void rangeCheck(int arg, int max, String name) {
        if(arg < 0 || arg > max)
            throw new IllegalArgumentException(name + ": " + arg);
    }

    public boolean equals(Object o) {
        if(o == this)
            return true;
        if(!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber)o;
        return pn.extension == extension && pn.exchange == exchange
            && pn.areaCode == areaCode;
    }
}

public class TestEqual {
    public static void main(String[] args) {
        Map hm = new HashMap();
        PhoneNumber pn = new PhoneNumber(123, 38942, 230);
        hm.put(pn, "I love you");
        PhoneNumber pn1 = new PhoneNumber(123, 38942, 230);
        System.out.println(pn);
        System.out.println("pn.equals(pn1) is " + pn.equals(pn1)); // true
        System.out.println("pn == pn1 : " + (pn == pn1));          // false
        System.out.println(hm.get(pn1)); // null
        System.out.println(hm.get(pn));  // "I love you"
    }
}