import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import static java.lang.System.in;

class Prime {
    public void checkPrime(int ... args) {
        boolean isFirst = true;
        for (int i = 0; i < args.length; i++) {
            if (isPrime(args[i])) {
                if (isFirst) {
                    System.out.print(args[i]);
                    isFirst = false;
                }
                else {
                    System.out.print(" " + args[i]);
                }
            }
        }
        System.out.println();
    }
    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        int maxDivider = (int)Math.sqrt(n);
        for (int i = 2; i <= maxDivider; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

public class PrimeChecker {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            Prime ob = new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1, n2);
            ob.checkPrime(n1, n2, n3);
            ob.checkPrime(n1, n2, n3, n4, n5);
            Method[] methods = Prime.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (int i = 0; i < methods.length; i++) {
                if (set.contains(methods[i].getName())) {
                    overload = true;
                    break;
                }
                set.add(methods[i].getName());
            }
            if (overload) {
                throw new Exception("Overloading not allowed");
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
