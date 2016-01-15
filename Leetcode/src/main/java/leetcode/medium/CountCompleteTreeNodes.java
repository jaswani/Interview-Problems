package leetcode.medium;

/**
 * Created by jai around 10/5/15.
 * Given a complete binary tree, count the number of nodes.
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last
 * level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 */
public class CountCompleteTreeNodes {
    //     Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int countNodes(TreeNode root) {
        int d = depth(root);
        int low = 1;
        for (int i = 0; i < d - 1; i++) low <<= 1;
        int high = (low << 1) - 1;
        return binSearch(low, high, root);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return 1 + depth(root.left);
    }

    private String path(int pos) {
        StringBuilder st = new StringBuilder();
        while (pos > 1) {
            if (pos % 2 == 0) st.append('l');
            else st.append('r');
            pos /= 2;
        }
        return st.reverse().toString();
    }

    private boolean exists(String path, TreeNode root) {
        for (int i = 0; i < path.length(); i++) {
            if (root == null) return false;
            if (path.charAt(i) == 'l') root = root.left;
            else root = root.right;
        }
        return root != null;
    }

    private boolean exists(int bit, int pos, TreeNode root) {
        bit >>= 1;
        while (bit > 0) {
            if ((pos & bit) == bit) root = root.right;
            else root = root.left;
            bit >>= 1;
        }
        return root != null;
    }

    private int binSearch(int low, int high, TreeNode root) {
        int bit = low;
        while (low < high) {
            int mid = (low + high) / 2;
            // String mpath = path(mid);
            if (exists(bit, mid, root)) low = mid + 1;
            else high = mid - 1;
        }
        if (exists(bit, low, root)) return low;
        else return low - 1;
    }
}
