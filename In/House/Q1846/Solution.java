package In.House.Q1846;

import java.util.Arrays;

public class Solution {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return len == 1 ? 1 : 0;
        }
        Arrays.sort(arr);
        if (arr[0] != 1) {
            arr[0] = 1;
        }
        for (int i = 1; i < len; ++i) {
            if (arr[i] - arr[i - 1] <= 1) {
                continue;
            }
            arr[i] = arr[i - 1] + 1;
        }
        return arr[len - 1];
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.maximumElementAfterDecrementingAndRearranging(new int[]{2, 2, 1, 2, 1})); // 2
        System.out.println(slt.maximumElementAfterDecrementingAndRearranging(new int[]{100, 1, 1000})); // 3
        System.out.println(slt.maximumElementAfterDecrementingAndRearranging(new int[]{1, 2, 3, 4, 5})); // 5
        System.out.println(slt.maximumElementAfterDecrementingAndRearranging(new int[]{73, 98, 9})); // 3
        System.out.println(slt.maximumElementAfterDecrementingAndRearranging(new int[]{
                209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209
                , 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209
                , 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209
                , 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209
                , 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209
                , 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209
                , 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209
                , 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209
                , 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209
                , 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209
                , 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209
                , 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209
                , 209, 209, 209, 209, 209, 209, 209, 209, 209}));
    }



}


/**
Ques: 减小和重新排列数组后的最大元素
Link: https://leetcode-cn.com/problems/maximum-element-after-decreasing-and-rearranging/

给你一个正整数数组arr。请你对arr执行一些操作（也可以不进行任何操作），使得数组满足以下条件：
arr中第一个元素必须为1。
任意相邻两个元素的差的绝对值小于等于1，也就是说，对于任意的1 <= i < arr.length（数组下标从0开始），都满足abs(arr[i] - arr[i - 1]) <= 1。abs(x)为x的绝对值。

你可以执行以下2种操作任意次：
减小arr中任意元素的值，使其变为一个更小的正整数。
重新排列arr中的元素，你可以以任意顺序重新排列。
请你返回执行以上操作后，在满足前文所述的条件下，arr中可能的最大值。

示例1：
输入：arr = [2, 2, 1, 2, 1]
输出：2
解释：
我们可以重新排列arr得到[1, 2, 2, 2, 1]，该数组满足所有条件。
arr中最大元素为2。

示例2：
输入：arr = [100, 1, 1000]
输出：3
解释：
一个可行的方案如下：
1. 重新排列arr得到[1, 100, 1000]。
2. 将第二个元素减小为2。
3. 将第三个元素减小为3。
现在arr = [1, 2, 3]，满足所有条件。
arr中最大元素为3。

示例3：
输入：arr = [1, 2, 3, 4, 5]
输出：5
解释：数组已经满足所有条件，最大元素为5。

提示：
1 <= arr.length <= 10^5
1 <= arr[i] <= 10^9

*/