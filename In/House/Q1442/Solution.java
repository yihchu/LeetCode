package In.House.Q1442;

public class Solution {

    public int countTriplets(int[] arr) {
        int result = 0;
        if (arr.length == 1) {
            return result;
        }
        int[] m = new int[arr.length];
        m[0] = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            m[i] = m[i - 1] ^ arr[i];
        }
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = 1; j < arr.length; ++j) {
                for (int k = i + 1; k <= j; ++k) {
                    if ( (m[k - 1] ^ (i > 0 ? m[i - 1] : 0)) == (m[j] ^ m[k - 1]) ) {
                        ++result;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.countTriplets(new int[]{2, 3, 1, 6, 7})); // 4
        System.out.println(slt.countTriplets(new int[]{1, 1, 1, 1, 1})); // 10
        System.out.println(slt.countTriplets(new int[]{2, 3})); // 0
        System.out.println(slt.countTriplets(new int[]{1, 3, 5, 7, 9})); // 3
        System.out.println(slt.countTriplets(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22})); // 8
    }

}

/**
Ques: 形成两个异或相等数组的三元组数目
Link: https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/

给你一个整数数组arr。
现需要从数组中取三个下标i、j和k ，其中(0 <= i < j <= k < arr.length)。

a和b定义如下：
a = arr[i] ^ arr[i + 1] ^ ... ^ arr[k - 1]
b = arr[k] ^ arr[k + 1] ^ ... ^ arr[j]
注意：^ 表示按位异或操作。

请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。

示例1：
输入：arr = [2, 3, 1, 6, 7]
输出：4
解释：满足题意的三元组分别是(0, 1, 2), (0, 2, 2), (2, 3, 4)以及(2, 4, 4)

示例2：
输入：arr = [1, 1, 1, 1, 1]
输出：10

示例3：
输入：arr = [2, 3]
输出：0

示例4：
输入：arr = [1, 3, 5, 7, 9]
输出：3

示例5：
输入：arr = [7, 11, 12, 9, 5, 2, 7, 17, 22]
输出：8

提示：
1 <= arr.length <= 300
1 <= arr[i] <= 10^8
 */