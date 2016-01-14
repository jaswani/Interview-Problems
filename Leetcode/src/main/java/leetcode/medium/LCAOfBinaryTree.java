package leetcode.medium;

/**
 * Created by jai around 10/5/15.
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as
 * the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 *
 *       _______3______
 *      /              \
 *   ___5__          ___1__
 *  /      \        /      \
 * 6       _2       0       8
 *        /  \
 *       7   4
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 */
public class LCAOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    TreeNode answer = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        lca(root, p, q);
        return answer;

    }

    private int lca(TreeNode root, TreeNode p , TreeNode q) {
        if (root == null) {
            return 0;
        }
        if (root == p && root == q) {
            answer = root;
            return 2;
        }
        int lfound = lca(root.left, p, q);
        int rfound = lca(root.right, p, q);
        if (lfound == 1 && rfound == 1) {
            answer = root; //lca
            return 2;
        }

        if ((root == p || root == q) && (lfound == 1 || rfound == 1)) {
            answer = root;
            return 2;
        }
        if(root == p || root == q) {
            return 1;
        }
        return lfound + rfound;
    }
}
