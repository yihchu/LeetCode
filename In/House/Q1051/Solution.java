package In.House.Q1051;

import java.util.Arrays;

public class Solution {

    public int heightChecker(int[] heights) {
        int[] tmp = Arrays.stream(heights).sorted().toArray();
        int count = 0;
        for (int i = 0; i < heights.length; ++i) {
            if (tmp[i] != heights[i]) {
                ++ count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.heightChecker(new int[] {1, 1, 4, 2, 1, 3})); // 3
        System.out.println(slt.heightChecker(new int[] {5, 1, 2, 3, 4})); // 5
        System.out.println(slt.heightChecker(new int[] {1, 2, 3, 4, 5})); // 0
    }

}
