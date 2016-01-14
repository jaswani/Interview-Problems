package leetcode.easy;

/**
 * Created by jai around 9/28/15.
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along
 * the path equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {
    //     Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return findsum(root, sum);
    }

    public boolean findsum(TreeNode root, int sum) {
        if (isLeaf(root)) {
            return (sum - root.val == 0);
        }
        if (root.right != null && findsum(root.right, sum - root.val)) return true;
        if (root.left != null && findsum(root.left, sum - root.val)) return true;
        return false;
    }

    private boolean isLeaf(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }
}
