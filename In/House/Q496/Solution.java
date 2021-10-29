package In.House.Q496;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums2.length;
//        // 原解法
//        for (int i = 0; i < len - 1; ++i) {
//            for (int j = i + 1; j < len; ++j) {
//                if (nums2[i] < nums2[j]) {
//                    map.put(nums2[i], nums2[j]);
//                    break;
//                }
//            }
//        }
        // 官方题解中，是使用了"单调栈"来处理nums2，负责度O(nums2.length)
        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1; i > -1; --i) {
            if (!stack.isEmpty() && nums2[i] >= stack.peek()) {
                while (!stack.isEmpty() && nums2[i] >= stack.peek()) {
                    stack.pop();
                }
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.add(nums2[i]);
        }
        //
        len = nums1.length;
        int[] result = new int[len];
        for (int i = 0; i < len; ++i) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        Arrays.stream(slt.nextGreaterElement(new int[] {4, 1, 2}, new int[] {1, 3, 4, 2}))
                .forEach(a -> System.out.print(a + " ")); // [-1, 3, -1]
        System.out.println();
        Arrays.stream(slt.nextGreaterElement(new int[] {2, 4}, new int[] {1, 2, 3, 4}))
                .forEach(a -> System.out.print(a + " "));
        System.out.println();
        Arrays.stream(slt.nextGreaterElement(new int[] {2, 1, 3}, new int[] {2, 3, 1}))
                .forEach(a -> System.out.print(a + " "));
        System.out.println();
    }

}

/**
Link: https://leetcode-cn.com/problems/next-greater-element-i/

给你两个没有重复元素的数组nums1和nums2，其中nums1是nums2的子集。
请你找出nums1中每个元素在nums2中的下一个比其大的值。
nums1中数字x的下一个更大元素是指x在nums2中对应位置的右边的第一个比x大的元素。如果不存在，对应位置输出-1。

示例1:
输入: nums1 = [4, 1, 2], nums2 = [1, 3, 4, 2].
输出: [-1, 3, -1]
解释:
    对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出-1。
    对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是3。
    对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出-1。

示例2:
输入: nums1 = [2, 4], nums2 = [1, 2, 3, 4].
输出: [3, -1]
解释:
    对于num1中的数字2，第二个数组中的下一个较大数字是3。
    对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出-1。

提示：
1 <= nums1.length <= nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 10^4
nums1和nums2中所有整数互不相同
nums1中的所有整数同样出现在nums2中

进阶：你可以设计一个时间复杂度为O(nums1.length + nums2.length)的解决方案吗？
*/