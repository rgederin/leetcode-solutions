package com.rgederin.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateInArray {
    /**
     * Runtime: 19 ms, faster than 5.19% of Java online submissions for Contains Duplicate.
     * Memory Usage: 54.3 MB, less than 9.45% of Java online submissions for Contains Duplicate.
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<>();

        for (int num : nums) {
            if (unique.contains(num)) {
                return true;
            } else {
                unique.add(num);
            }
        }

        return false;
    }

    /**
     * Runtime: 4 ms, faster than 83.13% of Java online submissions for Contains Duplicate.
     * Memory Usage: 43.7 MB, less than 76.27% of Java online submissions for Contains Duplicate.
     */
    public boolean containsDuplicateSort(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i< nums.length-1; i++){
            if (nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateInArray containsDuplicate = new ContainsDuplicateInArray();
        int [] arr = {1,2,3,1};

        containsDuplicate.containsDuplicate(arr);
    }
}
