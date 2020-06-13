package com.rgederin.leetcode.easy;

/**
 * Runtime: 45 ms, faster than 19.75% of Java online submissions for Design HashSet.
 * Memory Usage: 45.5 MB, less than 100.00% of Java online submissions for Design HashSet.
 */
class MyHashSet {

    private static final int NUMBER_OF_BUCKETS = 16;
    private int numberOfFullBuckets;
    private Node[] buckets;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        buckets = new Node[NUMBER_OF_BUCKETS];
    }

    public void add(int key) {
        if (numberOfFullBuckets == buckets.length/2){
            resize(buckets.length * 2);
        }

        int index = index(key);
        int hash = hash(key);

        if (buckets[index] == null) {
            buckets[index] = new Node(key, hash);
            numberOfFullBuckets++;
            return;
        }

        Node current = buckets[index];

        while (current != null) {
            if (current.hash == hash) {
                return;
            }
            if (current.next == null) {
                current.next = new Node(key, hash);
                return;
            }

            current = current.next;
        }
    }

    public void remove(int key) {
        int index = index(key);
        int hash = hash(key);

        if (buckets[index] == null) {
            return;
        }

        Node current = buckets[index];
        Node previous = null;

        while (current != null) {
            if (current.hash == hash) {
                if (previous == null) {
                    buckets[index] = current.next;
                    numberOfFullBuckets--;
                    return;
                }
                previous.next = current.next;
                numberOfFullBuckets--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int index = index(key);
        int hash = hash(key);

        if (buckets[index] == null) {
            return false;
        }

        Node current = buckets[index];

        while (current != null) {
            if (current.hash == hash) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    private int index(int key) {
        return Math.abs(hash(key)) % NUMBER_OF_BUCKETS;
    }

    private int hash(int key) {
        return Integer.hashCode(key);
    }

    private void resize(int capacity) {
        Node[] copy = new Node[capacity];
        for (int i = 0; i < buckets.length; i++)
            copy[i] = buckets[i];
        buckets = copy;
    }
}

class Node {
    int key;
    int hash;
    Node next;

    Node(int key, int hash) {
        this.key = key;
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", next=" + next +
                '}';
    }
}