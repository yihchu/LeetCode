package In.House.Q1034;

public class Solution {

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        int[][] colors = new int[m][n];
        doColor(grid, colors, row, col, color);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                colors[i][j] = colors[i][j] == 0 ? grid[i][j] : colors[i][j];
            }
        }
        return colors;
    }

    public void doColor(int[][] grid, int[][] colors, int row, int col, int color) {
        colors[row][col] = grid[row][col];
        boolean isBorder = false;
        if (row - 1 > -1 && colors[row - 1][col] == 0 && grid[row - 1][col] == grid[row][col]) { // up
            doColor(grid, colors, row - 1, col, color);
        }
        if (row + 1 < grid.length && colors[row + 1][col] == 0 && grid[row + 1][col] == grid[row][col]) { // down
            doColor(grid, colors, row + 1, col, color);
        }
        if (col - 1 > -1 && colors[row][col - 1] == 0 && grid[row][col - 1] == grid[row][col]) { // left
            doColor(grid, colors, row, col - 1, color);
        }
        if (col + 1 < grid[0].length && colors[row][col + 1] == 0 && grid[row][col + 1] == grid[row][col]) { // right
            doColor(grid, colors, row, col + 1, color);
        }
        if ((row - 1 == -1 || grid[row - 1][col] != grid[row][col])
                || (row + 1 == grid.length || grid[row + 1][col] != grid[row][col])
                || (col - 1 == -1  || grid[row][col - 1] != grid[row][col])
                || (col + 1 == grid[0].length || grid[row][col + 1] != grid[row][col])) {
            isBorder = true;
        }
        if (isBorder) {
            colors[row][col] = color;
        }
    }

    private static void test(int[][] grid, int row, int col, int color) {
        Solution slt = new Solution();
        int[][] colors = slt.colorBorder(grid, row, col, color);
        for (int i = 0; i < colors.length; ++i) {
            for (int j = 0; j < colors[i].length; ++j) {
                System.out.print(colors[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test(new int[][] {
                {1, 1},
                {1, 2}
        }, 0, 0, 3);

        test(new int[][] {
                {1, 2, 2},
                {2, 3, 2}
        }, 0, 1, 3);

        test(new int[][] {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        }, 1, 1, 2);
    }

}

/**
Link: https://leetcode-cn.com/problems/coloring-a-border/

给你一个大小为m x n的整数矩阵grid，表示一个网格。另给你三个整数row、col和color。网格中的每个值表示该位置处的网格块的颜色。
当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一连通分量。
连通分量的边界是指连通分量中的所有与不在分量中的网格块相邻（四个方向上）的所有网格块，或者在网格的边界上（第一行/列或最后一行/列）的所有网格块。
请你使用指定颜色color为所有包含网格块grid[row][col]的连通分量的边界进行着色，并返回最终的网格grid。

（这道题的说明写的是个什么鬼玩意，也不知道是出题的没说明白，还是翻译的是个傻X）

示例1：
输入：grid = [[1, 1], [1, 2]], row = 0, col = 0, color = 3
输出：[[3, 3], [3, 2]]

示例2：
输入：grid = [[1, 2, 2], [2, 3, 2]], row = 0, col = 1, color = 3
输出：[[1, 3, 3], [2, 3, 3]]

示例3：
输入：grid = [[1, 1, 1], [1, 1, 1], [1, 1, 1]], row = 1, col = 1, color = 2
输出：[[2, 2, 2], [2, 1, 2], [2, 2, 2]]

提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 50
1 <= grid[i][j], color <= 1000
0 <= row < m
0 <= col < n

*/