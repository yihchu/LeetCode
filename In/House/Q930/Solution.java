package In.House.Q930;

import java.util.Arrays;

public class Solution {

    public int numSubarraysWithSum(int[] nums, int goal) {
        if (goal == 0) {
            int len = nums.length;
            int s = 0, sum = 0;
            boolean allZero = true;
            for (int i = 0; i < len; ++i) {
                if (nums[i] == 1) {
                    allZero = false;
                    sum += find(Arrays.copyOfRange(nums, s, i), goal);
                    s = i + 1;
                }
            }
            if (!allZero) {
                sum += find(Arrays.copyOfRange(nums, s, len), goal);
                return sum;
            }
        }
        return find(nums, goal);
    }

    public int find(int[] nums, int goal) {
        int len = nums.length, result = 0;
        if (len < 1) {
            return result;
        }
        int l = 0, r = 0, sum = 0;
        for (; r < len; ++r) {
            sum += nums[r];
            if (sum == goal) {
                result = 1;
                break;
            }
        }
        if (result < 1) {
            return result;
        }
        if (l == r && goal == 0) result = 0;
        int t = 0;
        while (r < len) {
            if (t == 0) {
                while (l + t <= r && nums[l + t] == 0) {
                    ++t;
                }
                result += t;
            }

            if (r + 1 < len) {
                ++r;
                t += (l == r - t ? 1 : 0);
                if (nums[r] == 0) {
                    result += (t +  (l == r - t + 1? 0 : 1) );
                } else {
                    l += (t + 1);
                    t = 0;
                    ++result;
                }
            } else {
                r = len;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2)); // 4
        System.out.println(slt.numSubarraysWithSum(new int[]{0, 1, 0, 0, 0}, 1)); // 8
        System.out.println(slt.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0)); // 15
        System.out.println(slt.numSubarraysWithSum(new int[]{0, 0, 1, 0}, 0)); // 4
        System.out.println(slt.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 0)); // 27
        System.out.println(slt.numSubarraysWithSum(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 1)); // 27

    }

}
