package In.House.Q704;

public class Solution {

    public int search(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target < nums[mid]) {
                r = mid - 1;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.search(new int[]{-1, 0, 3, 5, 9, 12}, 9)); // 4
        System.out.println(slt.search(new int[]{-1, 0, 3, 5, 9, 12}, 2)); // -1
    }

}

/**
Ques: 二分查找
Link: https://leetcode-cn.com/problems/binary-search/

给定一个n个元素有序的（升序）整型数组nums和一个目标值target，写一个函数搜索nums中的target，如果目标值存在返回下标，否则返回-1。

示例1:
输入: nums = [-1, 0, 3, 5, 9, 12], target = 9
输出: 4
解释: 9出现在nums中并且下标为4

示例2:
输入: nums = [-1, 0, 3, 5, 9, 12], target = 2
输出: -1
解释: 2不存在nums中因此返回-1

提示：
你可以假设nums中的所有元素是不重复的。
n将在[1, 10000]之间。
nums的每个元素都将在[-9999, 9999]之间。


*/