package In.House.Q1877;

import java.util.Arrays;

public class Solution {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = -1, len = nums.length;
        for (int i = 0; i < len / 2; i ++) {
            int sum = nums[i] + nums[len - 1 - i];
            max = sum > max ? sum : max;
            System.out.println("(" + nums[i] + "， " + nums[len - 1 - i] + ")");
        }
        return max;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.minPairSum(new int[]{3, 5, 2, 3})); // 7
        System.out.println(slt.minPairSum(new int[]{3, 5, 4, 2, 4, 6})); // 8
    }

}
