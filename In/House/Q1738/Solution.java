package In.House.Q1738;

import java.util.Arrays;

public class Solution {

    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[] xors = new int[m * n];
        xors[0] = matrix[0][0];
        for (int j = 1; j < n; ++j) {
            xors[j] = xors[j - 1] ^ matrix[0][j];
        }
        for (int i = 1; i < m; ++i) {
            xors[i * n] = xors[(i - 1) * n] ^ matrix[i][0];
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                xors[i * n + j] = xors[(i - 1) * n + j] ^ xors[i * n + j - 1] ^ xors[(i - 1) * n + j - 1] ^ matrix[i][j];
            }
        }
        Arrays.sort(xors);
        return xors[xors.length - k];
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 1)); // 7
        System.out.println(slt.kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 2)); // 5
        System.out.println(slt.kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 3)); // 4
        System.out.println(slt.kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 4)); // 0
    }

}

/**
Ques: 找出第K大的异或坐标值
Link: https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/

给你一个二维矩阵matrix和一个整数k，矩阵大小为m x n由非负整数组成。
矩阵中坐标(a, b)的值可由对所有满足0 <= i <= a < m且0 <= j <= b < n的元素matrix[i][j]（下标从0开始计数）执行异或运算得到。
请你找出matrix的所有坐标中第k大的值（k的值从1开始计数）。

示例1：
输入：matrix = [[5, 2], [1, 6]], k = 1
输出：7
解释：坐标(0, 1)的值是5 XOR 2 = 7，为最大的值。

示例2：
输入：matrix = [[5, 2], [1, 6]], k = 2
输出：5
解释：坐标(0, 0)的值是5 = 5，为第2大的值。

示例3：
输入：matrix = [[5, 2], [1, 6]], k = 3
输出：4
解释：坐标(1, 0)的值是5 XOR 1 = 4，为第3大的值。

示例4：
输入：matrix = [[5, 2], [1, 6]], k = 4
输出：0
解释：坐标(1, 1)的值是5 XOR 2 XOR 1 XOR 6 = 0，为第4大的值。

提示：
m == matrix.length
n == matrix[i].length
1 <= m, n <= 1000
0 <= matrix[i][j] <= 10^6
1 <= k <= m * n
*/
