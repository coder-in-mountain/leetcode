public class Solution {
}

class MaxStack {

    TreeMap<Integer, List<Node>> map; // managing sorting. List is used for managing duplicates.
    DoublyLinkedList dll; //maintaining the order of stack

    public MaxStack() {
        map = new TreeMap<>();
        dll = new DoublyLinkedList();
    }

    public void push(int x) {
        Node node = dll.add(x);
        map.computeIfAbsent(x, (k -> new ArrayList<Node>())).add(node);
    }

    public int pop() {
        int val = dll.pop();
        List<Node> duplicates = map.get(val);
        duplicates.remove(duplicates.size() - 1);
        if (duplicates.isEmpty()) {
            map.remove(val);
        }
        return val;
    }

    public int top() {
        return dll.peek();
    }

    public int peekMax() {
        return map.lastKey();
    }

    public int popMax() {
        int max = peekMax();
        List<Node> duplicates = map.get(max);
        Node toBeRemoved = duplicates.remove(duplicates.size() - 1);
        if (duplicates.isEmpty()) {
            map.remove(max);
        }
        dll.unlink(toBeRemoved);
        return max;
    }
}

class DoublyLinkedList {
    Node head, tail;

    public DoublyLinkedList() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public Node add(int val) {
        Node x = new Node(val);
        x.next = tail;
        x.prev = tail.prev;
        tail.prev.next = x;
        tail.prev = x;
        return x;
    }

    public int pop() {
        return unlink(tail.prev).val;
    }

    public int peek() {
        return tail.prev.val;
    }

    public Node unlink(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }

}

class Node {
    int val;
    Node prev, next;
    public Node(int val) {
        this.val = val;
    }
}