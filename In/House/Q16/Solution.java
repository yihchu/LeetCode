package In.House.Q16;

import java.util.Arrays;

public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if (len == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        int nearest = 100000;
        for (int i = 0; i < len - 2; ++i) {
            int l = i + 1, r = len - 1;
            while (l < r) {
                int tmp = nums[i] + nums[l] + nums[r];
                if (tmp < target) {
                    ++l;
                } else {
                    --r;
                }
                nearest = Math.abs(target - nearest) > Math.abs(target - tmp) ? tmp : nearest;
            }
        }
        return nearest;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.threeSumClosest(new int[] {-1, 2, 1, -4}, 1)); // 2
        System.out.println(slt.threeSumClosest(new int[] {0, 0, 0}, 1)); // 0
    }

}

