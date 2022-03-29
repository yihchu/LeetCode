package In.House.Q688;

public class Solution {

    /**
     * 最近老是看不懂题，我感觉就是翻译的问题
     * 什么叫"每次移动在基本方向上是两个单元格，然后在正交方向上是一个单元格"
     * 其实说的意思是，先在水平或垂直的方向上移动两个单元格，然后再在与移动方向垂直的方向上再移动一个单元格，也就是L型行进
     * 翻译误人子弟啊
     */
    private static int[][] dirs = new int[][] {
            {-2, -1}, {-2, 1}, {2, -1}, {2, 1},
            {-1, -2}, {-1, 2}, {1, -2}, {1, 2}
    };
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n][n];
        for (int step = 0; step <= k; ++step) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (step == 0) {
                        dp[step][i][j] = 1;
                        continue;
                    }
                    for (int[] dir: dirs) {
                        int x = i + dir[0], y = j + dir[1];
                        if (x >= 0 && x < n && y >= 0 && y < n) {
                            dp[step][i][j] += dp[step - 1][x][y] / 8;
                        }
                    }
                }
            }
        }
        return dp[k][row][column];
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.knightProbability(3, 2, 0, 0)); // 0.0625
        System.out.println(slt.knightProbability(1, 0, 0, 0)); // 1.00000
    }

}
