package sword.to.offer;

import javax.sound.midi.Soundbank;

public class LT69 {

    // O(n)
    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        int maxIdx = 1;
        for (int i = 2; i < arr.length - 1; ++i) {
            maxIdx = arr[maxIdx] < arr[i] ? i : maxIdx;
        }
        return maxIdx;
    }

//    // O(n^2)
//    public int peakIndexInMountainArray(int[] arr) {
//
//    }

    public static void main(String[] args) {
        LT69 lt69 = new LT69();
        System.out.println(lt69.peakIndexInMountainArray(new int[] {0, 1, 0})); // 1
        System.out.println(lt69.peakIndexInMountainArray(new int[] {1, 3, 5, 4, 2})); // 2
        System.out.println(lt69.peakIndexInMountainArray(new int[] {0, 10, 5, 2})); // 1
        System.out.println(lt69.peakIndexInMountainArray(new int[] {3, 4, 5, 1})); // 2
        System.out.println(lt69.peakIndexInMountainArray(new int[] {24, 69, 100, 99, 79, 78, 67, 36, 26, 19})); // 2
    }

}


/**
Link: https://leetcode-cn.com/problems/B1IidL/

符合下列属性的数组arr称为山峰数组（山脉数组）：
arr.length >= 3
存在i（0 < i < arr.length - 1）使得：
arr[0] < arr[1] < ... arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
给定由整数组成的山峰数组arr，返回任何满足arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1]的下标i，即山峰顶部。

示例1：
输入：arr = [0, 1, 0]
输出：1

示例2：
输入：arr = [1, 3, 5, 4, 2]
输出：2

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

进阶：很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？

*/