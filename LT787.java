import java.util.*;

public class LT787 {

//    // 迪杰特斯拉算法并不符合要求
//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//        int MAX = 10001;
//        int[] visited = new int[n];
//        int[] parents = new int[n];
//        int[] distances = new int[n];
//        int[][] graph = new int[n][n];
//        int count = 1;
//        for (int i = 0; i < flights.length; ++i) {
//            graph[flights[i][0]][flights[i][1]] = flights[i][2];
//            graph[i][i] = 0;
//        }
//        Arrays.fill(distances, MAX);
//        Arrays.fill(parents, -1);
//        visited[src] = 1;
//
//        for (int i = 0; i < n; ++i) {
//            distances[i] = graph[src][i];
//            parents[i] = i == src ? -1 : src;
//        }
//
//        int current = src;
//        int min = MAX;
//        while (true) {
//            for (int i = 0; i < n; ++i) {
//                if (visited[i] == 1) {
//                    continue;
//                }
//                if (min > distances[i]) {
//                    min = distances[i];
//                    parents[i] = current;
//                    current = i;
//                }
//            }
//            visited[current] = 1;
//            ++count;
//            if (count == n) {
//                break;
//            }
//            for (int i = 0; i < n; ++i) {
//                if (visited[i] == 1) {
//                    continue;
//                }
//                int dis = distances[current] + graph[current][i];
//                if (distances[i] > dis) {
//                    distances[i] = dis;
//                    parents[i] = current;
//                }
//            }
//        }
//        if (parents[dst] < 0) {
//            return -1;
//        }
//        current = dst;
//        count = -1;
//        while (true) {
//            current = parents[current];
//            ++count;
//            if (current == src) {
//                break;
//            }
//        }
//        return count <= k ? distances[dst] : -1;
//    }

//    // 能通过，但是需要优化
//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//        int[][] record = new int[k + 2][n];
//        Arrays.fill(record[0], -1);
//        record[0][src] = 0;
//        for (int i = 1; i < k + 2; ++i) {
//            Arrays.fill(record[i], -1);
//            for (int j = 0; j < flights.length; ++j) {
//                int[] edge = flights[j];
//                if (record[i - 1][edge[0]] < 0) {
//                    record[i][edge[1]] = record[i][edge[1]] < 0 ? record[i - 1][edge[1]] : Math.min(record[i - 1][edge[1]] < 0 ? Integer.MAX_VALUE : record[i - 1][edge[1]], record[i][edge[1]]);
//                    continue;
//                }
//                int tmp = record[i - 1][edge[0]] + edge[2];
//                record[i][edge[1]] = record[i][edge[1]] < 0 || record[i][edge[1]] > tmp ? tmp : record[i][edge[1]];
//                record[i][edge[1]] = record[i - 1][edge[1]] > -1 && record[i - 1][edge[1]] < record[i][edge[1]] ? record[i - 1][edge[1]] : record[i][edge[1]];
//            }
//        }
//        return record[k + 1][dst];
//    }


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] record = new int[n];
        Arrays.fill(record, -1);
        record[src] = 0;
        for (int i = 1; i < k + 2; ++i) {
            int[] tr = Arrays.copyOf(record, n);
            for (int j = 0; j < flights.length; ++j) {
                int[] edge = flights[j];
                if (record[edge[0]] < 0) {
                    continue;
                }
                int tmp = record[edge[0]] + edge[2];
                tr[edge[1]] = tr[edge[1]] < 0 || tr[edge[1]] > tmp ? tmp : tr[edge[1]];
            }
            record = tr;
        }
        return record[dst];
    }

    public static void main(String[] args) {
        LT787 lt787 = new LT787();
        System.out.println(lt787.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1)); // 200
        System.out.println(lt787.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0)); // 500
        System.out.println(lt787.findCheapestPrice(3, new int[][]{{0, 1, 2}, {1, 2, 1}, {2, 0, 10}}, 1, 2, 1)); // 1
        System.out.println(lt787.findCheapestPrice(10,
                new int[][]{{3, 4, 4}, {2, 5, 6}, {4, 7, 10}, {9, 6, 5}, {7, 4, 4}, {6, 2, 10}, {6, 8, 6}, {7, 9, 4}
                , {1, 5, 4}, {1, 0, 4}, {9, 7, 3}, {7, 0, 5}, {6, 5, 8}, {1, 7, 6}, {4, 0, 9}, {5, 9, 1}, {8, 7, 3}
                , {1, 2, 6}, {4, 1, 5}, {5, 2, 4}, {1, 9, 1}, {7, 8, 10}, {0, 4, 2}, {7, 2, 8}}, 6, 0, 7)); // 14
    }
}

/*

有n个城市通过一些航班连接。给你一个数组flights，其中flights[i] = [from[i], to[i], price[i]]，表示该航班都从城市from[i]开始，以价格price[i]抵达to[i]。
现在给定所有的城市和航班，以及出发城市src和目的地dst，你的任务是找到出一条最多经过k站中转的路线，使得从src到dst的价格最便宜，并返回该价格。如果不存在这样的路线，则输出-1。

示例 1：
输入:
n = 3, edges = [[0, 1, 100], [1, 2, 100], [0, 2, 500]]
src = 0, dst = 2, k = 1
输出: 200
解释:
城市航班图如下
(图LT787_1.png)
从城市0到城市2在1站中转以内的最便宜价格是200，如图中红色所示。

示例 2：
输入:
n = 3, edges = [[0, 1, 100], [1, 2, 100], [0, 2, 500]]
src = 0, dst = 2, k = 0
输出: 500
解释:
城市航班图如下
(图LT787_2.png)
从城市0到城市2在0站中转以内的最便宜价格是500，如图中蓝色所示。

提示：
1 <= n <= 100
0 <= flights.length <= (n * (n - 1) / 2)
flights[i].length == 3
0 <= from[i], to[i] < n
from[i] != to[i]
1 <= price[i] <= 10^4
航班没有重复，且不存在自环
0 <= src, dst, k < n
src != dst

*/