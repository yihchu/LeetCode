package In.House.Q581;

public class Solution {

//    // 官方
//    public int findUnsortedSubarray(int[] nums) {
//        int n = nums.length;
//        int maxn = Integer.MIN_VALUE, right = -1;
//        int minn = Integer.MAX_VALUE, left = -1;
//        for (int i = 0; i < n; i++) {
//            if (maxn > nums[i]) {
//                right = i;
//            } else {
//                maxn = nums[i];
//            }
//            if (minn < nums[n - i - 1]) {
//                left = n - i - 1;
//            } else {
//                minn = nums[n - i - 1];
//            }
//        }
//        return right == -1 ? 0 : right - left + 1;
//    }


    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int r = -1, l = len;
        for (int i = 0; i < len; ++i) {
            if (max <= nums[i]) {
                max = nums[i];
            } else {
                r = i;
            }

            if (min >= nums[len - 1 - i]) {
                min = nums[len - 1 - i];
            } else {
                l = len - 1 - i;
            }
        }
        return r < 0 ? 0 : r - l + 1;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
//        System.out.println(slt.findUnsortedSubarray(new int[] {2, 6, 4, 8, 10, 9, 15})); // 5
//        System.out.println(slt.findUnsortedSubarray(new int[] {2, 6, 4, 8, 10, 15, 9})); // 6
//        System.out.println(slt.findUnsortedSubarray(new int[] {6, 2, 4, 8, 10, 15, 9})); // 7
//        System.out.println(slt.findUnsortedSubarray(new int[] {1, 2, 3, 4})); // 0
//        System.out.println(slt.findUnsortedSubarray(new int[] {1})); // 0
//        System.out.println(slt.findUnsortedSubarray(new int[] {1, 3, 2, 2, 2})); // 4
//        System.out.println(slt.findUnsortedSubarray(new int[] {3, 2, 3, 2, 4})); // 4
//        System.out.println(slt.findUnsortedSubarray(new int[] {1, 1})); // 0
//        System.out.println(slt.findUnsortedSubarray(new int[] {2, 3, 3, 2, 4})); // 3
//        System.out.println(slt.findUnsortedSubarray(new int[] {1, 2, 4, 3, 5})); // 2
//        System.out.println(slt.findUnsortedSubarray(new int[] {10, 20, 21, 25, 40, 30, 22, 50})); // 4
        System.out.println(slt.findUnsortedSubarray(
                new int[] {-100, -99, -98, -97, -96, -95, -94, -93, -92, -91, -90, -89, -88, -87, -86, -85, -84, -83
                        , -82, -81, -80, -79, -78, -77, -76, -75, -65, -53, -73, -63, -67, -61, -39, -58, -56, -55, -68
                        , -66, -74, -49, -60, -51, -62, -42, -47, -54, -43, -71, -64, -59, -45, -69, -57, -41, -70, -44
                        , -46, -50, -48, -72, -52, -40, -38, -37, -36, -35, -34, -33, -32, -31, -30, -29, -28, -27, -26
                        , -25, -24, -23, -22, -21, -20, -19, -18, -17, -16, -15, -14, -13, -12, -11, -10, -9, -8, -7, -6
                        , -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20
                        , 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44
                        , 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68
                        , 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92
                        , 93, 94, 95, 96, 97, 98, 99}));
    }

}

/**
Ques: 最短无序连续子数组
Link: https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/

给你一个整数数组nums，你需要找出一个连续子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
请你找出符合题意的最短子数组，并输出它的长度。

示例1：
输入：nums = [2, 6, 4, 8, 10, 9, 15]
输出：5
解释：你只需要对[6, 4, 8, 10, 9]进行升序排序，那么整个表都会变为升序排序。

示例2：
输入：nums = [1, 2, 3, 4]
输出：0

示例3：
输入：nums = [1]
输出：0

提示：
1 <= nums.length <= 10^4
-10^5 <= nums[i] <= 10^5

进阶：你可以设计一个时间复杂度为O(n)的解决方案吗？
*/