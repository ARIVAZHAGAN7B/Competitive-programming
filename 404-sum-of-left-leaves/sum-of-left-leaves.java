class Solution {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        int sum = 0;

        // Check left child
        if (root.left != null) {
            // If left child is leaf
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
        }

        // Always check right subtree
        sum += sumOfLeftLeaves(root.right);

        return sum;
    }
}
