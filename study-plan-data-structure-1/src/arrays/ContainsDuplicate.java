package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate (easy)
 *
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */
public class ContainsDuplicate {
    /**
     * Runtime: 11 ms, faster than 26.34% of Java online submissions for Contains Duplicate.
     * Memory Usage: 53.9 MB, less than 10.70% of Java online submissions for Contains Duplicate.
     */
    public boolean containsDuplicateUsingSet(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num))
                return true;
            else
                set.add(num);
        }

        return false;
    }

    /**
     * Runtime: 3 ms, faster than 99.63% of Java online submissions for Contains Duplicate.
     * Memory Usage: 41.9 MB, less than 96.21% of Java online submissions for Contains Duplicate.
     */
    public boolean containsDuplicateUsingSort(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (prev == nums[i])
                return true;
            else
                prev = nums[i];

        }

        return false;
    }
}