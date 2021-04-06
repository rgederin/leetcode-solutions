package com.rgederin.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1436. Destination City
 *
 * You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path
 * going from cityAi to cityBi. Return the destination city, that is, the city without any path
 * outgoing to another city.
 * <p>
 * It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be
 * exactly one destination city.
 */
public class DestinationCity {

    /**
     * Runtime: 3 ms, faster than 18.06% of Java online submissions for Destination City. Memory
     * Usage: 38.5 MB, less than 76.41% of Java online submissions for Destination City.
     *
     * @param paths
     * @return
     */
    public static String destCity(List<List<String>> paths) {
        Set<String> finalDestinations = new HashSet<>();

        for (List<String> path : paths) {
            finalDestinations.add(path.get(1));
        }

        for (List<String> path : paths) {
            finalDestinations.remove(path.get(0));
        }

        return finalDestinations.stream().findFirst().get();
    }

    public static void main(String[] args) {

        List<String> l1 = Arrays.asList("B", "C");
        List<String> l2 = Arrays.asList("D", "B");
        List<String> l3 = Arrays.asList("C", "A");

        List<List<String>> list = Arrays.asList(l1, l2, l3);

        System.out.println(destCity(list));
    }
}
