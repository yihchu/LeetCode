package In.House.Q1005;

import java.util.Arrays;

public class Solution {

    public int largestSumAfterKNegationsV1(int[] nums, int k) {
        Arrays.sort(nums);
        int idx = 0, len = nums.length;
        while (idx < len) {
            if (nums[idx] < 0 && k > 0) {
                nums[idx] = -nums[idx];
                --k;
                ++idx;
                continue;
            }
            break;
        }
        if (k % 2 == 1) {
            Arrays.sort(nums);
            nums[0] = -nums[0];
        }
        return Arrays.stream(nums).sum();
    }


    // 这个方法比上面V1方法要减少一次排序
    // 所以我感觉很明显这个方法更优一点
    // 但是咱不知道leetcode是咋回事
    // 内存和时间占用，都不如V1的好
    // 只能说很奇怪
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int idx = 0, len = nums.length;
        while (idx < len) {
            if (nums[idx] < 0 && k > 0) {
                nums[idx] = -nums[idx];
                --k;
                ++idx;
                continue;
            }
            break;
        }
        if (k % 2 == 1) {
            if (idx == len || (idx > 0 && nums[idx - 1] < nums[idx])) {
                nums[idx - 1] = -nums[idx - 1];
            } else {
                nums[idx] = -nums[idx];
            }
        }
        return Arrays.stream(nums).sum();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.largestSumAfterKNegations(new int[] {4, 2, 3}, 1)); // 5
        System.out.println(slt.largestSumAfterKNegations(new int[] {3, -1, 0, 2}, 3)); // 6
        System.out.println(slt.largestSumAfterKNegations(new int[] {2, -3, -1, 5, -4}, 2)); // 13
        System.out.println(slt.largestSumAfterKNegations(new int[] {-2, 5, 0, 2, -2}, 3)); // 11
        System.out.println(slt.largestSumAfterKNegations(new int[] {-8,3,-5,-3,-5,-2}, 6)); // 22
        System.out.println(slt.largestSumAfterKNegations(new int[] {-4, -2, -3}, 4)); // 22
    }

}

