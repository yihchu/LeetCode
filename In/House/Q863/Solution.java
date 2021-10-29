package In.House.Q863;


import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, Set<TreeNode>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == target.val) {
                target = node;
            }
            Set<TreeNode> set = map.getOrDefault(node, new HashSet<>());
            if (Objects.nonNull(node.left)) {
                queue.add(node.left);
                set.add(node.left);
                map.put(node, set);
                map.put(node.left, new HashSet<>(){{add(node);}});
            }
            if (Objects.nonNull(node.right)) {
                queue.add(node.right);
                set.add(node.right);
                map.put(node, set);
                map.put(node.right, new HashSet<>(){{add(node);}});
            }
        }
        if (map.keySet().size() < k) {
            return new ArrayList<>();
        }
        Set<TreeNode> blacks = new HashSet<>();
        blacks.add(target);
        Set<TreeNode> set = new HashSet<>();
        set.add(target);
        while (k > 0) {
            Set<TreeNode> tmp = new HashSet<>();
            for (TreeNode node: set) {
                tmp.addAll(map.get(node));
            }
            tmp.removeAll(blacks);
            set = tmp;
            blacks.addAll(set);
            --k;
        }
        return set.stream().map(node -> node.val).collect(Collectors.toList());
    }

    private static TreeNode toTreeNode(int[] array) {
        int len = array.length;
        if (len == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int idx = 1;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (Objects.isNull(node)) {
                continue;
            }
            if (idx < len) {
                node.left = array[idx] < 0 ? null : new TreeNode(array[idx]);
                q.add(node.left);
                ++idx;
            } else {
                break;
            }
            if (idx < len) {
                node.right = array[idx] < 0 ? null : new TreeNode(array[idx]);
                q.add(node.right);
                ++idx;
            } else {
                break;
            }
        }
        q.clear();
        return root;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        slt.distanceK(
                toTreeNode(new int[]{3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4}), new TreeNode(5), 2)
                .forEach(i -> System.out.print(i + " ")); // [7, 4, 1]
        System.out.println();
        slt.distanceK(
                toTreeNode(new int[]{0, -1, 1, -1, 2, -1, 3}), new TreeNode(1), 2)
                .forEach(i -> System.out.print(i + " ")); // [3]
        System.out.println();
        slt.distanceK(
                toTreeNode(new int[]{1}), new TreeNode(1), 3)
                .forEach(i -> System.out.print(i + " ")); //
        System.out.println();
        slt.distanceK(
                toTreeNode(new int[]{0, 1, 3, -1, 2}), new TreeNode(1), 2)
                .forEach(i -> System.out.print(i + " ")); // [3]
        System.out.println();
        slt.distanceK(
                toTreeNode(new int[]{0, 2, 1, -1, -1, 3}), new TreeNode(3), 3)
                .forEach(i -> System.out.print(i + " ")); // [3]
        System.out.println();
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
Link: https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/

给定一个二叉树（具有根结点root），一个目标结点target，和一个整数值K。
返回到目标结点target距离为K的所有结点的值的列表。答案可以以任何顺序返回。

示例1(图1.png)：
输入：root = [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4], target = 5, K = 2
输出：[7, 4, 1]
解释：
所求结点为与目标结点（值为5）距离为2的结点，值分别为7，4，以及1
注意，输入的 "root" 和 "target" 实际上是树上的结点。
上面的输入仅仅是对这些对象进行了序列化描述。

提示：
给定的树是非空的。
树上的每个结点都具有唯一的值0 <= node.val <= 500。
目标结点target是树上的结点。
0 <= K <= 1000.

*/