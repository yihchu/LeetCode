package In.House.Q373;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(o -> (o.get(0) + o.get(1))));
        for (int i = 0; i < len1 && i < k; ++i) {
            for (int j = 0; j < len2 && j < k; ++j) {
                int l = nums1[i], r = nums2[j];
                queue.add(new ArrayList<>() {{
                    add(l);
                    add(r);
                }});
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < k && !queue.isEmpty(); ++i) {
            result.add(queue.poll());
        }
        return result;
    }

    private static void print(List<List<Integer>> ll) {
        for (List<Integer> l: ll) {
            System.out.print("<" + l.get(0) + ", " + l.get(1) + "> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        print(slt.kSmallestPairs(new int[] {1, 7, 11}, new int[] {2, 4, 6}, 3));
        print(slt.kSmallestPairs(new int[] {1, 1, 2}, new int[] {1, 2, 3}, 2));
        print(slt.kSmallestPairs(new int[] {1, 2}, new int[] {3}, 3));
    }

}

/**
Link: https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/

给定两个以升序排列的整数数组nums1和nums2, 以及一个整数k。
定义一对值(u, v)，其中第一个元素来自nums1，第二个元素来自nums2。
请找到和最小的k个数对(u1, v1), (u2, v2) ... (uk, vk)。

示例1:
输入: nums1 = [1, 7, 11], nums2 = [2, 4, 6], k = 3
输出: [1, 2], [1, 4], [1, 6]
解释: 返回序列中的前3对数：
     [1, 2], [1, 4], [1, 6], [7, 2], [7, 4], [11, 2], [7, 6], [11, 4], [11, 6]

示例2:
输入: nums1 = [1, 1, 2], nums2 = [1, 2, 3], k = 2
输出: [1, 1], [1, 1]
解释: 返回序列中的前2对数：
    [1, 1], [1, 1], [1, 2], [2, 1], [1, 2], [2, 2], [1, 3], [1, 3], [2, 3]

示例3:
输入: nums1 = [1, 2], nums2 = [3], k = 3
输出: [1, 3], [2, 3]
解释: 也可能序列中所有的数对都被返回: [1, 3], [2, 3]

提示:
1 <= nums1.length, nums2.length <= 10^4
-10^9 <= nums1[i], nums2[i] <= 10^9
nums1, nums2均为升序排列
1 <= k <= 1000

*/
