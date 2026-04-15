/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class: LRU -- Least Recently Used

    LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
    int get(int key) Return the value of the key if the key exists, otherwise return -1.
    void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.

The functions get and put must each run in O(1) average time complexity.
 */

 /*
 1. HashMap → O(1) lookup
2. Doubly Linked List → O(1) insert/remove

maintain:

Most recently used → front
Least recently used → back

When:

get(key) → move node to front
put(key) → insert/update + move to front
If capacity exceeded → remove tail

 */

 package dsa.LinkedListStackQueue;

import java.util.HashMap;

public class LRUCache {

    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map;

    private Node head; // dummy head
    private Node tail; // dummy tail

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    // 🔥 GET in O(1)
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        moveToFront(node);
        return node.value;
    }

    // 🔥 PUT in O(1)
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToFront(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            addToFront(node);

            if (map.size() > capacity) {
                Node lru = removeLast();
                map.remove(lru.key);
            }
        }
    }

    // ===== helper functions =====

    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToFront(Node node) {
        removeNode(node);
        addToFront(node);
    }

    private Node removeLast() {
        Node lru = tail.prev;
        removeNode(lru);
        return lru;
    }
}