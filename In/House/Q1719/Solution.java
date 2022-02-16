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

/**
Ques: 重构一棵树的方案数
Link: https://leetcode-cn.com/problems/number-of-ways-to-reconstruct-a-tree/

给你一个数组pairs，其中pairs[i] = [x[i], y[i]]，并且满足：
pairs中没有重复元素
x[i] < y[i]
令ways为满足下面条件的有根树的方案数：
树所包含的所有节点值都在pairs中。
一个数对[x[i], y[i]]出现在pairs中当且仅当x[i]是y[i]的祖先或者y[i]是x[i]的祖先。

注意：构造出来的树不一定是二叉树。
两棵树被视为不同的方案当存在至少一个节点在两棵树中有不同的父节点。

请你返回：
如果ways == 0，返回0。
如果ways == 1，返回1。
如果ways > 1，返回2。
一棵有根树指的是只有一个根节点的树，所有边都是从根往外的方向。
我们称从根到一个节点路径上的任意一个节点（除去节点本身）都是该节点的祖先。根节点没有祖先。

示例1(图1.png)：
输入：pairs = [[1, 2], [2, 3]]
输出：1
解释：如上图所示，有且只有一个符合规定的有根树。

示例2(图2.png)：
输入：pairs = [[1, 2], [2, 3], [1, 3]]
输出：2
解释：有多个符合规定的有根树，其中三个如上图所示。

示例3：
输入：pairs = [[1, 2], [2, 3], [2, 4], [1, 5]]
输出：0
解释：没有符合规定的有根树。
(补充解释：
乍一看题，会认为这个例子如果以1为根节点，2，5为其子节点，3，4为2的子节点的话是可以构造出一棵树的。
但是条件中有一句话："一个数对[x[i], y[i]]出现在pairs中当且仅当x[i]是y[i]的祖先或者y[i]是x[i]的祖先。"
这个祖先，并不是只直接祖先，也就是说以上述方式沟造出来的树，1也是3和4的祖先。
那么就要求[1, 3]或者[3, 1]，[1, 4]或者[4, 1]也要存在于pairs当中才可。)

提示：
1 <= pairs.length <= 10^5
1 <= x[i] < y[i] <= 500
pairs中的元素互不相同。

*/