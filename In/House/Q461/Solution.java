package In.House.Q461;

public class Solution {

    public int hammingDistance(int x, int y) {
        x = x ^ y;
        int c = 0;
        while (x > 0) {
            if ((x & 1) > 0) {
                ++c;
            }
            x >>= 1;
        }
        return c;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.hammingDistance(1, 4));
    }

}


/**
Ques: 汉明距离
Link: https://leetcode-cn.com/problems/hamming-distance/

两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
给出两个整数x和y，计算它们之间的汉明距离。

注意：
0 ≤ x, y < 2^31.

示例:
输入: x = 1, y = 4
输出: 2
解释:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

上面的箭头指出了对应二进制位不同的位置。
 */