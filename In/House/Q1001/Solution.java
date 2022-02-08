package In.House.Q1001;

import java.util.*;

public class Solution {

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> xx = new HashMap<>();
        Map<Integer, Integer> yy = new HashMap<>();
        Map<Integer, Integer> dx = new HashMap<>();
        Map<Integer, Integer> dy = new HashMap<>();
        Set<Point> points = new HashSet<>();
        for (int[] lamp: lamps) {
            if (!points.add(Point.of(lamp))) {
                continue;
            }
            xx.put(lamp[1], xx.getOrDefault(lamp[1], 0) + 1);
            yy.put(lamp[0], yy.getOrDefault(lamp[0], 0) + 1);
            dx.put(lamp[0] - lamp[1], dx.getOrDefault(lamp[0] - lamp[1], 0) + 1);
            dy.put(lamp[0] + lamp[1], dy.getOrDefault(lamp[0] + lamp[1], 0) + 1);
        }
        int len = queries.length;
        int[] result = new int[len];
        for (int i = 0; i < len; ++i) {
            int[] query = queries[i];
            result[i] = (xx.containsKey(query[1]) || yy.containsKey(query[0])
                    || dx.containsKey(query[0] - query[1]) || dy.containsKey(query[0] + query[1])) ? 1 : 0;
            for (int x = query[0] - 1; x <= query[0] + 1; ++x) {
                for (int y = query[1] - 1; y <= query[1] + 1; ++y) {
                    if (x < 0 || y < 0 || x >= n || y >= n) {
                        continue;
                    }
                    if (points.remove(Point.of(x, y))) {
                        turnOff(xx, y);
                        turnOff(yy, x);
                        turnOff(dx, x - y);
                        turnOff(dy, x + y);
                    }
                }
            }
        }
        return result;
    }

    private void turnOff(Map<Integer, Integer> map, int key) {
        int v = map.getOrDefault(key, 0);
        if (v <= 1) {
            map.remove(key);
            return;
        }
        map.put(key, v - 1);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        Arrays.stream(slt.gridIllumination(5, new int[][] {{0, 0}, {4, 4}}, new int[][] {{1, 1}, {1, 0}}))
                .forEach(a -> System.out.print(a + " "));
        System.out.println();
        Arrays.stream(slt.gridIllumination(5, new int[][] {{0, 0}, {4, 4}}, new int[][] {{1, 1}, {1, 1}}))
                .forEach(a -> System.out.print(a + " "));
        System.out.println();
        Arrays.stream(slt.gridIllumination(5, new int[][] {{0, 0}, {0, 4}}, new int[][] {{0, 4}, {0, 1}, {1, 4}}))
                .forEach(a -> System.out.print(a + " "));
        System.out.println();
    }

}

class Point {
    int x, y;

    public static Point of(int[] arr) {
        return of(arr[0], arr[1]);
    }

    public static Point of(int x, int y) {
        Point point = new Point();
        point.x = x;
        point.y = y;
        return point;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        Point p = (Point) obj;
        return this.x == p.x && this.y == p.y;
    }

}

/**
Ques: 网格照明
Link: https://leetcode-cn.com/problems/grid-illumination/

在大小为n x n的网格grid上，每个单元格都有一盏灯，最初灯都处于关闭状态。
给你一个由灯的位置组成的二维数组lamps，其中lamps[i] = [row[i], col[i]]表示打开位于grid[row[i]][col[i]]的灯。即便同一盏灯可能在lamps中多次列出，不会影响这盏灯处于打开状态。
当一盏灯处于打开状态，它将会照亮自身所在单元格以及同一行、同一列和两条 对角线上的所有其他单元格。
另给你一个二维数组queries，其中queries[j] = [row[j], col[j]]。对于第j个查询，如果单元格[row[j], col[j]]是被照亮的，则查询结果为1，否则为0。在第j次查询之后[按照查询的顺序]，关闭位于单元格grid[row[j]][col[j]]上及相邻8个方向上（与单元格grid[row[i]][col[i]]共享角或边）的任何灯。
返回一个整数数组ans作为答案，ans[j]应等于第j次查询queries[j]的结果，1表示照亮，0表示未照亮。

示例1(图1.png)：
输入：n = 5, lamps = [[0, 0], [4, 4]], queries = [[1, 1], [1, 0]]
输出：[1, 0]
解释：最初所有灯都是关闭的。在执行查询之前，打开位于[0, 0]和[4, 4]的灯。第0次查询检查 grid[1][1]是否被照亮（蓝色方框）。该单元格被照亮，所以ans[0] = 1 。然后，关闭红色方框中的所有灯(图2.png)。
第1次查询检查grid[1][0]是否被照亮（蓝色方框）。该单元格没有被照亮，所以ans[1] = 0。然后，关闭红色矩形中的所有灯(图3.png)。

示例2：
输入：n = 5, lamps = [[0, 0], [4, 4]], queries = [[1, 1], [1, 1]]
输出：[1, 1]

示例3：
输入：n = 5, lamps = [[0, 0], [0, 4]], queries = [[0, 4], [0, 1], [1, 4]]
输出：[1, 1, 0]

提示：
1 <= n <= 10^9
0 <= lamps.length <= 20000
0 <= queries.length <= 20000
lamps[i].length == 2
0 <= row[i], col[i] < n
queries[j].length == 2
0 <= row[j], col[j] < n

*/

/*
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> xx = new HashMap<>();
        Map<Integer, Integer> yy = new HashMap<>();
        Map<Integer, Integer> dx = new HashMap<>();
        Map<Integer, Integer> dy = new HashMap<>();
        Set<Long> points = new HashSet<>();
        for (int[] lamp: lamps) {
            if (!points.add(hash(lamp[0], lamp[1])))
        }
    }
    private long hash(int x, int y) {
        return (long) x + ((long) y << 32);
    }
 */