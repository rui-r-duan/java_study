/******************************************************************************
 *  Compilation:  javac Dragon.java
 *  Execution:    java Dragon
 *  
 *  Prints the instructions for drawing a dragon curve of orders 0
 *  through 5.
 * 
 *  % java Dragon
 *  F
 *  FLF
 *  FLFLFRF
 *  FLFLFRFLFLFRFRF
 *  FLFLFRFLFLFRFRFLFLFLFRFRFLFRFRF
 *  FLFLFRFLFLFRFRFLFLFLFRFRFLFRFRFLFLFLFRFLFLFRFRFRFLFLFRFRFLFRFRF
 *
 ******************************************************************************/

public class Dragon { 
    public static void main(String[] args) { 
//        String dragon0 = "F";
//        String nogard0 = "F";
//        String dragon1 = dragon0 + "L" + nogard0;
//        String nogard1 = dragon0 + "R" + nogard0;
//        String dragon2 = dragon1 + "L" + nogard1;
//        String nogard2 = dragon1 + "R" + nogard1;
//        String dragon3 = dragon2 + "L" + nogard2;
//        String nogard3 = dragon2 + "R" + nogard2;
//        String dragon4 = dragon3 + "L" + nogard3;
//        String nogard4 = dragon3 + "R" + nogard3;
//        String dragon5 = dragon4 + "L" + nogard4;
        String dragon0 = dragonRecursive(0);
        String dragon1 = dragonRecursive(1);
        String dragon2 = dragonRecursive(2);
        String dragon3 = dragonRecursive(3);
        String dragon4 = dragonRecursive(4);
        String dragon5 = dragonRecursive(5);

        System.out.println(dragon0);
        System.out.println(dragon1);
        System.out.println(dragon2);
        System.out.println(dragon3);
        System.out.println(dragon4);
        System.out.println(dragon5);
    }
    
    // order = 0, 1, 2, ...
    private static String dragonRecursive(int order) {
        String dragon0 = "F";
        if (order == 0) {
            return dragon0;
        }
        else {
            return dragonRecursive(order - 1) + "L" + reverseDragon(order - 1);
        }
    }
    
    private static String reverseDragon(int order) {
        String nogard0 = "F";
        if (order == 0) {
            return nogard0;
        }
        else {
            return dragonRecursive(order - 1) + "R" + reverseDragon(order - 1);
        }
    }
}