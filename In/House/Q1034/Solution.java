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