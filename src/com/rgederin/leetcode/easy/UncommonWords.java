package com.rgederin.leetcode.easy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 884. Uncommon Words from Two Sentences
 */
public class UncommonWords {
    private Map<String, Integer> map = new HashMap<>();
    private List<String> list = new ArrayList<>();

    /**
     * Runtime: 2 ms, faster than 74.70% of Java online submissions for Uncommon Words from Two
     * Sentences. Memory Usage: 38.7 MB, less than 54.54% of Java online submissions for Uncommon
     * Words from Two Sentences.
     *
     * @param A
     * @param B
     * @return
     */
    public String[] uncommonFromSentences(String A, String B) {
        for (String s : A.split(" ")) {
            if (map.containsKey(s)) {
                map.computeIfPresent(s, (k, v) -> v + 1);
            } else {
                map.put(s, 1);
            }
        }

        for (String s : B.split(" ")) {
            if (map.containsKey(s)) {
                map.computeIfPresent(s, (k, v) -> v + 1);
            } else {
                map.put(s, 1);
            }
        }

        return list.toArray(new String[0]);
    }
}
