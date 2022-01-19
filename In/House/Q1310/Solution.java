package In.House.Q1310;

import java.util.Arrays;

public class Solution {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            int sum = 0;
            for (int j = queries[i][0]; j <= queries[i][1]; ++j) {
                sum ^= arr[j];
            }
            result[i] = sum;
        }
        return result;
    }

    // 超出内存限制
    public int[] xorQueriesV2(int[] arr, int[][] queries) {
        int[][] m = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; ++i) {
            for (int j = i; j < arr.length; ++j) {
                if (i == j) {
                    m[i][j] = arr[i];
                    continue;
                }
                m[i][j] = m[i][j - 1] ^ arr[j];
            }
        }
        int[] result = new int[queries.length];
        for (int k = 0; k < queries.length; ++k) {
            result[k] = m[queries[k][0]][queries[k][1]];
        }
        return result;
    }

    public int[] xorQueriesV3(int[] arr, int[][] queries) {
        int[] m = new int[arr.length];
        m[0] = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            m[i] = m[i - 1] ^ arr[i];
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            result[i] = (queries[i][0] > 0 ? m[queries[i][0] - 1] : 0) ^ m[queries[i][1]];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        Arrays.stream(
                slt.xorQueriesV3(new int[]{1, 3, 4, 8},
                        new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{0, 3}, new int[]{3, 3}}))
                .forEach(k -> System.out.print(k + " "));
        System.out.println();
        Arrays.stream(
                slt.xorQueriesV3(new int[]{4, 8, 2, 10},
                        new int[][]{new int[]{2, 3}, new int[]{1, 3}, new int[]{0, 0}, new int[]{0, 3}}))
                .forEach(k -> System.out.print(k + " "));
        System.out.println();
        Arrays.stream(
                slt.xorQueriesV3(new int[]{16},
                        new int[][]{new int[]{0, 0}, new int[]{0, 0}, new int[]{0, 0}}))
                .forEach(k -> System.out.print(k + " "));
        System.out.println();
    }

}

/**
Ques: 子数组异或查询
Link: https://leetcode-cn.com/problems/xor-queries-of-a-subarray/

有一个正整数数组arr，现给你一个对应的查询数组queries，其中queries[i] = [L[i], R[i]]。
对于每个查询i，请你计算从L[i]到R[i]的XOR值（即arr[L[i]] xor arr[L[i]+1] xor ... xor arr[R[i]]）作为本次查询的结果。
并返回一个包含给定查询queries所有结果的数组。

示例1：
输入：arr = [1, 3, 4, 8], queries = [[0, 1], [1, 2], [0, 3], [3, 3]]
输出：[2, 7, 14, 8]
解释：
数组中元素的二进制表示形式是：
1 = 0001
3 = 0011
4 = 0100
8 = 1000
查询的XOR值为：
[0, 1] = 1 xor 3 = 2
[1, 2] = 3 xor 4 = 7
[0, 3] = 1 xor 3 xor 4 xor 8 = 14
[3, 3] = 8

示例2：
输入：arr = [4, 8, 2, 10], queries = [[2, 3], [1, 3], [0, 0], [0, 3]]
输出：[8, 0, 4, 4]

提示：
1 <= arr.length <= 3 * 10^4
1 <= arr[i] <= 10^9
1 <= queries.length <= 3 * 10^4
queries[i].length == 2
0 <= queries[i][0] <= queries[i][1] < arr.length
*/