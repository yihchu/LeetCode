package In.House.Q1734;

import java.util.Arrays;

public class Solution {

    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int[] perm = new int[n];
        int sum = 0;
        for (int i = 1; i <= n; ++i) {
            sum ^= i;
        }
        int last = sum;
        for (int i = 0; i < n - 1; i += 2) {
            last ^= encoded[i];
        }
        perm[n - 1] = last;
        for (int i = n - 2; i > -1; --i) {
            perm[i] = perm[i + 1] ^ encoded[i];
        }
        return perm;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        Arrays.stream(slt.decode(new int[]{3, 1})).forEach(k -> System.out.print(k + " "));
        System.out.println();
        Arrays.stream(slt.decode(new int[]{6, 5, 4, 6})).forEach(k -> System.out.print(k + " "));
        System.out.println();
    }

}

/**
Ques: 解码异或后的排列
Link: https://leetcode-cn.com/problems/decode-xored-permutation/

给你一个整数数组perm，它是前n个正整数的排列，且n是个奇数。
它被加密成另一个长度为n - 1的整数数组encoded，满足encoded[i] = perm[i] XOR perm[i + 1]。比方说，如果perm = [1, 3, 2]，那么encoded = [2, 1]。
给你encoded数组，请你返回原始数组perm。题目保证答案存在且唯一。

示例 1：
输入：encoded = [3, 1]
输出：[1, 2, 3]
解释：如果perm = [1, 2, 3]，那么encoded = [1 XOR 2, 2 XOR 3] = [3, 1]

示例 2：
输入：encoded = [6, 5, 4, 6]
输出：[2, 4, 1, 5, 3]

提示：
3 <= n <10^5
n是奇数。
encoded.length == n - 1
*/