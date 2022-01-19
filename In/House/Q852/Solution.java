package In.House.Q852;

public class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        int s = 0, e = arr.length - 1, m;
        if (e == 2) return arr[1];
        while(s < e) {
            m = (s + e) / 2;
            if (arr[m] > arr[m - 1] && arr[m] > arr[m + 1]) {
                return m;
            }
            if (arr[m] <= arr[m - 1]) {
                e = m;
            }
            if (arr[m] <= arr[m + 1]) {
                s = m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.peakIndexInMountainArray(new int[]{0, 1, 0})); // 1
        System.out.println(slt.peakIndexInMountainArray(new int[]{0,2,1,0})); // 1
        System.out.println(slt.peakIndexInMountainArray(new int[]{0,10,5,2})); // 1
        System.out.println(slt.peakIndexInMountainArray(new int[]{3,4,5,1})); // 2
        System.out.println(slt.peakIndexInMountainArray(new int[]{24,69,100,99,79,78,67,36,26,19})); // 2
    }

}

/**
Ques: 山脉数组的峰顶索引
Link: https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/

符合下列属性的数组arr称为山脉数组：
arr.length >= 3
存在i（0 < i < arr.length - 1）使得：
arr[0] < arr[1] < ... arr[i-1] < arr[i]
arr[i] > arr[i+1] > ... > arr[arr.length - 1]
给你由整数组成的山脉数组arr，返回任何满足arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1]的下标i。

示例1：
输入：arr = [0, 1, 0]
输出：1

示例2：
输入：arr = [0, 2, 1, 0]
输出：1

示例3：
输入：arr = [0, 10, 5, 2]
输出：1

示例4：
输入：arr = [3, 4, 5, 1]
输出：2

示例5：
输入：arr = [24, 69, 100, 99, 79, 78, 67, 36, 26, 19]
输出：2

提示：
3 <= arr.length <= 10^4
0 <= arr[i] <= 10^6
题目数据保证arr是一个山脉数组
*/