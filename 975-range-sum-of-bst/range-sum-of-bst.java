class Solution {
    int sum=0;
    public void traverse(TreeNode root, int low, int high){
        if(root==null) return;
        rangeSumBST(root.left, low,high);
        if(root.val >= low && root.val <=high ) sum+=root.val;
        rangeSumBST(root.right, low, high);
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        traverse(root,low,high);
        return sum;
    }
}