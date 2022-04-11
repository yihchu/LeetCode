package In.House.Q313;

import java.util.Arrays;

public class Solution {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int m = primes.length;
        int[] pointers = new int[m];
        Arrays.fill(pointers, 1);
        for (int i = 2; i <= n; i++) {
            int[] nums = new int[m];
            int minNum = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                nums[j] = dp[pointers[j]] * primes[j];
                minNum = Math.min(minNum, nums[j]);
            }
            dp[i] = minNum;
            for (int j = 0; j < m; j++) {
                if (minNum == nums[j]) {
                    pointers[j]++;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19})); // 32
        System.out.println(slt.nthSuperUglyNumber(1000000, new int[]{2, 7, 13, 19})); // 32
        System.out.println(slt.nthSuperUglyNumber(1, new int[]{2, 3, 5})); // 1
    }

}

