public class DFSSolution {
    Map<Node, Node> cache = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (cache.containsKey(node)) return cache.get(node);

        Node clone = new Node(node.val);
        cache.put(node, clone);

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        return clone;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}