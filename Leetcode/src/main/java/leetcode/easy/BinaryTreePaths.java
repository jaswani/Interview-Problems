package leetcode.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jai around 9/28/15.
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
 *     1
 *   /   \
 *  2     3
 *   \
 *    5
 *
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 */
public class BinaryTreePaths {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<String> retList;

    public List<String> binaryTreePaths(TreeNode root) {
        retList = new LinkedList<String>();
        if (root != null) {
            preorder(root, "");
        }
        return retList;
    }

    private void preorder(TreeNode root, String s) {
        if (root == null) {
            return;
        }
        if (s.isEmpty()) {
            s += root.val;
        } else {
            s += "->" + root.val;
        }
        if (root.left == null && root.right == null) {
            retList.add(s);
            return;
        }
        preorder(root.left, s);
        preorder(root.right, s);
    }
}
