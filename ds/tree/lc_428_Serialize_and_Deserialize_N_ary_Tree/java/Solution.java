import java.util.*;
public class Solution {

    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(Node node, StringBuilder sb) {

        appendNode(sb, node);
        if (node != null && node.children.size() > 0) {
            for (var child : node.children)
                serialize(child, sb);
        }

    }
    private void appendNode(StringBuilder sb, Node node) {
        String val = node == null ? "null" : String.valueOf(node.val);
        if (sb.length() > 0) {
            sb.append(" " + val);
        } else {
            sb.append(val);
        }
        if (node != null) {
            sb.append(" " + String.valueOf(node.children.size()));
        }
    }

    public Node deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        return des(new StringTokenizer(data, " "));
    }

    private Node des(StringTokenizer tokens) {
        if (!tokens.hasMoreTokens()) {
            return null;
        }
        String val = tokens.nextToken();
        if (val.equals("null")) {
            return null;
        }
        Node node = new Node(Integer.parseInt(val), new ArrayList<>());
        int n = Integer.parseInt(tokens.nextToken());
        while (n-- > 0) {
            node.children.add(des(tokens));
        }

        return node;
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}