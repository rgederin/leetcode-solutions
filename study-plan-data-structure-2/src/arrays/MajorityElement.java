package arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element (easy)
 *
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 */
public class MajorityElement {

    /**
     * Runtime: 12 ms, faster than 21.22% of Java online submissions for Majority Element.
     * Memory Usage: 44.4 MB, less than 70.02% of Java online submissions for Majority Element.
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return map.entrySet().stream()
                .filter(entry -> entry.getValue() == Collections.max(map.values()))
                .map(Map.Entry::getKey)
                .findFirst().get();
    }
}
