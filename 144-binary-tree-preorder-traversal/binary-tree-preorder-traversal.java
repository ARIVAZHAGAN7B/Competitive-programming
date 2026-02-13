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
    public ArrayList<Integer> preOrder(TreeNode root, ArrayList<Integer> al){
        if(root == null) return new ArrayList<>();
        al.add(root.val);
        preOrder(root.left, al);
        preOrder(root.right, al);
        return al;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
    ArrayList<Integer> al = new ArrayList<>();
       return  preOrder(root,al);
    }
}