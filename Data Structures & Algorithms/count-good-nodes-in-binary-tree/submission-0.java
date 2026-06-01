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
        int res = 0;
        Map<TreeNode, Integer> maxSoFar = new HashMap<>();
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        maxSoFar.put(root, root.val);
        res++;
        while(!bfs.isEmpty()) {
            TreeNode curr = bfs.poll();
            if(curr.left != null) {
                bfs.add(curr.left);
                if(curr.left.val < maxSoFar.get(curr)) {
                    maxSoFar.put(curr.left, maxSoFar.get(curr));
                } else {
                    res++;
                    maxSoFar.put(curr.left, curr.left.val);
                }
            }
            if(curr.right != null) {
                bfs.add(curr.right);
                if(curr.right.val < maxSoFar.get(curr)) {
                    maxSoFar.put(curr.right, maxSoFar.get(curr));
                } else {
                    res++;
                    maxSoFar.put(curr.right, curr.right.val);
                }
            }
        }
        return res;
    }
}
