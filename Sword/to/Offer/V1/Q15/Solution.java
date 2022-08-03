package Sword.to.Offer.V1.Q15;

public class Solution {

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
        Solution slt = new Solution();
        System.out.println(slt.hammingWeight(0b00000000000000000000000000001011)); // 3
        System.out.println(slt.hammingWeight(0b00000000000000000000000010000000)); // 1
        System.out.println(slt.hammingWeight(0b11111111111111111111111111111101)); // 31
        System.out.println(slt.hammingWeight(0b11111111111111111111111111111111)); // 32
    }

}

