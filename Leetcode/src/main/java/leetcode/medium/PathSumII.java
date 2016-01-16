package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jai around 10/19/15.
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * return
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class PathSumII {
    //     Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans = new ArrayList<>();
        preorder(root, sum, new ArrayList<Integer>());
        return ans;
    }

    public void preorder(TreeNode root, int s, List<Integer> l) {
        if (root == null) return;
        if (isLeaf(root)) {
            if (s == root.val) {
                l.add(root.val);
                ans.add(new ArrayList<Integer>(l));
                l.remove(l.size() - 1);
            }
            return;
        }
        l.add(root.val);
        if (root.left != null) preorder(root.left, s - root.val, l);
        if (root.right != null) preorder(root.right, s - root.val, l);
        l.remove(l.size() - 1);
    }

    private boolean isLeaf(TreeNode root) {
        return (root.left == null && root.right == null);
    }
}
