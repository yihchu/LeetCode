package In.House.Q629;

import java.util.Arrays;

public class Solution {

    // 答案也看了个一知半解，照着抄了一下
    public int kInversePairs(int n, int k) {
        int THRESHOLD = 1000000007;
        int[][] f = new int[n + 1][k + 1];
        int[][] sum = new int[n + 1][k + 1];
        f[1][0] = 1;
        Arrays.fill(sum[1], 1);
        for (int i = 2; i < n + 1; ++i) {
            for (int j = 0; j < k + 1; ++j) {
                f[i][j] = j < i ? sum[i - 1][j] : (sum[i - 1][j] - sum[i - 1][j - (i - 1) - 1] + THRESHOLD) % THRESHOLD;
                sum[i][j] = j == 0 ? f[i][j] : (sum[i][j - 1] + f[i][j]) % THRESHOLD;
            }
        }
        return f[n][k];
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.kInversePairs(3, 0)); // 1
        System.out.println(slt.kInversePairs(3, 1)); // 2
    }

}

