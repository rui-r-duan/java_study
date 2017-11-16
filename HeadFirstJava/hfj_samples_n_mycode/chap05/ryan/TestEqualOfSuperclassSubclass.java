package chap05.ryan;

import java.text.*;

public class TestEqualOfSuperclassSubclass {

    public static void main(String[] args) {
        FieldPosition fp = new FieldPosition(10);
        FieldPosition fp1 = new MyTest(10);
        System.out.println(fp.equals(fp1));
        System.out.println(fp1.equals(fp));
    }
}

class MyTest extends FieldPosition{

    int x = 10;

    public MyTest(int x){
        super(x);
        this.x = x;
    }

    public boolean equals(Object o){
        if(o==null) return false;
        if(!(o instanceof MyTest )) return false;
        return ((MyTest)o).x == this.x;
    }
}
