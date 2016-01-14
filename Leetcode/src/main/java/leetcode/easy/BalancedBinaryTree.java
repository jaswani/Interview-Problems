package leetcode.easy;

/**
 * Created by jai on around 9/28/15.
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of
 * every node never differ by more than 1.
 */
public class BalancedBinaryTree {
    //     Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        depth(root);
        return retVal;
    }

    private boolean retVal = true;

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int l = depth(root.left);
        int r = depth(root.right);
        if (l - r > 1 || r - l > 1) {
            retVal = false;
        }
        return l > r ? 1 + l : 1 + r;
    }
}
