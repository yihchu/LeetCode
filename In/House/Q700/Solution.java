package In.House.Q700;

import java.util.Objects;

public class Solution {

    public TreeNode searchBST(TreeNode root, int val) {
        if (Objects.isNull(root) || root.val == val) {
            return root;
        }
        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        TreeNode result = slt.searchBST(root, 2);
        System.out.println();
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
Link: https://leetcode-cn.com/problems/search-in-a-binary-search-tree/

给定二叉搜索树（BST）的根节点和一个值。你需要在BST中找到节点值等于给定值的节点。返回以该节点为根的子树。如果节点不存在，则返回NULL。

例如，给定二叉搜索树:

        4
       / \
      2   7
     / \
    1   3

和值: 2
你应该返回如下子树:

      2
     / \
    1   3

在上述示例中，如果要找的值是5，但因为没有节点值为5，我们应该返回NULL。
*/