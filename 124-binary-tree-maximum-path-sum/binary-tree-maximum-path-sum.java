public class Solution {
    private int maxPath;

    public int maxPathSum(TreeNode root) {
        maxPath = Integer.MIN_VALUE;
        maxGain(root);
        return maxPath;
    }

    // Returns the maximum gain from this node if we continue the path upwards
    private int maxGain(TreeNode node) {
        if (node == null) return 0;

        int leftGain = Math.max(0, maxGain(node.left));   // ignore negative sums
        int rightGain = Math.max(0, maxGain(node.right)); // ignore negative sums

        // Path that passes through this node (could be the max)
        int priceNewPath = node.val + leftGain + rightGain;

        // Update global maximum
        maxPath = Math.max(maxPath, priceNewPath);

        // For recursion: return the maximum gain if continuing the path upward
        return node.val + Math.max(leftGain, rightGain);
    }
}