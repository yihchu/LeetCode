package In.House.Q653;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Solution {

    public boolean findTarget(TreeNode root, int k) {
        Queue<Integer> queue = new LinkedList();
        dfs(root, queue);
        int[] array = queue.stream().mapToInt(i -> i).toArray();
        int l = 0, r = array.length - 1;
        while (l < r) {
            int sum = array[l] + array[r];
            if (sum == k) {
                return true;
            }
            if (sum < k) {
                ++l;
            } else {
                --r;
            }
        }
        return false;
    }

    private void dfs(TreeNode root, Queue<Integer> queue) {
        if (Objects.nonNull(root.left)) {
            dfs(root.left, queue);
        }
        queue.add(root.val);
        if (Objects.nonNull(root.right)) {
            dfs(root.right, queue);
        }
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.findTarget(toTree(new Integer[] {5, 3, 6, 2, 4, null, 7}), 9));
        System.out.println(slt.findTarget(toTree(new Integer[] {5, 3, 6, 2, 4, null, 7}), 28));
        System.out.println(slt.findTarget(toTree(new Integer[] {1}), 2));
    }

    private static TreeNode toTree(Integer[] arr) {
        int len = arr.length;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new ArrayDeque<>() {{ add(root); }};
        int idx = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (idx == len) {
                break;
            }
            TreeNode lChild = Objects.nonNull(arr[idx]) ? new TreeNode(arr[idx]) : null;
            node.left = lChild;
            if (Objects.nonNull(lChild)) {
                queue.add(lChild);
            }
            ++idx;
            if (idx == len) {
                break;
            }
            TreeNode rChild = Objects.nonNull(arr[idx]) ? new TreeNode(arr[idx]) : null;
            node.right = rChild;
            if (Objects.nonNull(rChild)) {
                queue.add(rChild);
            }
            ++idx;
        }
        return root;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
Ques: 两数之和 IV - 输入 BST
Link: https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/

给定一个二叉搜索树root和一个目标结果k，如果BST中存在两个元素且它们的和等于给定的目标结果，则返回true。

示例1(图1.jpeg)：
输入: root = [5, 3, 6, 2, 4, null, 7], k = 9
输出: true

示例2：
输入: root = [5, 3, 6, 2, 4, null, 7], k = 28
输出: false

提示:
二叉树的节点个数的范围是[1, 10^4].
-10^4 <= Node.val <= 10^4
root为二叉搜索树
-10^5 <= k <= 10^5
*/