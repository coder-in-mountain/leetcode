public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> posQueue = new LinkedList<>();
        addNode(queue, posQueue, root, 0);

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                int pos = posQueue.poll();
                map.computeIfAbsent(pos, key -> new ArrayList<>()).add(node.val);
                addNode(queue, posQueue, node.left, pos-1);
                addNode(queue, posQueue, node.right, pos+1);
            }
        }
        return new ArrayList<>(map.values());
    }

    void addNode(Queue<TreeNode> queue, Queue<Integer> posQueue, TreeNode node, int pos) {
        if (node != null) {
            queue.offer(node);
            posQueue.offer(pos);
        }
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}