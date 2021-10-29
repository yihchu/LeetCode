package In.House.Q1720;

public class Solution {

    public int[] decode(int[] encoded, int first) {
        int[] result = new int[encoded.length + 1];
        result[0] = first;
        for (int i = 0; i < encoded.length; ++i) {
            result[i + 1] = encoded[i] ^ result[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        int[] result = slt.decode(new int[]{6,2,7,3}, 4);
        for (int i = 0; i < result.length; ++i) {
            System.out.print(result[i]);
        }
        System.out.println();
        result = slt.decode(new int[]{1, 2, 3}, 1);
        for (int i = 0; i < result.length; ++i) {
            System.out.print(result[i]);
        }
        System.out.println();
    }

}

/**
Link: https://leetcode-cn.com/problems/decode-xored-array/

示例1：
输入：encoded = [1, 2, 3], first = 1
输出：[1, 0, 2, 1]
解释：若 arr = [1, 0, 2, 1]，那么first = 1且encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1, 2, 3]

示例2：
输入：encoded = [6, 2, 7, 3], first = 4
输出：[4, 2, 0, 7, 4]

 */























