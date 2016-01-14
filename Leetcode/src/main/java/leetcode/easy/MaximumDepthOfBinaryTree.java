package leetcode.easy;

/**
 * Created by jai around 9/28/15.
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {
    //     Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + max(maxDepth(root.left), maxDepth(root.right));


    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private boolean isLeaf(TreeNode root) {
        return (root.left == null && root.right == null);
    }
}
