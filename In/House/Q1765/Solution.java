package In.House.Q1765;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {

    private final int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(result[i], -1);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (isWater[i][j] == 1) {
                    result[i][j] = 0;
                    queue.add(new int[] {i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int[] d: this.directions) {
                int x = p[0] + d[0], y = p[1] + d[1];
                if (0 <= x && x < m && 0 <= y && y < n && result[x][y] < 0) {
                    result[x][y] = result[p[0]][p[1]] + 1;
                    queue.offer(new int[] {x, y});
                }
            }
        }
        return result;
    }

    private static void print(int[][] arrs) {
        for (int[] arr: arrs) {
            for (int a: arr) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        print(slt.highestPeak(new int[][]{{0, 1}, {0, 0}})); // [[1, 0], [2, 1]]
        print(slt.highestPeak(new int[][]{{0, 0, 1}, {1, 0, 0}, {0, 0, 0}})); // [[1, 1, 0], [0, 1, 1], [1, 2, 2]]
    }

}

