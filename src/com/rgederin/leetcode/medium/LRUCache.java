package com.rgederin.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Runtime: 13 ms, faster than 75.87% of Java online submissions for LRU Cache.
 * Memory Usage: 47.3 MB, less than 100.00% of Java online submissions for LRU Cache
 */
public class LRUCache {

    /**
     * Entry for building doubly LinkedList
     */
    private class Entry {
        int value;
        int key;
        Entry left;
        Entry right;
    }

    /**
     * Hash map for O(1) lookups
     */
    private final Map<Integer, Entry> hashmap;

    /**
     * First and last entry of doubly LinkedList
     */
    private Entry first;
    private Entry last;

    /**
     * Cache capacity
     */
    private final int capacity;

    public LRUCache(int capacity) {
        hashmap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        //if key exists in the cache - update its `usage` - remove and add to the front of the list
        if (hashmap.containsKey(key)) {
            Entry entry = hashmap.get(key);
            removeEntry(entry);
            addEntryAtStart(entry);

            return entry.value;
        }

        return -1;
    }

    /**
     * Put entry in the cache
     *
     * @param key   - entry's key
     * @param value - entry's value
     */
    public void put(int key, int value) {
        // if key already exists in the cache - update it's value, remove and put it in front of linked list
        if (hashmap.containsKey(key)) {
            Entry entry = hashmap.get(key);
            entry.value = value;
            removeEntry(entry);
            addEntryAtStart(entry);
        } else {
            Entry entry = new Entry();

            entry.value = value;
            entry.key = key;

            // Cache is full, need to remove least recently used element from the cache (last one)
            if (hashmap.size() >= capacity) {
                hashmap.remove(last.key);
                removeEntry(last);
            }

            addEntryAtStart(entry);
            hashmap.put(key, entry);
        }
    }

    /**
     * Add entry in front of linked list
     *
     * @param entry - entry to add
     */
    private void addEntryAtStart(Entry entry) {
        //Add new entry in first position
        entry.right = first;
        entry.left = null;

        //If first already exists - add left lint to newly added entry
        if (first != null) {
            first.left = entry;
        }

        //Reassign first
        first = entry;

        //If only one element in list, set last = first
        if (last == null) {
            last = first;
        }
    }

    /**
     * Remove given entry from the doubly linked list
     *
     * @param entry - entry to remove
     */
    private void removeEntry(Entry entry) {
        //If not a start - change its right link to the right link of deleted node
        if (entry.left != null) {
            entry.left.right = entry.right;
        } else {
            first = entry.right;
        }

        //If not an end
        if (entry.right != null) {
            entry.right.left = entry.left;
        } else {
            last = entry.left;
        }
    }
}
