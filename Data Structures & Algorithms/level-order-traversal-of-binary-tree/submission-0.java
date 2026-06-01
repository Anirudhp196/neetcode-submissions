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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        int levelSize;
        while(!bfs.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            levelSize = bfs.size();
            for(int i = 0; i < levelSize; i++) {
                TreeNode curr = bfs.poll();
                if(curr != null) {
                    level.add(curr.val);
                    if(curr.left != null) {
                        bfs.add(curr.left);
                    }
                    if(curr.right != null) {
                        bfs.add(curr.right);
                    }
                }
            }
            res.add(level);
        }
        return res;
    }
}
