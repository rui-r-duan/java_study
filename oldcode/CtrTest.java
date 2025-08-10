class CtrTest {
    int a = 5;
    static int b = 100;

    public CtrTest(int v) {
        a = v;
    }

    public int getA() {
        return a;
    }

    public static void main(String[] args) {
        CtrTest test1 = new CtrTest(6);
        System.out.println("test1.a = " + test1.a);
        System.out.println("CtrTest.b = " + b);
        CtrTest test2 = new CtrTest(8);
        System.out.println("test2.a = " + test2.getA());
    }

    static {
        System.out.println("b = " + CtrTest.b);
    }
}