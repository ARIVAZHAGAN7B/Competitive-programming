class Solution {
    public int sumRootToLeaf(TreeNode root) {
        ArrayList<String> result = new ArrayList<>();
        traversal(root,result,"");
        return change_Binary(result);
    }

    public void traversal(TreeNode root, ArrayList<String> result, String path){
        if(root == null) return;
        
        if(path.isEmpty()){
            path = String.valueOf(root.val);
        }
        else{
            path = path + "" + root.val;
        }

        if(root.left == null && root.right == null){
            result.add(path);
            return;
        }
        traversal(root.left, result, path);
        traversal(root.right, result, path);
    }

    public int change_Binary(ArrayList<String> result){
        int sum=0;
        for(String s:result){
            int temp = Integer.parseInt(s,2);
            sum += temp;
        }
        return sum;
    }
}