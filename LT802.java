import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LT802 {

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
        LT802 lt802 = new LT802();
        lt802.eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}}).forEach(k -> System.out.print(k + " "));
        System.out.println(); // [2, 4, 5, 6]
        lt802.eventualSafeNodes(new int[][]{{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}}).forEach(k -> System.out.print(k + " "));
        System.out.println(); // [4]
    }

}

/*

在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。
对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是安全的。
返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按升序排列。
该有向图有n个节点，按0到n - 1编号，其中n是graph的节点数。图以下述形式给出：graph[i]是编号j节点的一个列表，满足(i, j)是图的一条有向边。

示例 1：
输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
输出：[2,4,5,6]
解释：示意图如上。

示例 2：
输入：graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
输出：[4]

提示：
n == graph.length
1 <= n <= 10^4
0 <= graph[i].length <= n
graph[i]按严格递增顺序排列。
图中可能包含自环。
图中边的数目在范围[1, 4 * 10^4]内。

*/