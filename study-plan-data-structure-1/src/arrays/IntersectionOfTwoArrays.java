package arrays;

import java.util.*;

/**
 * 350. Intersection of Two Arrays II (easy)
 *
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 */
public class IntersectionOfTwoArrays {

    /**
     * Runtime: 5 ms, faster than 31.03% of Java online submissions for Intersection of Two Arrays II.
     * Memory Usage: 39.1 MB, less than 81.35% of Java online submissions for Intersection of Two Arrays II.
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> intersection = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2){
            if (map.containsKey(num) && map.get(num) != 0){
                intersection.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        return intersection
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}