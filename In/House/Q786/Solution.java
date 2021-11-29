package In.House.Q786;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        Map<Double, int[]> map = new HashMap<>();
        PriorityQueue<Double> queue = new PriorityQueue<>((d1, d2) -> Double.compare(d2, d1));
        int len = arr.length;
        Double maxKey = Double.MIN_VALUE;
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                Double key = (double)arr[i] / arr[j];
                if (map.keySet().size() < k) {
                    map.put(key, new int[] {arr[i], arr[j]});
                    queue.add(key);
                    maxKey = maxKey < key ? key : maxKey;
                    continue;
                }
                if (key >= maxKey) {
                    continue;
                }
                map.remove(maxKey);
                queue.remove(maxKey);
                map.put(key, new int[] {arr[i], arr[j]});
                queue.add(key);
                maxKey = queue.peek();
            }
        }
        return map.get(maxKey);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        Arrays.stream(slt.kthSmallestPrimeFraction(new int[] {1, 2, 3, 5}, 3)) // [2, 5]
                .forEach(a -> System.out.print(a + " "));
        System.out.println();
        Arrays.stream(slt.kthSmallestPrimeFraction(new int[] {1, 7}, 1)) // [1, 7]
                .forEach(a -> System.out.print(a + " "));
        System.out.println();
        Arrays.stream(slt.kthSmallestPrimeFraction(new int[] {1, 29, 47}, 1)) // [1, 47]
                .forEach(a -> System.out.print(a + " "));
        System.out.println();
        Arrays.stream(slt.kthSmallestPrimeFraction(new int[] {1, 2, 11, 37, 83, 89}, 11)) // [11, 37]
                .forEach(a -> System.out.print(a + " "));
        System.out.println();
    }

}

/**
Link: https://leetcode-cn.com/problems/k-th-smallest-prime-fraction/

给你一个按递增顺序排序的数组arr和一个整数k。数组arr由1和若干素数组成，且其中所有整数互不相同。
对于每对满足0 < i < j < arr.length的i和j，可以得到分数arr[i] / arr[j] 。
那么第k个最小的分数是多少呢?以长度为2的整数数组返回你的答案, 这里answer[0] == arr[i]且answer[1] == arr[j] 。

示例1：
输入：arr = [1, 2, 3, 5], k = 3
输出：[2, 5]
解释：已构造好的分数,排序后如下所示:
1/5, 1/3, 2/5, 1/2, 3/5, 2/3
很明显第三个最小的分数是2/5

示例2：
输入：arr = [1, 7], k = 1
输出：[1, 7]

提示：
2 <= arr.length <= 1000
1 <= arr[i] <= 3 * 10^4
arr[0] == 1
arr[i]是一个素数，i > 0
arr中的所有数字互不相同，且按严格递增排序
1 <= k <= arr.length * (arr.length - 1) / 2
*/
