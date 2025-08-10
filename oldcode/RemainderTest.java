class RemainderTest {
    public static void main(String[] args) {
        int d = 3;
        int e = -3;
        int a = 10;
        int b = -10;
        int v1 = a % d;
        int v2 = b % d;
        int v3 = a % e;
        int v4 = b % e;
        boolean v5 = !true;
        System.out.println("10 % 3 = " + v1);
        System.out.println("-10 % 3 = " + v2);
        System.out.println("10 % -3 = " + v3);
        System.out.println("-10 % -3 = " + v4);
        int v6 = ++v4;
        int v7 = v4++;
        System.out.println("v5 = " + v5);
        System.out.println("v6 = " + v6);
        System.out.println("v7 = " + v7);
        System.out.println("v4 = " + v4);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        int v8 = a + b / 100;
        System.out.println("v8 = " + v8);
        switch (a) {
        case 1:
        case 2:
            break;
        case 10:
            System.out.println("In case 10.");
            break;
        }
    }
}