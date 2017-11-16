// DO NOT COMPILE
// COMPILE ERROR:
//
// chap05/ryan/TestInnerClass.java:6: inner classes cannot have static declarations
//         private static int MYFAITH = 37;
//                            ^
// chap05/ryan/TestInnerClass.java:10: inner classes cannot have static declarations
//         public static int getInnerConst() {
//                           ^
// chap05/ryan/TestInnerClass.java:14: non-static variable this cannot be referenced from a static context
//             new Inner(i);
//             ^
// chap05/ryan/TestInnerClass.java:13: inner classes cannot have static declarations
//         public static Inner createInner(int i) {
//                             ^
// chap05/ryan/TestInnerClass.java:22: cannot find symbol
// symbol  : method createInner(int)
// location: class chap05.ryan.Outer
//         System.out.println(createInner(5));
//                            ^
// 5 errors

package chap05.ryan;

class Outer {
    class Inner {
        private int d;
        private static int MYFAITH = 37;
        public Inner(int i) {
            d = i;
        }
        public static int getInnerConst() {
            return MYFAITH;
        }
        public static Inner createInner(int i) {
            new Inner(i);
        }
        @Override
            public String toString() {
            return getClass().getName() + ": " + d;
        }
    }
    public static void main(String[] args) {
        System.out.println(createInner(5));
        System.out.println(Inner.getInnerConst());
    }
}