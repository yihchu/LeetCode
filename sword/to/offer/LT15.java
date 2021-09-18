package sword.to.offer;

public class LT15 {

    public int hammingWeight(int n) {
        long k = 1;
        int sum = 0;
        for (int i = 0; i < 32; ++i) {
            if ((n & k) > 0) {
                ++sum;
            }
            k <<= 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        LT15 lt15 = new LT15();
        System.out.println(lt15.hammingWeight(0b00000000000000000000000000001011)); // 3
        System.out.println(lt15.hammingWeight(0b00000000000000000000000010000000)); // 1
        System.out.println(lt15.hammingWeight(0b11111111111111111111111111111101)); // 31
        System.out.println(lt15.hammingWeight(0b11111111111111111111111111111111)); // 32
    }

}

/**
Link: https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/

请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中1的个数。例如，把9表示成二进制是 1001，有2位是1。因此，如果输入9，则该函数输出2。

示例1：
输入：00000000000000000000000000001011
输出：3
解释：输入的二进制串00000000000000000000000000001011中，共有三位为'1'。

示例2：
输入：00000000000000000000000010000000
输出：1
解释：输入的二进制串00000000000000000000000010000000中，共有一位为'1'。

示例3：
输入：11111111111111111111111111111101
输出：31
解释：输入的二进制串11111111111111111111111111111101中，共有31位为'1'。

提示：
输入必须是长度为32的二进制串 。
*/
