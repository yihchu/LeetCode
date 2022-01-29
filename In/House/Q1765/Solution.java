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

/**
Link: https://leetcode-cn.com/problems/map-of-highest-peak/
Ques: 地图中的最高点

给你一个大小为m x n的整数矩阵isWater，它代表了一个由陆地和水域单元格组成的地图。
如果isWater[i][j] == 0，格子(i, j)是一个陆地格子。
如果isWater[i][j] == 1，格子(i, j)是一个水域格子。
你需要按照如下规则给每个单元格安排高度：
每个格子的高度都必须是非负的。
如果一个格子是是水域，那么它的高度必须为0。
任意相邻的格子高度差至多为1。当两个格子在正东、南、西、北方向上相互紧挨着，就称它们为相邻的格子。（也就是说它们有一条公共边）
找到一种安排高度的方案，使得矩阵中的最高高度值最大。
请你返回一个大小为m x n的整数矩阵height，其中height[i][j]是格子(i, j)的高度。如果有多种解法，请返回任意一个。
示例1：
输入：isWater = [[0, 1], [0, 0]]
输出：[[1, 0], [2, 1]]
解释：图1.png展示了给各个格子安排的高度。
蓝色格子是水域格，绿色格子是陆地格。

示例2：
输入：isWater = [[0, 0, 1], [1, 0, 0], [0, 0, 0]]
输出：[[1, 1, 0], [0, 1, 1], [1, 2, 2]]
解释：所有安排方案中，最高可行高度为2。
任意安排方案中，只要最高高度为2且符合上述规则的，都为可行方案。

提示：
m == isWater.length
n == isWater[i].length
1 <= m, n <= 1000
isWater[i][j]要么是0，要么是1。
至少有1个水域格子。

*/