/******************************************************************************
 *  Compilation:  javac ReverseArray.java
 *  Execution:    java ReverseArray
 *
 *  4. Write a code fragment that reverses the order of values in a
 *  one-dimensional string array. Do not create another array to hold the
 *  result. Hint: Use the code in the text for exchanging two elements.
 *
 ******************************************************************************/

public class ReverseArray { 

    public static void main(String[] args) { 
        int[] a = { 1, 3, 5, 7, 9 };
        int[] b = { 2, 4, 6, 8 };
        
        reverseArray(a);
        printArray(a);

        reverseArray2(b);
        printArray(b);
    }
    
    static void reverseArray(int[] a) {
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    static void reverseArray2(int[] a) {
        int n = a.length;
        for (int i = 0; i < n/2; i++) {
            int temp = a[n-i-1];
            a[n-i-1] = a[i];
            a[i] = temp;
        }
    }

    static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + (i == a.length - 1 ? "\n" : " "));
        }
    }
}