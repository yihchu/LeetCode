package In.House.Q821;

import java.util.Arrays;

public class Solution {

    public int[] shortestToChar(String s, char c) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int[] result = new int[len];
        int last = -1, idx = 0;
        while (chars[idx] != c) {
            ++ idx;
        }
        for (int i = 0; i < idx; ++i) {
            result[i] = idx - i;
        }
        result[idx] = 0;
        last = idx;
        for (int i = last + 1; i < len; ++i) {
            if (chars[i] != c) {
                result[i] = i - last;
                continue;
            }
            for (int j = (last + i) / 2; j < i; ++j) {
                result[j] = Math.min(j - last, i  - j);
            }
            result[i] = 0;
            last = i;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        Arrays.stream(slt.shortestToChar("loveleetcode", 'e')).forEach(s -> System.out.print(s + " "));
        System.out.println(); // [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
        Arrays.stream(slt.shortestToChar("aaab", 'b')).forEach(s -> System.out.print(s + " "));
        System.out.println(); // [3, 2, 1, 0]
        Arrays.stream(slt.shortestToChar("aaba", 'b')).forEach(s -> System.out.print(s + " "));
        System.out.println(); // [2, 1, 0, 1]
    }

}
