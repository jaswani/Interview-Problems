package leetcode.easy;

/**
 * Created by jai around 9/28/15.
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *    1
 *   / \
 *  2   2
 *   \   \
 *   3    3
 */
public class SymmetricTree {
    //     Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        // if(root == null) return true;
        // TreeNode last = root;
        // TreeNode newLast = null;
        // TreeNode fake = new TreeNode(-1);
        // Queue<TreeNode> q = ArrayDeque<>();
        // q.add(root);
        // while(!q.isEmpty()) {
        //     Treenode curr = q.remove();
        //     if(curr != fake) {
        //         q.add(curr.left != null ? curr.left : fake);
        //         q.add(curr.right != null ? curr.right : fake);
        //     }

        // }
        return mirror(root,root);
    }

    // private String inOrder(TreeNode root) {
    //     if(root == null) return "0";
    //     if(isLeaf(root)) return ""+root.val;
    //     return inOrder(root.left) + root.val + inOrder(root.right);
    // }

    // private boolean palindrome(String s) {
    //     int i = 0, j = s.length()-1;
    //     while(i < j) {
    //         if(s.charAt(i++) != s.charAt(j--)) return false;
    //     }
    //     return true;
    // }

    // private boolean isLeaf(TreeNode root) {
    //     return (root.left == null && root.right == null);
    // }

    private boolean mirror(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null && q != null) return false;
        if(p != null && q == null) return false;
        if(p.val != q.val) return false;
        return (mirror(p.left,q.right) && mirror(p.right,q.left));

    }
}
