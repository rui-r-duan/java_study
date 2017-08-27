public class PhoneNumberWord {
    public static void main(String[] args) {
        String[] dict = new String[]{
                "",     // 0
                "",     // 1
                "ABC",  // 2
                "DEF",  // 3
                "GHI",  // 4
                "JKL",  // 5
                "MNO",  // 6
                "PQRS", // 7
                "TUV",  // 8
                "WXYZ"  // 9
        };
        int[] number = {2, 6, 6, 7, 8, 8, 3, 7};
        int[] answer = {0, 0, 0, 0, 0, 0, 0, 0};
        while (true) {
            int i;
            for (i = 0; i < number.length; ++i) {
                System.out.print(dict[number[i]].charAt(answer[i]));
            }
            System.out.print('\n');

            int k = number.length - 1;
            while (k >= 0) {
                if (answer[k] < dict[number[k]].length() - 1) {
                    answer[k]++;
                    break;
                } else {
                    answer[k] = 0;
                    k--;
                }
            }
            if (k < 0) {
                break;
            }
        }

    }
}
