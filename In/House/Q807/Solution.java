package In.House.Q807;



public class Solution {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[] rows = new int[row], cols = new int[col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                rows[i] = rows[i] < grid[i][j] ? grid[i][j] : rows[i];
                cols[j] = cols[j] < grid[i][j] ? grid[i][j] : cols[j];
            }
        }
        int sum = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                sum += (Math.min(rows[i], cols[j]) - grid[i][j]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.maxIncreaseKeepingSkyline(new int[][] { // 35
                {3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}
        }));
    }

}
