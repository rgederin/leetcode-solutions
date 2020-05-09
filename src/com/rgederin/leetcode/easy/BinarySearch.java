package com.rgederin.leetcode.easy;

public class BinarySearch {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Search. Memory
     * Usage: 40.6 MB, less than 18.92% of Java online submissions for Binary Search.
     */
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (target < nums[mid]) {
                hi = mid - 1;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Search.
     * Memory Usage: 41 MB, less than 5.41% of Java online submissions for Binary Search.
     */
    public int searchRecursively(int[] nums, int target) {
        return binarySearchRecursive(target, nums, 0, nums.length - 1);
    }

    public int binarySearchRecursive(int search, int[] array, int start, int end) {

        int middle = (start + end) / 2;

        if (end < start) {
            return -1;
        }

        if (search < array[middle]) {
            return binarySearchRecursive(search, array, start, middle - 1);
        }

        if (search > array[middle]) {
            return binarySearchRecursive(search, array, middle + 1, end);
        }

        if (search == array[middle]) {
            return middle;
        }

        return -1;
    }
}
