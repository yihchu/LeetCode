package In.House.Q1719;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    // CV大法
    public int checkWays(int[][] pairs) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] pair: pairs) {
            adj.putIfAbsent(pair[0], new HashSet<>());
            adj.putIfAbsent(pair[1], new HashSet<>());
            adj.get(pair[0]).add(pair[1]);
            adj.get(pair[1]).add(pair[0]);
        }
        // 找根节点，根节点必须和其他所有数字都能构成[祖先-后代]数对
        int root = -1;
        Set<Map.Entry<Integer, Set<Integer>>> entries = adj.entrySet();
        for (Map.Entry<Integer, Set<Integer>> entry: entries) {
            int node = entry.getKey();
            Set<Integer> neighbours = entry.getValue();
            if (neighbours.size() == adj.size() - 1) {
                root = node;
            }
        }
        if (root == -1) {
            return 0;
        }

        int result = 1;
        for (Map.Entry<Integer, Set<Integer>> entry: entries) {
            int node = entry.getKey();
            Set<Integer> neighbours = entry.getValue();
            if (node == root) {
                continue;
            }
            int currDegree = neighbours.size();
            int parent = -1;
            int parentDegree = Integer.MAX_VALUE;

            for (int neighbour: neighbours) {
                if (adj.get(neighbour).size() < parentDegree && adj.get(neighbour).size() >= currDegree) {
                    parent = neighbour;
                    parentDegree = adj.get(neighbour).size();
                }
            }
            if (parent == -1) {
                return 0;
            }
            for (int neighbour: neighbours) {
                if (neighbour == parent) {
                    continue;
                }
                if (!adj.get(parent).contains(neighbour)) {
                    return 0;
                }
            }
            if (parentDegree == currDegree) {
                result = 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.checkWays(new int[][]{{1, 2}, {2, 3}})); // 1
        System.out.println(slt.checkWays(new int[][]{{1, 2}, {2, 3}, {1, 3}})); // 2
        System.out.println(slt.checkWays(new int[][]{{1, 2}, {2, 3}, {2, 4}, {1, 5}})); // 0
    }

}
