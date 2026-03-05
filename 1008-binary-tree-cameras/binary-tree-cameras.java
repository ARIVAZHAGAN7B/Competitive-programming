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
    private int cameras = 0;
    
    public int minCameraCover(TreeNode root) {
        // If root is not monitored after DFS, we need to place a camera at root
        if (dfs(root) == 0) {
            cameras++;
        }
        return cameras;
    }
    
    // Returns:
    // 0 = needs camera (unmonitored)
    // 1 = has camera
    // 2 = monitored (but no camera)
    private int dfs(TreeNode node) {
        if (node == null) {
            return 2; // null nodes are considered monitored
        }
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        // If either child needs monitoring, place camera here
        if (left == 0 || right == 0) {
            cameras++;
            return 1; // this node now has a camera
        }
        
        // If either child has a camera, this node is monitored
        if (left == 1 || right == 1) {
            return 2; // this node is monitored
        }
        
        // Both children are monitored but have no cameras
        // This node needs to be monitored
        return 0;
    }
}