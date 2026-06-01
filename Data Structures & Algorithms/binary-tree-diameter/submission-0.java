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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int treeLeft = maxHeight(root.left);
        int treeRight = maxHeight(root.right);
        int diameter = treeLeft + treeRight;

        int res = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        res = Math.max(res, diameter);

        return res;
    }

    public int maxHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
    }
}
