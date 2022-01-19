package In.House.Q407;

import java.util.PriorityQueue;

public class Solution {

    public int trapRainWater(int[][] heightMap) {
        int row = heightMap.length, col = row > 0 ? heightMap[0].length : 0;
        int result = 0;
        if (row < 3 || col < 3) {
            return result;
        }
        PriorityQueue<Item> queue = new PriorityQueue();
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                visited[i][j] = false;
                if (i == 0 || j == 0 || i == row - 1 || j == col - 1) {
                    queue.add(new Item(i, j, heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }
        int[] dx = new int[] {-1, 0, 1, 0};
        int[] dy = new int[] {0, 1, 0, -1};
        int level = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Item item = queue.poll();
            int h = item.v, r = item.r, c = item.c;
            level = level < h ? h : level;
            for (int i = 0; i < 4; ++i) {
                int x = r + dx[i], y = c + dy[i];
                if (x < 0 || x == row || y < 0 || y == col || visited[x][y]) {
                    continue;
                }
                visited[x][y] = true;
                if (heightMap[x][y] < level) {
                    result += (level - heightMap[x][y]);
                }
                queue.add(new Item(x, y, heightMap[x][y]));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.trapRainWater( // 4
                new int[][] {
                        {1, 4, 3, 1, 3, 2},
                        {3, 2, 1, 3, 2, 4},
                        {2, 3, 3, 2, 3, 1}}));
        System.out.println(slt.trapRainWater( // 10
                new int[][] {
                        {3, 3, 3, 3, 3},
                        {3, 2, 2, 2, 3},
                        {3, 2, 1, 2, 3},
                        {3, 2, 2, 2, 3},
                        {3, 3, 3, 3, 3}}));
    }

}

class Item implements Comparable<Item> {
    int r, c;
    int v;
    public Item(int row, int col, int value) {
        this.r = row;
        this.c = col;
        this.v = value;
    }

    @Override
    public int compareTo(Item o) {
        return this.v - o.v;
    }
}

/*
思路：
此题用BFS来做。
创建一个优先级队列，该队列中是将高度小的放在队首。
先将四周一圈的格子加入队列中，并将这些格子的状态设为已访问过。
下面开始BFS，从队列的头部取出元素，并用其高度更新海平面level。
然后从该格子向四周寻找格子，如果某格子未被访问过，那么将其状态设为已访问过，然后判断如果其高度小于海平面，那么把它们的高度差加到ans中。否则不操作。
接下来将该格子加入到优先级队列中。如此进行，当优先级队列为空时退出循环，返回ans。
*/

/**
Ques: 接雨水II
Link: https://leetcode-cn.com/problems/trapping-rain-water-ii/

给你一个m x n的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。

示例1(图1.jpg):
输入: heightMap = [[1, 4, 3, 1, 3, 2], [3, 2, 1, 3, 2, 4], [2, 3, 3, 2, 3, 1]]
输出: 4
解释: 下雨后，雨水将会被上图蓝色的方块中。总的接雨水量为1 + 2 + 1 = 4。

示例2:
输入: heightMap = [[3, 3, 3, 3, 3], [3, 2, 2, 2, 3], [3, 2, 1, 2, 3], [3, 2, 2, 2, 3], [3, 3, 3, 3, 3]]
输出: 10

提示:
m == heightMap.length
n == heightMap[i].length
1 <= m, n <= 200
0 <= heightMap[i][j] <= 2 * 10^4

*/