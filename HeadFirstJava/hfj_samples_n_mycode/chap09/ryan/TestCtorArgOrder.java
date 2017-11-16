package chap09.ryan;

class Something {
    public Something(int a, float b) {
        System.out.println("a = " + a + " b = " + b);
    }

    public Something(float aa, int bb) {
        System.out.println("Another constructor!!!");
        System.out.println("aa = " + aa + " bb = " + bb);
    }
}

class TestCtorArgOrder {
    public static void main(String[] args) {
        Something o = new Something(5, 3.0F);
        Something oo = new Something(5.0f, 3);
        Something ooo = new Something(5F, (int)3.0);
    }
}