package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum (easy)
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 */
public class TwoSum {

    /**
     * Runtime: 150 ms, faster than 5.05% of Java online submissions for Two Sum.
     * Memory Usage: 41.8 MB, less than 25.58% of Java online submissions for Two Sum.
     */
    public int[] bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return nums;
    }

    /**
     * Runtime: 2 ms, faster than 72.78% of Java online submissions for Two Sum.
     * Memory Usage: 42.9 MB, less than 6.55% of Java online submissions for Two Sum.
     */
    public int[] usingMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{i, map.get(nums[i])};
            }

            map.put(target - nums[i], i);
        }
        return nums;
    }
}
