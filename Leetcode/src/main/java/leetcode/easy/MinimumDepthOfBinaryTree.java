package leetcode.easy;

/**
 * Created by jai around 9/28/15.
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MinimumDepthOfBinaryTree {
    //     Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (isLeaf(root)) return 1;
        int l = Integer.MAX_VALUE;
        int r = Integer.MAX_VALUE;
        if (root.left != null) l = minDepth(root.left);
        if (root.right != null) r = minDepth(root.right);
        return 1 + min(l, r);
    }

    private int min(int a, int b) {
        return a < b ? a : b;
    }

    private boolean isLeaf(TreeNode root) {
        return (root.left == null && root.right == null);
    }
}
