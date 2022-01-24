impport java.util.*;
/*
 * LRU requires tracking the freshness of the element in cache.
 * Such order could be implemented as counter or position in a list.
 * A doubly linked list here is used as basic data structure for this purpose.
 * After each visit, the element will be moved to the head.
 */

class LRUCache {
    private Node head, tail;
    private Map<Integer, Node> cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (!cache.containsKey(key)){
            if (cache.size() == capacity) {
                cache.remove(tail.prev.key);
                removeNode(tail.prev);
            }
            Node node = new Node(key, value);
            cache.put(key, node);
            addNode(node);
        }else{
            Node node = cache.get(key);
            node.value = value;
            moveToFront(node);
        }
    }
    // node will always be added to front
    void addNode(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void moveToFront(Node node) {
        removeNode(node);
        addNode(node);
    }

    class Node {
        int key, value;
        Node prev, next;
        public Node() {}
        public Node(int k, int v) {
            key = k; value = v;
        }
    }
}