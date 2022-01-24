public class DFS {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;
    }

    void dfs(TreeNode node, int level, List<Integer> list) {
        if (node == null) return;
        if (level == list.size()) {
            list.add(node.val);
        }
        dfs(node.right, level + 1, list);
        dfs(node.left, level + 1, list);
    }
}