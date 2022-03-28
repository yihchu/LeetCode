package In.House.Q1049;

import java.util.Arrays;

public class Solution {

    public int lastStoneWeightII(int[] stones) {
        int len = stones.length;
        int sum = Arrays.stream(stones).sum();
        int weight = sum / 2;
        int[] m = new int[weight + 1];
        int[] n = new int[weight + 1];
        m[0] = 0;
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j <= weight; ++j) {
                if (j < stones[i]) {
                    n[j] = i > 0 ? m[j] : 0;
                } else {
                    n[j] = i > 0 ? Math.max(m[j], m[j - stones[i]] + stones[i]) : stones[i];
                }
            }
            int[] t = m;
            m = n;
            n = t;
        }
        return sum - 2 * m[weight];
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1})); // 1
        System.out.println(slt.lastStoneWeightII(new int[]{31, 26, 33, 21, 40})); // 5
        System.out.println(slt.lastStoneWeightII(new int[]{1, 2})); // 1
    }
}
