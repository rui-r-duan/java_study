/******************************************************************************
 *  Compilation:  javac RulerLoop.java
 *  Execution:    java RulerLoop
 *  
 *  Prints the relative lengths of the subdivisions on a ruler.
 * 
 *  % java RulerLoop 5
 *  1 2 1 3 1 2 1 4 1 2 1 3 1 2 1 5 1 2 1 3 1 2 1 4 1 2 1 3 1 2 1 
 *
 ******************************************************************************/

public class RulerLoop { 
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        String ruler = "1";
        for (int i = 2; i <= n; i++) {
            ruler = ruler + " " + i + " " + ruler;
        }
        System.out.println(ruler);
    }

}