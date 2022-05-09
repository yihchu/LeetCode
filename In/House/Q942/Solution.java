package In.House.Q942;

import java.util.Arrays;

public class Solution {

    public int[] diStringMatch(String s) {
        int len = s.length();
        int[] result = new int[len + 1];
        int min = 0, max = len;
        for (int i = 0; i < len; ++i) {
            if (s.charAt(i) == 'I') {
                result[i] = min ++;
            } else {
                result[i] = max --;
            }
        }
        result[len] = min;
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        Arrays.stream(slt.diStringMatch("IDID")).forEach(a -> System.out.print(a + " "));
        System.out.println(); // [0, 4, 1, 3, 2]
        Arrays.stream(slt.diStringMatch("III")).forEach(a -> System.out.print(a + " "));
        System.out.println(); // [0, 1, 2, 3]
        Arrays.stream(slt.diStringMatch("DDI")).forEach(a -> System.out.print(a + " "));
        System.out.println(); // [3, 2, 0, 1]
    }

}
