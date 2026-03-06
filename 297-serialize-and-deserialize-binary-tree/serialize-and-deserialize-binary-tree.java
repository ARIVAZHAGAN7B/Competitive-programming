public class Codec {

    // TreeNode definition (reuse if provided elsewhere)
    // public static class TreeNode {
    //     int val;
    //     TreeNode left;
    //     TreeNode right;
    //     TreeNode(int v) { this.val = v; }
    // }

    // Serialize: preorder with a marker for nulls
    // Example format: "1,2,#,#,3,4,#,#,5,#,#,"
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializePreOrder(root, sb);
        return sb.toString();
    }

    private void serializePreOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val).append(',');
        serializePreOrder(node.left, sb);
        serializePreOrder(node.right, sb);
    }

    // Deserialize: reconstruct tree from preorder tokens
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        String[] tokens = data.split(",");
        // If trailing comma exists, split may yield an empty string at the end; handle gracefully
        List<String> list = new ArrayList<>();
        for (String t : tokens) {
            if (!t.isEmpty()) list.add(t);
        }
        int[] idx = new int[]{0};
        return deserializePreOrder(list, idx);
    }

    private TreeNode deserializePreOrder(List<String> tokens, int[] idx) {
        if (idx[0] >= tokens.size()) return null;
        String t = tokens.get(idx[0]++).trim();
        if (t.equals("#")) return null;
        int val = Integer.parseInt(t);
        TreeNode node = new TreeNode(val);
        node.left = deserializePreOrder(tokens, idx);
        node.right = deserializePreOrder(tokens, idx);
        return node;
    }

    // Optional: helper to print tree in-order for quick verification (not required in submission)
    public static void main(String[] args) {
        Codec codec = new Codec();

        // Build sample tree:
        //       1
        //      / \
        //     2   3
        //        / \
        //       4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String s = codec.serialize(root);
        TreeNode d = codec.deserialize(s);

        // Simple check: re-serialize deserialized tree to compare
        System.out.println("Serialized: " + s);
        System.out.println("Re-Serialized after Deserialization: " + codec.serialize(d));
    }
}