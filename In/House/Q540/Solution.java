package In.House.Q540;

public class Solution {

//    // O(n)
//    public int singleNonDuplicate(int[] nums) {
//        int result = 0;
//        for (int n: nums) {
//            result ^= n;
//        }
//        return result;
//    }

    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            mid = mid % 2 == 1 ? mid - 1: mid;
            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
//        System.out.println(slt.singleNonDuplicate(new int[] {1, 1, 2, 3, 3, 4, 4, 8, 8})); // 2
        System.out.println(slt.singleNonDuplicate(new int[] {3, 3, 7, 7, 10, 11, 11})); // 10
    }

}

/**
Ques: 有序数组中的单一元素
Link: https://leetcode-cn.com/problems/single-element-in-a-sorted-array/

给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
请你找出并返回只出现一次的那个数。
你设计的解决方案必须满足O(logn)时间复杂度和O(1)空间复杂度。

示例1:
输入: nums = [1, 1, 2, 3, 3, 4, 4, 8, 8]
输出: 2

示例2:
输入: nums =  [3, 3, 7, 7, 10, 11, 11]
输出: 10

提示:
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^5
*/
