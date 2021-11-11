package In.House.Q629;

import java.util.Arrays;

public class Solution {

    // 答案也看了个一知半解，照着抄了一下
    public int kInversePairs(int n, int k) {
        int THRESHOLD = 1000000007;
        int[][] f = new int[n + 1][k + 1];
        int[][] sum = new int[n + 1][k + 1];
        f[1][0] = 1;
        Arrays.fill(sum[1], 1);
        for (int i = 2; i < n + 1; ++i) {
            for (int j = 0; j < k + 1; ++j) {
                f[i][j] = j < i ? sum[i - 1][j] : (sum[i - 1][j] - sum[i - 1][j - (i - 1) - 1] + THRESHOLD) % THRESHOLD;
                sum[i][j] = j == 0 ? f[i][j] : (sum[i][j - 1] + f[i][j]) % THRESHOLD;
            }
        }
        return f[n][k];
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.kInversePairs(3, 0)); // 1
        System.out.println(slt.kInversePairs(3, 1)); // 2
    }

}

/**
Link: https://leetcode-cn.com/problems/k-inverse-pairs-array/

给出两个整数n和k，找出所有包含从1到n的数字，且恰好拥有k个逆序对的不同的数组的个数。
逆序对的定义如下：对于数组的第i个和第j个元素，如果满i<j且a[i]>a[j]，则其为一个逆序对；否则不是。
由于答案可能很大，只需要返回答案(mod 10^9 + 7)的值。

示例1:
输入: n = 3, k = 0
输出: 1
解释:
只有数组[1, 2, 3]包含了从1到3的整数并且正好拥有0个逆序对。

示例2:
输入: n = 3, k = 1
输出: 2
解释:
数组[1, 3, 2]和[2, 1, 3]都有1个逆序对。
说明:
n的范围是[1, 1000]并且k的范围是[0, 1000]。
*/