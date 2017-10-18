/******************************************************************************
 *  Compilation:  javac GuessBigger.java
 *  Execution:    java GuessBigger
 *  
 * Guess the biggest number. Consider the following game. Alice writes down two
 * integers between 0 and 100 on two cards. Bob gets to select one of the two 
 * cards and see its value. After looking at the value, Bob commits to one of 
 * the two cards. If he chooses a card with the largest value, he wins; 
 * otherwise he loses. Devise a strategy (and corresponding computer program) 
 * for Bob so that he guarantees to win strictly more than half the time.
 * 
 * Solution:
 * https://mathoverflow.net/questions/9037/how-is-it-that-you-can-guess-if-one-of-a-pair-of-random-numbers-is-larger-with
 * 
 *  % java GuessBigger
 *  Alice writes two integers between 0 and 100:
 *  a[0] = 41
 *  a[1] = 4
 *  Bob sees 41
 *  Bob thinks of a reference number: 6
 *  Bob says the larger one is 41
 *  Bob wins!
 *
 *
 ******************************************************************************/

public class GuessBigger {
    public static void main(String[] args) {
        int a[] = new int[2];
        a[0] = (int)(Math.random() * 100);
        a[1] = (int)(Math.random() * 100);
        System.out.println("Alice writes two integers between 0 and 100:");
        System.out.println("a[0] = " + a[0]);
        System.out.println("a[1] = " + a[1]);
        
        double rand = Math.random();
        int see = (int)(rand * 2);
        // System.out.println("rand = " + rand + ", " + see);
        System.out.println("Bob sees " + a[see]);
        
        int r = (int)(Math.random() * 100);
        System.out.println("Bob thinks of a reference number: " + r);
        int choose = 0;
        if (r < a[see]) {
            choose = see;
        }
        else {
            choose = (see + 1) % 2;
        }
        
        System.out.println("Bob says the larger one is " + a[choose]);
        if (a[choose] == (int)Math.max(a[0], a[1])) {
            System.out.println("Bob wins!");
        }
        else {
            System.out.println("Bob loses.");
        }
    }
}
