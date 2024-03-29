package In.House.Q847;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

//    // 超时
//    // 怀疑因为是深度遍历，所以需要遍历出几乎所有的可能性，然后选取最小的结果。
//    // 随着节点和边数量的增加，需要的时间呈指数级增长，导致超时
//    public int shortestPathLength(int[][] graph) {
//        int len = graph.length;
//        int[][] map = new int[len][len];
//        for (int i = 0; i < len; ++i) {
//            Arrays.fill(map[i], -1);
//            map[i][i] = 0;
//            int[] edges = graph[i];
//            for (int j = 0; j < edges.length; ++j) {
//                map[i][edges[j]] = 1;
//            }
//        }
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < len; ++ i) {
//            System.out.println(">>>>>>>>>> current = " + i);
//            int[][] visited = new int[len][len];
//            int steps = findPath(graph, visited, 1 << i, 0, i);
//            min = min > steps ? steps : min;
//        }
//        return min;
//    }
//
//    public int findPath(int[][] graph, int[][] visited, int count, int steps, int start) {
//        int len = graph.length;
//        if (count == ((1 << len) - 1)) {
//            return steps;
//        }
//        int[] edges = graph[start];
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < edges.length; ++i) {
//            if (visited[start][edges[i]] > 0) {
//                continue;
//            }
//            visited[start][edges[i]] = 1;
//            int tmp = findPath(graph, visited, count | 1 << edges[i], steps + 1, edges[i]);
//            visited[start][edges[i]] = 0;
//            min = min > tmp ? tmp : min;
//        }
//        return min;
//    }

    public int shortestPathLength(int[][] graph) {
        int len = graph.length;
        int[][] visited = new int[len][1 << len];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < len; ++i) {
            queue.add(new int[]{i, 1 << i, 0});
            visited[i][1 << i] = 1;
        }
        int end = (1 << len) - 1;
        int result = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] tuple = queue.poll();
            int[] nexts = graph[tuple[0]];
            if (tuple[1] == end) {
                result = tuple[2];
                break;
            }
            for (int next: nexts) {
                int tmp = (1 << next) | tuple[1];
                if (visited[next][tmp] > 0) {
                    continue;
                }
                visited[next][tmp] = 1;
                queue.add(new int[]{next, tmp, tuple[2] + 1});
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.shortestPathLength(new int[][]{{1, 2, 3}, {0}, {0}, {0}})); // 4
        System.out.println(slt.shortestPathLength(new int[][]{{1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}})); // 4
        System.out.println(slt.shortestPathLength(new int[][]{{2, 3, 4, 8}, {8}, {0}, {0, 8}, {0, 5, 6}, {4, 7}, {4}, {5}, {0, 3, 1}})); // 10
        System.out.println(slt.shortestPathLength(
                new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, {0, 2, 5, 6, 8}, {0, 1, 4, 5, 6, 9, 10, 11}
                , {0, 4, 5, 6, 8, 9, 10, 11}, {0, 2, 3, 5, 6, 8, 10}, {0, 1, 2, 3, 4, 6, 8, 9, 10, 11}
                , {0, 1, 2, 3, 4, 5, 8, 10, 11}, {0, 8}, {0, 1, 3, 4, 5, 6, 7, 9, 10, 11}, {0, 2, 3, 5, 8, 10}
                , {0, 2, 3, 4, 5, 6, 8, 9}, {0, 2, 3, 5, 6, 8}})); // 11
    }

}

