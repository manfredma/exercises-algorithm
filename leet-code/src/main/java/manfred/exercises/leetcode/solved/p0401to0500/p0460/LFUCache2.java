package manfred.exercises.leetcode.solved.p0401to0500.p0460;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用两个哈希表和按频次分组的双向链表实现的 LFU 缓存。
 */
class LFUCache2 {
    private final int capacity;
    private int minFrequency;
    private final Map<Integer, Node> keyToNode = new HashMap<>();
    private final Map<Integer, DoublyLinkedList> frequencyToList = new HashMap<>();

    public LFUCache2(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = keyToNode.get(key);
        if (node == null) {
            return -1;
        }
        increaseFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        Node node = keyToNode.get(key);
        if (node != null) {
            node.value = value;
            increaseFrequency(node);
            return;
        }

        if (keyToNode.size() == capacity) {
            DoublyLinkedList leastFrequentNodes = frequencyToList.get(minFrequency);
            Node nodeToRemove = leastFrequentNodes.removeFirst();
            keyToNode.remove(nodeToRemove.key);
            if (leastFrequentNodes.isEmpty()) {
                frequencyToList.remove(minFrequency);
            }
        }

        Node newNode = new Node(key, value);
        keyToNode.put(key, newNode);
        frequencyToList.computeIfAbsent(1, ignored -> new DoublyLinkedList()).addLast(newNode);
        minFrequency = 1;
    }

    private void increaseFrequency(Node node) {
        int frequency = node.frequency;
        DoublyLinkedList nodes = frequencyToList.get(frequency);
        nodes.remove(node);
        if (nodes.isEmpty()) {
            frequencyToList.remove(frequency);
            if (minFrequency == frequency) {
                minFrequency++;
            }
        }

        node.frequency++;
        frequencyToList.computeIfAbsent(node.frequency, ignored -> new DoublyLinkedList()).addLast(node);
    }

    private static class Node {
        private final int key;
        private int value;
        private int frequency = 1;
        private Node previous;
        private Node next;

        private Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class DoublyLinkedList {
        private final Node head = new Node(-1, -1);
        private final Node tail = new Node(-1, -1);

        private DoublyLinkedList() {
            head.next = tail;
            tail.previous = head;
        }

        private void addLast(Node node) {
            node.previous = tail.previous;
            node.next = tail;
            tail.previous.next = node;
            tail.previous = node;
        }

        private void remove(Node node) {
            node.previous.next = node.next;
            node.next.previous = node.previous;
            node.previous = null;
            node.next = null;
        }

        private Node removeFirst() {
            Node first = head.next;
            remove(first);
            return first;
        }

        private boolean isEmpty() {
            return head.next == tail;
        }
    }
}
