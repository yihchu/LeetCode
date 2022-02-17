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

/**
Ques: 骑士在棋盘上的概率
Link: https://leetcode-cn.com/problems/knight-probability-in-chessboard/

在一个n x n的国际象棋棋盘上，一个骑士从单元格(row, column)开始，并尝试进行k次移动。行和列是从0开始的，所以左上单元格是(0, 0)，右下单元格是(n - 1, n - 1)。
象棋骑士有8种可能的走法，如图1.png所示。每次移动在基本方向上是两个单元格，然后在正交方向上是一个单元格。
每次骑士要移动时，它都会随机从8种可能的移动中选择一种(即使棋子会离开棋盘)，然后移动到那里。
骑士继续移动，直到它走了k步或离开了棋盘。
返回骑士在棋盘停止移动后仍留在棋盘上的概率。

示例1：
输入: n = 3, k = 2, row = 0, column = 0
输出: 0.0625
解释: 有两步(到(1,2)，(2,1))可以让骑士留在棋盘上。
在每一个位置上，也有两种移动可以让骑士留在棋盘上。
骑士留在棋盘上的总概率是0.0625。

示例2：
输入: n = 1, k = 0, row = 0, column = 0
输出: 1.00000

提示:
1 <= n <= 25
0 <= k <= 100
0 <= row, column <= n

*/