package arrays;

/**
 * 53. Maximum Subarray (easy)
 * <p>
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * A subarray is a contiguous part of an array.
 */
public class MaxSubArray {

    /**
     * Runtime: 1 ms, faster than 66.66% of Java online submissions for Maximum Subarray.
     * Memory Usage: 49.3 MB, less than 7.06% of Java online submissions for Maximum Subarray.
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum < 0)
                currentSum = 0;

            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
