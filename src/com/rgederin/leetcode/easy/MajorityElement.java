package com.rgederin.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer num : nums) {
            if (null == map.computeIfPresent(num, (k, v) -> v + 1)) {
                map.put(num, 1);
            }
        }

        System.out.println(map);


        return new TreeSet<>(map.values()).last();
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 4};
        System.out.println(majorityElement(nums));
    }
}
