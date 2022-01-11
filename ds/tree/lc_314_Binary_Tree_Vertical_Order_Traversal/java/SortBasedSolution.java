import java.util.*;
import java.util.stream.*;
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // a sorted map keeps columnId and its node list
        TreeMap<Integer, List<Node>> map = new TreeMap<>();
        dfs(root, 0, 0, map);

        List<List<Integer>> res = new ArrayList<>();
        for (Integer columnId : map.keySet()) {
            res.add(map.get(columnId).stream().sorted().map(Node::getVal).collect(Collectors.toList()));
        }
        return res;
    }

    void dfs(TreeNode node, int rowId, int colId, TreeMap<Integer, List<Node>> map) {
        if (node == null) return;
        map.computeIfAbsent(colId, key -> new ArrayList<Node>()).add(new Node(node.val, rowId));
        dfs(node.left, rowId+1, colId-1, map);
        dfs(node.right, rowId+1, colId+1, map);
    }
}
class Node implements Comparable<Node> {
    int val;
    int rowId;

    public Node(int val, int rowId) {
        this.val = val;
        this.rowId = rowId;
    }

    public int getVal() {
        return this.val;
    }

    public int getRowId() {
        return this.rowId;
    }

    public int compareTo(Node other) {
        return this.rowId - other.rowId;
    }
}