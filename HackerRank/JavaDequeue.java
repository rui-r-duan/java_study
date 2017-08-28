import java.util.*;
public class JavaDequeue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            if (i < m) {
                deque.add(num);
                map.merge(num, 1, Integer::sum);
            } else {
                int first = deque.getFirst();
                deque.removeFirst();
                deque.add(num);

                map.merge(num, 1, Integer::sum);
                Integer value = map.get(first); // if first is not contained, return null
                if (value == 1) {
                    map.remove(first);
                }
                else { // value > 1
                    map.put(first, value - 1);
                }
            }
//            printDeque(deque);
//            printMap(map);
            // if (max < map.size()) {
            //     max = map.size();
            // }
            max = Math.max(max, map.size());
        }
        in.close();
        System.out.println(max);
    }
    public static void printDeque(Deque<Integer> deque) {
        System.out.println();
        for (Integer x : deque) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
    public static void printMap(HashMap<Integer, Integer> map) {
        System.out.println("\tmap: ");
        for (Integer key : map.keySet()) {
            System.out.println("\t[" + key + "->" + map.get(key) + "]");
        }
    }
}
