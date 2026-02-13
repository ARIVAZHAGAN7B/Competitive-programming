class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> al = new ArrayList<>();
        dfs(root, "", al);
        return al;
    }

    public void dfs(TreeNode root, String path, ArrayList<String> al){
        if(root == null) return;
        if(path.isEmpty()){
            path = String.valueOf(root.val);
        }
        else{
            path = path + "->" + root.val;
        }

        if(root.left == null && root.right == null){
            al.add(path);
            return;
        }

        dfs(root.left, path, al);
        dfs(root.right, path, al);
    }
}