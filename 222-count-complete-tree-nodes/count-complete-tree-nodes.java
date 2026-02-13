class Solution {
    public int count_r(TreeNode root){
        if(root == null){
            return 0;
        }
        return count_r(root.left) + count_r(root.right) + 1;
    }
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}