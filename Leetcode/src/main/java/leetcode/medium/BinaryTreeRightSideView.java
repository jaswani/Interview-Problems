package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jai around 10/12/15.
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see
 * ordered from top to bottom.
 *
 * For example:
 * Given the following binary tree,
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * You should return [1, 3, 4].
 */
public class BinaryTreeRightSideView {
    //     Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traverse(root, 0, ans);
        return ans;
    }

    private int traverse(TreeNode root, int depth, List<Integer> ret) {
        if (root == null) return 0;
        int k = 0;
        if (depth == 0) {
            ret.add(root.val);
        } else {
            depth--;
        }
        int x = traverse(root.right, depth, ret);
        int y = traverse(root.left, Math.max(x, depth), ret);
        return Math.max(x, y) + 1;
    }
}
