package Sword.to.Offer.V1.Q40;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < arr.length; ++i) {
            if (q.size() < k) {
                q.add(arr[i]);
            } else if (q.size() == k && q.peek() > arr[i]) {
                q.poll();
                q.add(arr[i]);
            }
        }
        return q.stream().mapToInt(a -> a).toArray();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
//        Arrays.stream(slt.getLeastNumbers(new int[]{3, 2, 1}, 2)).forEach(a -> System.out.print(a + " ")); // [1, 2]
//        System.out.println();
//        Arrays.stream(slt.getLeastNumbers(new int[]{0, 1, 2, 1}, 1)).forEach(a -> System.out.print(a)); // [0]
//        System.out.println();
        Arrays.stream(slt.getLeastNumbers(new int[]{0, 0, 0, 2, 0, 5}, 0)).forEach(a -> System.out.print(a)); // [0]
        System.out.println();
    }
}

/**
Ques: 最小的k个数
Link: https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/

输入整数数组arr，找出其中最小的k个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

示例1：
输入：arr = [3, 2, 1], k = 2
输出：[1, 2]或者[2, 1]

示例2：
输入：arr = [0, 1, 2, 1], k = 1
输出：[0]

限制：
0 <= k <= arr.length <= 10000
0 <= arr[i]<= 10000

*/