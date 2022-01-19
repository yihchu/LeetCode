package In.House.Q563;

import java.util.*;

public class Solution {

    public int findTilt(TreeNode root) {
        List<Integer> tilts = new ArrayList<>();
        doFindTilts(root, tilts);
        return tilts.stream().mapToInt(i -> i).sum();
    }

    private int doFindTilts(TreeNode root, List<Integer> tilts) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int tilt = Math.abs(doFindTilts(root.left, tilts) - doFindTilts(root.right, tilts));
        tilts.add(tilt);
        int sum = root.val + (Objects.isNull(root.left) ? 0 : root.left.val) + (Objects.isNull(root.right) ? 0 : root.right.val);
        root.val = sum;
        return sum;
    }

    private TreeNode toTree(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(array[0]);
        queue.add(root);
        for (int i = 1; i < array.length; ) {
            TreeNode current = queue.poll();
            if (Objects.nonNull(array[i])) {
                TreeNode tmp = new TreeNode(array[i]);
                current.left = tmp;
                queue.add(tmp);
            } else {
                current.left = null;
            }
            ++i;
            if (i >= array.length) {
                continue;
            }
            if (Objects.nonNull(array[i])) {
                TreeNode tmp = new TreeNode(array[i]);
                current.right = tmp;
                queue.add(tmp);
            } else {
                current.right = null;
            }
            ++i;
        }
        return root;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.findTilt(slt.toTree(new Integer[] {1, 2, 3}))); // 1
        System.out.println(slt.findTilt(slt.toTree(new Integer[] {4, 2, 9, 3, 5, null, 7}))); // 15
        System.out.println(slt.findTilt(slt.toTree(new Integer[] {21, 7, 14, 1, 1, 2, 2, 3, 3}))); // 9
        System.out.println(slt.findTilt(slt.toTree(new Integer[] {7, -7, 8, null, null, -3, 6, null, 9, null, null, null, -5}))); // 36
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
Ques: 二叉树的坡度
Link: https://leetcode-cn.com/problems/binary-tree-tilt/

给定一个二叉树，计算整个树的坡度。
一个树的节点的坡度定义即为，该节点左子树的节点之和和右子树节点之和的差的绝对值。如果没有左子树的话，左子树的节点之和为0；没有右子树的话也是一样。空结点的坡度是0。
整个树的坡度就是其所有节点的坡度之和。

示例1：
输入：root = [1, 2, 3]
输出：1
解释：
节点2的坡度：|0 - 0| = 0（没有子节点）
节点3的坡度：|0 - 0| = 0（没有子节点）
节点1的坡度：|2 - 3| = 1（左子树就是左子节点，所以和是 2 ；右子树就是右子节点，所以和是 3 ）
坡度总和：0 + 0 + 1 = 1

示例2:
输入：root = [4, 2, 9, 3, 5, null, 7]
        4
     2     9
   3   5      7
输出：15
解释：
节点3的坡度：|0 - 0| = 0（没有子节点）
节点5的坡度：|0 - 0| = 0（没有子节点）
节点7的坡度：|0 - 0| = 0（没有子节点）
节点2的坡度：|3 - 5| = 2（左子树就是左子节点，所以和是3；右子树就是右子节点，所以和是 5 ）
节点9的坡度：|0 - 7| = 7（没有左子树，所以和是 0 ；右子树正好是右子节点，所以和是 7 ）
节点4的坡度：|(3 + 5 + 2) - (9 + 7)| = |10 - 16| = 6（左子树值为3、5和2，和是10；右子树值为9和7，和是16）
坡度总和：0 + 0 + 0 + 2 + 7 + 6 = 15

示例3：
输入：root = [21, 7, 14, 1, 1, 2, 2, 3, 3]
输出：9
          21
     7          14
   1   1      2    2
  3 3

 0 6 0 3
提示：
树中节点数目的范围在[0, 10^4]内
-1000 <= Node.val <= 1000


 7, -7, 8, null, null, -3, 6, null, 9, null, null, null, -5
             7
      -7              8
                -3         6
                   9
                    -5
*/