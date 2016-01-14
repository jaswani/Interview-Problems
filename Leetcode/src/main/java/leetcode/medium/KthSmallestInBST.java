package leetcode.medium;

/**
 * Created by jai around 10/5/15.
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */
public class KthSmallestInBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    
    public int kthSmallest(TreeNode root, int k) {
        rank = k;
        inorder(root);
        return ans.val;
    }
    private int count = 0;
    private int rank = 0;
    private TreeNode ans = null;
    private void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        count++;
        if (count == rank) ans = root;
        inorder(root.right);
    }
}
