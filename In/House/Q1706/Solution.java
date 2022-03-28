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
