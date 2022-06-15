package In.House.Q719;

import java.util.Arrays;


// CV 大法
public class Solution {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length, l = 0, r = nums[len - 1] - nums[0];
        while (l <= r) {
            int mid = (l + r) / 2;
            int count = 0;
            for (int i = 0, j = 0; j < len; ++j) {
                while (nums[j] - nums[i] > mid) {
                    ++i;
                }
                count += (j - i);
            }
            if (count >= k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.smallestDistancePair(new int[] {1, 3, 1}, 1)); // 0
        System.out.println(slt.smallestDistancePair(new int[] {1, 1, 1}, 2)); // 0
        System.out.println(slt.smallestDistancePair(new int[] {1, 6, 1}, 3)); // 5
    }

}
