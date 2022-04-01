package In.House.Q453;

import java.util.Arrays;

public class Solution {

    public int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int result = 0, len = nums.length;
        for (int i = 0; i < len; ++i) {
            result += (nums[i] - min);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.minMoves(new int[] {1, 2, 3})); // 3
        System.out.println(slt.minMoves(new int[] {1, 1, 1})); // 0
        System.out.println(slt.minMoves(new int[] {5, 6, 8, 8, 5})); // 7
    }

}

