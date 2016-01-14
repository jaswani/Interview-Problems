package leetcode.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by jai around 9/28/15.
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {
    //     Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> retVal = new ArrayList<>();
        if (root == null) return retVal;
        Queue<TreeNode> q = new ArrayDeque<>();
        TreeNode last = root;
        TreeNode newLast = null;
        q.add(root);
        List<Integer> l = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode curr = q.remove();
            l.add(curr.val);
            if (curr.left != null) {
                q.add(curr.left);
                newLast = curr.left;
            }
            if (curr.right != null) {
                q.add(curr.right);
                newLast = curr.right;
            }
            if (curr == last) {
                retVal.add(l);
                l = new ArrayList<>();
                last = newLast;
            }
        }

        return retVal;
    }
}
