class Solution {
    public ArrayList<Integer> preOrder(TreeNode root, ArrayList<Integer> al){
        if(root == null) return new ArrayList<>();
        preOrder(root.left, al);
        preOrder(root.right, al);
        al.add(root.val);
        return al;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();
        return preOrder(root, al);
    }
}