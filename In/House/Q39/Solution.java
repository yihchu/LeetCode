package In.House.Q39;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    // bfs
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int len = candidates.length;
        for (int i = 0; i < len; ++i) {
            if (candidates[i] == target) {
                result.add(new Node(candidates[i], i).list);
                continue;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(candidates[i], i));
            Queue<Node> tmp = new LinkedList<>();
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                for (int j = node.idx; j < len; ++j) {
                    Node cur = new Node(node);
                    cur.add(candidates[j], j);
                    if (cur.sum == target) {
                        result.add(cur.list);
                    } else if (cur.sum < target) {
                        tmp.add(cur);
                    }
                }
                if (queue.isEmpty()) {
                    queue = tmp;
                }
            }
        }
        return result;
    }

//    // dfs
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> combine = new ArrayList<>();
//        dfs(candidates, target, result, combine, 0);
//        return result;
//    }
//
//    private void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> combine, int idx) {
//        if (idx == candidates.length) {
//            return;
//        }
//        if (target == 0) {
//            result.add(new ArrayList<>(combine));
////            result.add(combine);
//            return ;
//        }
//        dfs(candidates, target, result, combine, idx + 1);
//        if (target - candidates[idx] >= 0) {
//            combine.add(candidates[idx]);
//            dfs(candidates, target - candidates[idx], result, combine, idx);
//            combine.remove(combine.size() - 1);
//        }
//    }

    private static void print(List<List<Integer>> arrs) {
        System.out.println(">>>>>>>>>>");
        for (List<Integer> arr: arrs) {
            for (int a: arr) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
        System.out.println("<<<<<<<<<<");
        System.out.println();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        print(slt.combinationSum(new int[] {2, 3, 6, 7}, 7)); // [[2, 2, 3], [7]]
        print(slt.combinationSum(new int[] {2, 3, 5}, 8)); // [[2, 2, 2, 2], [2, 3, 3], [3, 5]]
        print(slt.combinationSum(new int[] {2, 3}, 8)); // [[2, 2, 2, 2], [2, 3, 3], [3, 5]]
        print(slt.combinationSum(new int[] {2}, 1)); // []
    }

}

class Node {
    public List<Integer> list;
    public int sum;
    public int idx;

    public Node(int k, int i) {
        this.list = new ArrayList<>();
        this.sum = 0;
        this.idx = 0;
        add(k, i);
    }

    public Node(Node node) {
        this.list = new ArrayList<>(node.list);
        this.sum = node.sum;
        this.idx = node.idx;
    }

    public void add(int k, int i) {
        this.list.add(k);
        this.sum += k;
        this.idx = i;
    }
}

