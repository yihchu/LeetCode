package In.House.Q310;


import com.sun.jdi.IntegerType;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

//    // 超时
//    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//        Map<Integer, Set<Integer>> tree = new HashMap<>();
//        Set<Integer> set;
//        for (int[] edge: edges) {
//            set = tree.getOrDefault(edge[0], new HashSet<>());
//            set.add(edge[1]);
//            tree.put(edge[0], set);
//            set = tree.getOrDefault(edge[1], new HashSet<>());
//            set.add(edge[0]);
//            tree.put(edge[1], set);
//        }
//        List<Integer> result = new ArrayList<>();
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < n; ++i) {
//            boolean[] mask = new boolean[n];
//            mask[i] = true;
//            int h = calcHeight(i, tree, mask);
//            if (min < h) {
//                continue;
//            }
//            if (min > h) {
//                min = h;
//                result.clear();
//            }
//            result.add(i);
//        }
//        return result;
//    }
//
//    private int calcHeight(int root, Map<Integer, Set<Integer>> tree, boolean[] mask) {
//        int height = 0;
//        Set<Integer> set = tree.get(root);
//        if (Objects.isNull(set) || set.isEmpty()) {
//            return 1;
//        }
//        for (int k: set) {
//            if (mask[k]) {
//                continue;
//            }
//            mask[k] = true;
//            height = Math.max(height, calcHeight(k, tree, mask));
//            mask[k] = false;
//        }
//        return height + 1;
//    }

//    // CV大法
//    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//        if (n == 1) {
//            return new ArrayList<>() {{ add(0); }};
//        }
//        List<Integer> result = new ArrayList<>();
//        int[] degrees = new int[n];
//        Map<Integer, Set<Integer>> tree = new HashMap<>();
//        Set<Integer> set;
//        for (int[] edge: edges) {
//            set = tree.getOrDefault(edge[0], new HashSet<>());
//            set.add(edge[1]);
//            tree.put(edge[0], set);
//            set = tree.getOrDefault(edge[1], new HashSet<>());
//            set.add(edge[0]);
//            tree.put(edge[1], set);
//            ++ degrees[edge[0]];
//            ++ degrees[edge[1]];
//        }
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < n; ++i) {
//            if (degrees[i] == 1) {
//                queue.add(i);
//            }
//        }
//        int remains = n;
//        while (remains > 2) {
//            int size = queue.size();
//            remains -= size;
//            for (int i = 0; i < size; ++i) {
//                int current = queue.poll();
//                for (int v: tree.get(current)) {
//                    --degrees[v];
//                    if (degrees[v] == 1) {
//                        queue.add(v);
//                    }
//                }
//            }
//        }
//        while (!queue.isEmpty()) {
//            result.add(queue.poll());
//        }
//        return result;
//    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> tree = new HashMap<>();
        Set<Integer> set;
        for (int[] edge: edges) {
            set = tree.getOrDefault(edge[0], new HashSet<>());
            set.add(edge[1]);
            tree.put(edge[0], set);
            set = tree.getOrDefault(edge[1], new HashSet<>());
            set.add(edge[0]);
            tree.put(edge[1], set);
        }
        List<Integer> list = tree.entrySet().stream()
                .filter(node -> node.getValue().size() == 1)
                .map(node -> node.getKey())
                .collect(Collectors.toList());
        while (tree.size() > 2) {
            List<Integer> tmp = new ArrayList<>();
            for (Integer current: list) {
                for (Integer node: tree.get(current)) {
                    tree.get(node).remove(current);
                    if (tree.get(node).size() == 1) {
                        tmp.add(node);
                    }
                }
                tree.remove(current);
            }
            list = tmp;
        }
        return list.isEmpty() ? List.of(0) : list;
    }


    public static void main(String[] args) {
        Solution slt = new Solution();
        slt.findMinHeightTrees(4, new int[][] {{1, 0}, {1, 2}, {1, 3}}).forEach(a -> System.out.print(a + " ")); // [1]
        System.out.println();
        slt.findMinHeightTrees(6, new int[][] {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}).forEach(a -> System.out.print(a + " ")); // [3, 4]
        System.out.println();
        slt.findMinHeightTrees(3, new int[][] {{0, 1}, {0, 2}}).forEach(a -> System.out.print(a + " ")); // [0]
        System.out.println();
        slt.findMinHeightTrees(1, new int[][] {}).forEach(a -> System.out.print(a + " ")); // [0]
        System.out.println();
    }

}
