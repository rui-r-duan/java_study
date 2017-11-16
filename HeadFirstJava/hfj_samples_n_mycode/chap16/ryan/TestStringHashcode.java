package chap16.ryan;

public class TestStringHashcode {
    public static void main(String[] args) {
        String a = "something";
        String b = "something";
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }
}
