public class Codec {
    public String serialize(TreeNode root) {
        return rserialize(root, new StringBuilder());
    }

    String rserialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null, ");
        }else{
            sb.append(String.valueOf(root.val) + ", ");
            rserialize(root.left, sb);
            rserialize(root.right, sb);
        }
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        return rdeserialize(data.split(","), 0);
    }

    TreeNode rdeserialize(String[] s, int index) {
        if (s == null || s.length == 0 || index == s.length)
            return null;
        if (s[index].equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(s[index]);
        node.left = rdeserialize(s, index + 1);
        node.right = rdeserialize(s, index + 1);
        return root;
    }



}