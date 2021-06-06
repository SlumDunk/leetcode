package com.github.leetcode.medium;

import java.util.*;

/**
 * You are given some lists of regions where the first region of each list includes all other regions in that list.
 * <p>
 * Naturally, if a region X contains another region Y then X is bigger than Y. Also by definition a region X contains itself.
 * <p>
 * Given two regions region1, region2, find out the smallest region that contains both of them.
 * <p>
 * If you are given regions r1, r2 and r3 such that r1 includes r3, it is guaranteed there is no r2 such that r2 includes r3.
 * <p>
 * It's guaranteed the smallest region exists.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * regions = [["Earth","North America","South America"],
 * ["North America","United States","Canada"],
 * ["United States","New York","Boston"],
 * ["Canada","Ontario","Quebec"],
 * ["South America","Brazil"]],
 * region1 = "Quebec",
 * region2 = "New York"
 * Output: "North America"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= regions.length <= 10^4
 * region1 != region2
 * All strings consist of English letters and spaces with at most 20 letters.
 */
public class Leetcode1257 {
    private String ans;

    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> geoMap = new HashMap<>();
        for (List<String> region : regions) {
            for (int i = 0; i < region.size(); i++) {
                geoMap.putIfAbsent(region.get(i), region.get(0));
            }
        }
        Set<String> set = new HashSet<>();
        parentFinder(geoMap, region1, set);
        parentFinder(geoMap, region2, set);
        return ans;
    }

    private void parentFinder(Map<String, String> geoMap, String region, Set<String> set) {
        if (region == null) {
            return;
        }

        if (set.contains(region)) {
            ans = region;
            return;
        }
        set.add(region);
        parentFinder(geoMap, geoMap.get(region), set);
    }
}
