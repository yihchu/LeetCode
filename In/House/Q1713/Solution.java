package In.House.Q1713;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {


//    // 超时了
//    public int minOperations(int[] target, int[] arr) {
//        int len = target.length;
//        Map<Integer, Integer> map = new HashMap<>(){{
//            for (int i = 0; i < len; ++i) {
//                put(target[i], i);
//            }
//        }};
//        arr = Arrays.stream(arr).filter(a -> map.keySet().contains(a)).map(a -> map.get(a)).toArray();
//        int size = arr.length;
//        if (size == 0) {
//            return len;
//        }
//        int[] result = new int[size];
//        Arrays.fill(result, 1);
//        int max = 1;
//        for (int i = 1; i < size; ++i) {
//            for (int j = i - 1;j >= 0; --j) {
//                result[i] = arr[i] > arr[j] && result[i] < result[j] + 1 ? result[j] + 1 : result[i];
//            }
//            max = max < result[i] ? result[i] : max;
//        }
//        return len - max;
//    }


    public int minOperations(int[] target, int[] arr) {
        int len = target.length;
        Map<Integer, Integer> map = new HashMap<>(){{
            for (int i = 0; i < len; ++i) {
                put(target[i], i);
            }
        }};
        arr = Arrays.stream(arr).filter(a -> map.keySet().contains(a)).map(a -> map.get(a)).toArray();
        int size = arr.length;
        if (size == 0) {
            return len;
        }

        int idx = 1;
        int[] d = new int[size + 1];
        d[idx] = arr[0];
        for (int i = 1; i < size; ++i) {
            if (arr[i] > d[idx]) {
                d[++idx] = arr[i];
            } else {
                int l = 1, r = idx, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < arr[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = arr[i];
            }
        }
        return len - idx;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.minOperations(new int[]{5, 1, 3}, new int[]{9, 4, 2, 3, 4})); // 2
        System.out.println(slt.minOperations(new int[]{6, 4, 8, 1, 3, 2}, new int[]{4, 7, 6, 2, 3, 8, 6, 1})); // 3
        System.out.println(slt.minOperations(new int[]{16, 7, 20, 11, 15, 13, 10, 14, 6, 8}, new int[]{11, 14, 15, 7, 5, 5, 6, 10, 11, 6})); // 6
        System.out.println(slt.minOperations(new int[]{1, 3, 8}, new int[]{2, 6})); // 3
    }

}


/**
Ques: 得到子序列的最少操作次数
Link: https://leetcode-cn.com/problems/minimum-operations-to-make-a-subsequence/

给你一个数组target，包含若干互不相同的整数，以及另一个整数数组arr，arr可能包含重复元素。
每一次操作中，你可以在arr的任意位置插入任一整数。比方说，如果arr = [1, 4, 1, 2]，那么你可以在中间添加3得到[1, 4, 3, 1, 2]。你可以在数组最开始或最后面添加整数。
请你返回 最少操作次数，使得target成为arr的一个子序列。
一个数组的子序列指的是删除原数组的某些元素（可能一个元素都不删除），同时不改变其余元素的相对顺序得到的数组。比方说，[2, 7, 4]是[4, 2, 3, 7, 2, 1, 4]的子序列（加粗元素），但[2, 4, 2]不是子序列。

示例 1：
输入：target = [5, 1, 3], arr = [9, 4, 2, 3, 4]
输出：2
解释：你可以添加5和1，使得arr变为[5, 9, 4, 1, 2, 3, 4]，target为arr的子序列。

示例 2：
输入：target = [6, 4, 8, 1, 3, 2], arr = [4, 7, 6, 2, 3, 8, 6, 1]
输出：3

提示：
1 <= target.length, arr.length <= 10^5
1 <= target[i], arr[i] <= 10^9
target不包含任何重复元素。

*/