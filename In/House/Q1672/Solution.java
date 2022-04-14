package In.House.Q1672;

import java.util.Arrays;

public class Solution {

    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for (int[] account: accounts) {
            int tmp = Arrays.stream(account).sum();
            max = max < tmp ? tmp : max;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.maximumWealth(new int[][] {{1, 2, 3}, {3, 2, 1}}));
        System.out.println(slt.maximumWealth(new int[][] {{1, 5}, {7, 3}, {3, 5}}));
    }

}
