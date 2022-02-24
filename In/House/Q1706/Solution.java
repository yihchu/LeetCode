package In.House.Q1706;

import java.util.Arrays;

public class Solution {

    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            int row = 0, col = i;
            for (int j = 0; j < m; ++j) {
                boolean flag = false;
                if (grid[row][col] == 1 && col < n - 1 && grid[row][col + 1] == 1) {
                    ++row;
                    ++col;
                    flag = true;
                } else if (grid[row][col] == -1 && col > 0 && grid[row][col - 1] == -1) {
                    ++row;
                    --col;
                    flag = true;
                }
                if (!flag) {
                    arr[i] = -1;
                    break;
                }
                if (row == m) {
                    arr[i] = col;
                    break;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        Arrays.stream(slt.findBall(new int[][]{{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}}))
                .forEach(a -> System.out.print(a + " "));
        System.out.println(); // [1, -1, -1, -1, -1]
        Arrays.stream(slt.findBall(new int[][]{{-1}}))
                .forEach(a -> System.out.print(a + " "));
        System.out.println(); // [-1]
        Arrays.stream(slt.findBall(new int[][]{{1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}, {1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}}))
                .forEach(a -> System.out.print(a + " "));
        System.out.println(); // [0, 1, 2, 3, 4, -1]
    }

}

/**
Ques: 球会落何处
Link: https://leetcode-cn.com/problems/where-will-the-ball-fall/

用一个大小为m x n的二维网格grid表示一个箱子。你有n颗球。箱子的顶部和底部都是开着的。
箱子中的每个单元格都有一个对角线挡板，跨过单元格的两个角，可以将球导向左侧或者右侧。
将球导向右侧的挡板跨过左上角和右下角，在网格中用1表示。
将球导向左侧的挡板跨过右上角和左下角，在网格中用-1表示。
在箱子每一列的顶端各放一颗球。每颗球都可能卡在箱子里或从底部掉出来。如果球恰好卡在两块挡板之间的"V"形图案，或者被一块挡导向到箱子的任意一侧边上，就会卡住。
返回一个大小为n的数组answer，其中answer[i]是球放在顶部的第i列后从底部掉出来的那一列对应的下标，如果球卡在盒子里，则返回-1。

示例1(图1.jpeg)：
输入：grid = [[1, 1, 1, -1, -1], [1, 1, 1, -1, -1], [-1, -1, -1, 1, 1], [1, 1, 1, 1, -1], [-1, -1, -1, -1, -1]]
输出：[1, -1, -1, -1, -1]
解释：
b0球开始放在第0列上，最终从箱子底部第1列掉出。
b1球开始放在第1列上，会卡在第2、3列和第1行之间的"V"形里。
b2球开始放在第2列上，会卡在第2、3列和第0行之间的"V"形里。
b3球开始放在第3列上，会卡在第2、3列和第0行之间的"V"形里。
b4球开始放在第4列上，会卡在第2、3列和第1行之间的"V"形里。

示例2：
输入：grid = [[-1]]
输出：[-1]
解释：球被卡在箱子左侧边上。

示例3：
输入：grid = [[1, 1, 1, 1, 1, 1], [-1, -1, -1, -1, -1, -1], [1, 1, 1, 1, 1, 1], [-1, -1, -1, -1, -1, -1]]
输出：[0, 1, 2, 3, 4, -1]

提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 100
grid[i][j]为1或-1

*/
