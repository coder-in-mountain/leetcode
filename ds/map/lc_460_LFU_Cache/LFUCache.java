import java.util.*;

public class LFUCache {
    private int capacity;
    private Map<Integer, Node> cache;
    private TreeMap<Integer, DoublyLinkedList> countMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        countMap = new TreeMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        update(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            update(node);
        }else {
            if (capacity == cache.size()) {
                int leastFrequenceAccessed = countMap.firstKey();
                DoublyLinkedList list = countMap.get(leastFrequenceAccessed);

                Node toBeRemoved = countMap.get(leastFrequenceAccessed).removeFromTail();
                if (list.isEmpty()) {
                    countMap.remove(leastFrequenceAccessed);
                }
                cache.remove(node.key);
            }
            Node node = new Node(key, value);
            cache.put(key, node);
            countMap.computeIfAbsent(node.count, k -> new DoublyLinkedList()).add(node);
        }
    }

    //
    void update(Node node) {
        DoublyLinkedList oldList = countMap.get(node.count);
        oldList.remove(node);
        node.count++;
        countMap.computeIfAbsent(node.count, k -> new DoublyLinkedList()).add(node);
        cache.put(node.key, node);
    }
}
class Node {
    int key, value, count;
    Node prev, next;
    Node() {}
    Node(int k, int v) {
        key = k; value = v; count = 1;
    }
}
class DoublyLinkedList {
    Node head, tail;
    DoublyLinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    // always add node to the front
    void add(Node node) {
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }

    void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    Node removeFromTail() {
        Node node = tail.prev;
        node.prev.next = tail;
        tail.prev = node.prev;
        return node;
    }
}