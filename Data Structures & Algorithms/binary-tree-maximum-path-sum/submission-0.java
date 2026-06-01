/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMax(root);
        return res;
    }

    private int getMax(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(0, getMax(node.left));
        int right = Math.max(0, getMax(node.right));

        // Path passing THROUGH this node
        res = Math.max(res, node.val + left + right);

        // Path going UP to parent
        return node.val + Math.max(left, right);
    }
}
