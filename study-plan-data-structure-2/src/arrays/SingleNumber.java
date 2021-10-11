package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 136. Single Number (easy)
 *
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        return xor(nums);
    }

    /**
     * Runtime: 9 ms, faster than 29.29% of Java online submissions for Single Number.
     * Memory Usage: 39 MB, less than 83.62% of Java online submissions for Single Number.
     */
    private int set(int[] nums){
        Set<Integer> unique = new HashSet<>();
        unique.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (unique.contains(nums[i])) {
                unique.remove(nums[i]);
            } else {
                unique.add(nums[i]);
            }
        }

        return (int) unique.toArray()[0];
    }

    /**
     * Input	Output
     * A	B	A XOR B
     * 0	0	  0
     * 0	1	  1
     * 1	0	  1
     * 1	1	  0
     * xor of 2 same number gives 0
     * Hence xor of duplicate number will yield 0
     * 0 xor non-zero will give the non zero number
     *
     * Runtime: 2 ms, faster than 56.16% of Java online submissions for Single Number.
     * Memory Usage: 47.3 MB, less than 34.77% of Java online submissions for Single Number.
     */
    public int xor(int[] nums) {
        int res=0;

        for(int i:nums){
            res^=i;
        }

        return res;
    }
}
