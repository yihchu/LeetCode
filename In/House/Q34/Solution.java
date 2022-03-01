package In.House.Q34;

import java.util.Arrays;

public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                l = mid;
                r = mid;
                while (l - 1 > -1 && nums[l] == nums[l - 1]) {
                    --l;
                }
                while (r + 1 < len && nums[r] == nums[r + 1]) {
                    ++r;
                }
                return new int[] {l, r};
            } else if (nums[mid] < target) {
                l = mid + 1;
                while (l < r && l + 1 < len && nums[l] == nums[l + 1]) {
                    ++l;
                }
            } else if (nums[mid] > target) {
                r = mid - 1;
                while (r > l && r - 1 > -1 && nums[r] == nums[r - 1]) {
                    --r;
                }
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        Arrays.stream(slt.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8)).forEach(a -> System.out.print(a + " ")); // [3, 4]
        System.out.println();
        Arrays.stream(slt.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 6)).forEach(a -> System.out.print(a + " ")); // [-1, -1]
        System.out.println();
        Arrays.stream(slt.searchRange(new int[] { }, 0)).forEach(a -> System.out.print(a + " ")); // [-1, -1]
        System.out.println();
        Arrays.stream(slt.searchRange(new int[] {1}, 1)).forEach(a -> System.out.print(a + " ")); // [0, 0]
        System.out.println();
        Arrays.stream(slt.searchRange(new int[] {1}, 0)).forEach(a -> System.out.print(a + " ")); // [-1, -1]
        System.out.println();
        Arrays.stream(slt.searchRange(new int[] {2, 2}, 3)).forEach(a -> System.out.print(a + " ")); // [-1, -1]
        System.out.println();
    }

}

/**
Ques: 在排序数组中查找元素的第一个和最后一个位置
Link: https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/

给定一个按照升序排列的整数数组nums，和一个目标值target。找出给定目标值在数组中的开始位置和结束位置。
如果数组中不存在目标值target，返回[-1, -1]。

进阶：
你可以设计并实现时间复杂度为O(logn)的算法解决此问题吗？

示例1：
输入：nums = [5, 7, 7, 8, 8, 10], target = 8
输出：[3, 4]

示例2：
输入：nums = [5, 7, 7, 8, 8, 10], target = 6
输出：[-1, -1]

示例3：
输入：nums = [], target = 0
输出：[-1, -1]

提示：
0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums是一个非递减数组
-10^9 <= target <= 10^9

*/