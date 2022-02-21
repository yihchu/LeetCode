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

/**
Ques: 组合总和
Link: https://leetcode-cn.com/problems/combination-sum/

给你一个无重复元素的整数数组candidates和一个目标整数target，找出candidates中可以使数字和为目标数target的所有不同组合，并以列表形式返回。你可以按任意顺序返回这些组合。
candidates中的同一个数字可以无限制重复被选取。如果至少一个数字的被选数量不同，则两种组合是不同的。
对于给定的输入，保证和为target的不同组合数少于150个。

示例1：
输入：candidates = [2, 3, 6, 7], target = 7
输出：[[2, 2, 3], [7]]
解释：
2和3可以形成一组候选，2 + 2 + 3 = 7。注意2可以使用多次。
7也是一个候选，7 = 7。
仅有这两种组合。

示例2：
输入: candidates = [2, 3, 5], target = 8
输出: [[2, 2, 2, 2], [2, 3, 3], [3, 5]]

示例 3：
输入: candidates = [2], target = 1
输出: []

提示：
1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate中的每个元素都互不相同
1 <= target <= 500

*/