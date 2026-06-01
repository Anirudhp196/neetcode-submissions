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
    public int goodNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return countLarger(root, Integer.MIN_VALUE);
    }

    private int countLarger(TreeNode curr, int max) {
        if(curr == null) {
            return 0;
        }
        if(curr.val >= max) {
            max = curr.val;
            System.out.println(max);
            return 1 + countLarger(curr.left, max) + countLarger(curr.right, max); 
        } else {
            return countLarger(curr.left, max) + countLarger(curr.right, max);
        }
    }
}
