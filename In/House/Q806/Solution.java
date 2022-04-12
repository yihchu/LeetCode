package In.House.Q806;

import java.util.Arrays;

public class Solution {

    private final static int LIMIT = 101;

    public int[] numberOfLines(int[] widths, String s) {
        int[] result = new int[] {1, 0};
        char[] chars = s.toCharArray();
        int len = s.length(), current = 0;
        for (int i = 0; i < len; ++i) {
            int idx = chars[i] - 'a';
            int tmp = current + widths[idx];
            if (tmp < LIMIT) {
                current = tmp;
            } else {
                ++ result[0];
                current = widths[idx];
            }
        }
        result[1] = current;
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        Arrays.stream(slt.numberOfLines(
                new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}
                , "abcdefghijklmnopqrstuvwxyz")).forEach(a -> System.out.print(a + " ")); // [3, 60]
        System.out.println();
        Arrays.stream(slt.numberOfLines(
                new int[] {4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}
                , "bbbcccdddaaa")).forEach(a -> System.out.print(a + " ")); // [2, 4]
        System.out.println();
    }

}
