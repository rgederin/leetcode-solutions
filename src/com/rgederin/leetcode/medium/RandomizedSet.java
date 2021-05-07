package com.rgederin.leetcode.medium;

import java.util.Random;

/**
 * Runtime: 18 ms, faster than 26.70% of Java online submissions for Insert Delete GetRandom O(1).
 * Memory Usage: 44.3 MB, less than 92.00% of Java online submissions for Insert Delete GetRandom
 * O(1).
 */
class RandomizedSet {

    private static final int NUMBER_OF_BUCKETS = 16;
    private int size = 0;
    private Node[] buckets;

    private void resize(int capacity) {
        Node[] copy = new Node[capacity];
        if (size >= 0) {
            System.arraycopy(buckets, 0, copy, 0, size);
        }
        buckets = copy;
    }

    private int index(int key) {
        return Math.abs(hash(key)) % NUMBER_OF_BUCKETS;
    }

    private int hash(int key) {
        return Integer.hashCode(key);
    }


    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        buckets = new Node[NUMBER_OF_BUCKETS];
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified
     * element.
     */
    public boolean insert(int val) {
        int index = index(val);
        int hash = hash(val);

        if (buckets[index] == null) {
            buckets[index] = new Node(val, hash);
            size++;
            return true;
        }

        Node current = buckets[index];

        while (current != null) {
            if (current.hash == hash) {
                return false;
            }
            if (current.next == null) {
                current.next = new Node(val, hash);
                size++;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        int index = index(val);
        int hash = hash(val);

        if (buckets[index] == null) {
            return false;
        }

        Node current = buckets[index];
        Node previous = null;

        while (current != null) {
            if (current.hash == hash) {
                if (previous == null) {
                    buckets[index] = current.next;
                    size--;
                    return true;
                }
                previous.next = current.next;
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }

        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int random = index(new Random().nextInt(NUMBER_OF_BUCKETS));

        while (true) {
            if (buckets[random] == null) {
                random = index(new Random().nextInt(NUMBER_OF_BUCKETS));
            } else {
                return buckets[random].key;
            }
        }
    }

    private class Node {
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

    public static void main(String[] args) {
        // Init an empty set.
        RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomSet.insert(1);

// Returns false as 2 does not exist in the set.
        randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
        randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
        randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
        randomSet.remove(1);

// 2 was already in the set, so return false.
        randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
        randomSet.getRandom();
    }
}