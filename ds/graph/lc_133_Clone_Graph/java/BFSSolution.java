public class BFSSolution {

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> cache = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        cache.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            Node clone = cache.get(n);
            for (Node neighbor : n.neighbors) {
                if (!cache.containsKey(neighbor)) {
                    cache.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                clone.neighbors.add(cache.get(neighbor));
            }
        }
        return cache.get(node);
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