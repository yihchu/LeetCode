import common.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class LT437 {

    public int pathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum, targetSum, true);
    }

    private int pathSum(TreeNode root, int target, int left, boolean flag) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int result = 0;
        if (left == root.val) {
            result += 1;
        }
        if (Objects.nonNull(root.left)) {
            result += pathSum(root.left, target, left - root.val, flag);
            if (flag) result += pathSum(root.left, target, target, false);
        }
        if (Objects.nonNull(root.right)) {
            result += pathSum(root.right, target, left - root.val, flag);
            if (flag) result += pathSum(root.right, target, target, false);
        }
        return result;
    }


    private static void test(Integer[] array, int target) {
        int len = array.length;
        if (len == 0) {
            System.out.println(new LT437().pathSum(null, target)); // 0
            return;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> q = new LinkedList<>() {{add(root);}};
        int idx = 1;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (idx < len) {
                Integer v = array[idx ++];
                if (Objects.nonNull(v)) {
                    node.left = new TreeNode(v);
                    q.add(node.left);
                }
            }
            if (idx < len) {
                Integer v = array[idx ++];
                if (Objects.nonNull(v)) {
                    node.right = new TreeNode(v);
                    q.add(node.right);
                }
            }
        }
        System.out.println(new LT437().pathSum(root, target));
    }

    public static void main(String[] args) {
        test(new Integer[0], 1);
        test(new Integer[] {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1}, 8); // 3
        test(new Integer[] {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}, 22); // 3
        test(new Integer[] {1, null, 2, null, 3, null, 4, null, 5}, 3); // 2
        test(new Integer[] {1, -2, -3, 1, 3, -2, null, -1}, -1); // 4
    }

}

/**
Link: https://leetcode-cn.com/problems/path-sum-iii/

给定一个二叉树的根节点root，和一个整数targetSum，求该二叉树里节点值之和等于targetSum的路径的数目。
路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

示例1：
输入：root = [10, 5, -3, 3, 2, null, 11, 3, -2, null, 1], targetSum = 8
输出：3
解释：和等于8的路径有3条，如图所示。

示例2：
输入：root = [5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1], targetSum = 22
输出：3

提示:
二叉树的节点个数的范围是[0, 1000]
-10^9 <= Node.val <= 10^9
-1000 <= targetSum <= 1000
*/