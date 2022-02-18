package In.House.Q33;

public class Solution {

//    // O(n)
//    public int search(int[] nums, int target) {
//        for (int i = 0; i < nums.length; ++i) {
//            if (nums[i] == target) {
//                return i;
//            }
//        }
//        return -1;
//    }

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[len - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0)); // 4
        System.out.println(slt.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 3)); //-1
        System.out.println(slt.search(new int[] {1}, 0)); // -1
    }

}

/**
Ques: 搜索旋转排序数组
Link: https://leetcode-cn.com/problems/search-in-rotated-sorted-array/

整数数组nums按升序排列，数组中的值互不相同。
在传递给函数之前，nums在预先未知的某个下标k（0 <= k < nums.length）上进行了旋转，使数组变为[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标从0开始计数）。例如，[0, 1, 2, 4, 5, 6, 7]在下标3处经旋转后可能变为[4, 5, 6, 7, 0, 1, 2]。
给你旋转后的数组nums和一个整数target，如果nums中存在这个目标值target，则返回它的下标，否则返回-1。

示例1：
输入：nums = [4, 5, 6, 7, 0, 1, 2], target = 0
输出：4

示例2：
输入：nums = [4, 5, 6, 7, 0, 1, 2], target = 3
输出：-1

示例3：
输入：nums = [1], target = 0
输出：-1

提示：
1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
nums中的每个值都独一无二
题目数据保证nums在预先未知的某个下标上进行了旋转
-10^4 <= target <= 10^4

进阶：你可以设计一个时间复杂度为O(log n)的解决方案吗？

*/