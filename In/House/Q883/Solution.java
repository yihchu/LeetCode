package In.House.Q883;

import java.util.Arrays;

public class Solution {

    public int projectionArea(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int xy = 0;
        int[] xz = new int[row], yz = new int[col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 0) {
                    continue;
                }
                ++xy;
                xz[i] = Math.max(xz[i], grid[i][j]);
                yz[j] = Math.max(yz[j], grid[i][j]);
            }
        }
        return xy + Arrays.stream(xz).sum() + Arrays.stream(yz).sum();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.projectionArea(new int[][]{{1, 2}, {3, 4}})); // 17
        System.out.println(slt.projectionArea(new int[][]{{2}})); // 5
        System.out.println(slt.projectionArea(new int[][]{{1, 0}, {0, 2}})); // 8
    }

}
