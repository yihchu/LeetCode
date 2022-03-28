package In.House.Q802;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

//    // 超时
//    public List<Integer> eventualSafeNodesV1(int[][] graph) {
//        int n = graph.length;
//        Set<Integer> result = new HashSet<>();
//        int[] visited = new int[n];
//        for (int i = 0; i < n; ++i) {
//            visited[i] = 1;
//            if (findPath(graph, result, visited, i)) {
//                result.add(i);
//            }
//            visited[i] = 0;
//        }
//        return result.stream().sorted().collect(Collectors.toList());
//    }
//
//    public boolean findPath(int[][] graph, Set<Integer> result, int[] visited, int start) {
//        int[] ends = graph[start];
//        if (ends.length == 0) {
//            return true;
//        }
//        for (int end: ends) {
//            if (visited[end] > 0) {
//                return false;
//            }
//            visited[end] = 1;
//            if (!result.contains(end) && !findPath(graph, result, visited, end)) {
//                visited[end] = 0;
//                return false;
//            }
//            visited[end] = 0;
//        }
//        return true;
//    }


    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        Set<Integer> result = new HashSet<>();
        int[] visited = new int[n];
        for (int i = 0; i < n; ++i) {
            visited[i] = 1;
            if (result.contains(i) || findPath(graph, result, visited, i)) {
                result.add(i);
            }
            visited[i] = 0;
        }
        return result.stream().sorted().collect(Collectors.toList());
    }

    public boolean findPath(int[][] graph, Set<Integer> result, int[] visited, int start) {
        int[] ends = graph[start];
        if (ends.length == 0) {
            return true;
        }
        for (int end: ends) {
            if (visited[end] > 0) {
                return false;
            }
            visited[end] = 1;
            if (!result.contains(end) && !findPath(graph, result, visited, end)) {
                visited[end] = 0;
                return false;
            }
            result.add(end);
            visited[end] = 0;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution slt = new Solution();
        slt.eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}}).forEach(k -> System.out.print(k + " "));
        System.out.println(); // [2, 4, 5, 6]
        slt.eventualSafeNodes(new int[][]{{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}}).forEach(k -> System.out.print(k + " "));
        System.out.println(); // [4]
    }

}

