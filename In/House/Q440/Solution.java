package In.House.Q440;

public class Solution {

    // CV大法
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k -= cur;
        while (k > 0) {
            int count = calc(cur, n);
            if (count <= k) {
                k -= count;
                ++cur;
            } else {
                --k;
                cur *= 10;
            }
        }
        return cur;
    }

    private int calc(int cur, long n) {
        int count = 0;
        long start = cur, end = cur;
        while (start <= n) {
            count += (Math.min(end, n) - start + 1);
            start *= 10;
            end *= 10;
            end += 9;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.findKthNumber(13, 2)); // 10
        System.out.println(slt.findKthNumber(13, 3)); // 11
        System.out.println(slt.findKthNumber(1, 1)); // 1

    }

}

/**
Ques: 字典序的第K小数字
Link: https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/

给定整数n和k，返回[1, n]中字典序第k小的数字。

示例1:
输入: n = 13, k = 2
输出: 10
解释: 字典序的排列是[1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是10。

示例2:
输入: n = 1, k = 1
输出: 1

提示:
1 <= k <= n <= 10^9
*/