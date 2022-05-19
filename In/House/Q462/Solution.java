package In.House.Q462;

import java.util.Arrays;

public class Solution {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int count = 0, mid = nums.length / 2;
        for (int num: nums) {
            count += Math.abs(num - nums[mid]);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.minMoves2(new int[] {1, 2, 3})); // 2
        System.out.println(slt.minMoves2(new int[] {1, 10, 2, 9})); // 16
    }

}
