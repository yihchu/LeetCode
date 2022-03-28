package In.House.Q1984;

import java.util.Arrays;

public class Solution {

    public int minimumDifference(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }
        int len = nums.length, result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < len - k + 1; ++i) {
            result = Math.min(result, nums[i + k - 1] - nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.minimumDifference(new int[] {90}, 1)); // 0
        System.out.println(slt.minimumDifference(new int[] {9, 4, 1, 7}, 2)); // 2
    }

}