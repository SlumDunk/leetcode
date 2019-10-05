package com.github.leetcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 9/14/19 11:33
 * @Description: We are given some website visits: the user with name username[i] visited the website website[i] at time timestamp[i].
 * <p>
 * A 3-sequence is a list of websites of length 3 sorted in ascending order by the time of their visits.  (The websites in a 3-sequence are not necessarily distinct.)
 * <p>
 * Find the 3-sequence visited by the largest number of users. If there is more than one solution, return the lexicographically smallest such 3-sequence.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"], timestamp = [1,2,3,4,5,6,7,8,9,10], website = ["home","about","career","home","cart","maps","home","home","about","career"]
 * Output: ["home","about","career"]
 * Explanation:
 * The tuples in this example are:
 * ["joe", 1, "home"]
 * ["joe", 2, "about"]
 * ["joe", 3, "career"]
 * ["james", 4, "home"]
 * ["james", 5, "cart"]
 * ["james", 6, "maps"]
 * ["james", 7, "home"]
 * ["mary", 8, "home"]
 * ["mary", 9, "about"]
 * ["mary", 10, "career"]
 * The 3-sequence ("home", "about", "career") was visited at least once by 2 users.
 * The 3-sequence ("home", "cart", "maps") was visited at least once by 1 user.
 * The 3-sequence ("home", "cart", "home") was visited at least once by 1 user.
 * The 3-sequence ("home", "maps", "home") was visited at least once by 1 user.
 * The 3-sequence ("cart", "maps", "home") was visited at least once by 1 user.
 * <p>
 * <p>
 * Note:
 * <p>
 * 3 <= N = username.length = timestamp.length = website.length <= 50
 * 1 <= username[i].length <= 10
 * 0 <= timestamp[i] <= 10^9
 * 1 <= website[i].length <= 10
 * Both username[i] and website[i] contain only lowercase characters.
 * It is guaranteed that there is at least one user who visited at least 3 websites.
 * No user visits two websites at the same time.
 */
public class Leetcode1152 {


    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<String>> websiteMap = new HashMap<>();
        Map<String, List<Integer>> timestampMap = new HashMap<>();
        Map<String, Map<Integer, String>> timestampWebsiteLinkMap = new HashMap<>();
        Map<String, Integer> sequenceMap = new HashMap<>();

        int max = Integer.MIN_VALUE;
        String result = "";
        for (int i = 0; i < username.length; i++) {
            String user = username[i];
            int time = timestamp[i];
            String url = website[i];

            if (!websiteMap.containsKey(user)) websiteMap.put(user, new ArrayList<>());
            if (!timestampMap.containsKey(user)) timestampMap.put(user, new ArrayList<>());
            if (!timestampWebsiteLinkMap.containsKey(user)) timestampWebsiteLinkMap.put(user, new TreeMap<>());

            websiteMap.get(user).add(url);
            timestampMap.get(user).add(time);
            timestampWebsiteLinkMap.get(user).put(time, url);
        }

        for (String user : websiteMap.keySet()) {
            List<Integer> timestamps = timestampMap.get(user);
            //获取timestamp和website的映射关系
            Map<Integer, String> map = timestampWebsiteLinkMap.get(user);
            Collections.sort(timestamps);
            List<String> websites = new ArrayList<>();
            for (Integer item : timestamps) {
                websites.add(map.get(item));
            }
            Set<String> set = new HashSet<>();
            for (int i = 0; i < websites.size(); i++) {
                StringBuilder buffer = new StringBuilder();
                buffer.append(websites.get(i)).append("#");
                for (int j = i + 1; j < websites.size(); j++) {
                    buffer.append(websites.get(j)).append("#");
                    for (int k = j + 1; k < websites.size(); k++) {
                        buffer.append(websites.get(k));
                        String key = buffer.toString();
                        set.add(key);
                        buffer.setLength(0);
                        buffer.append(websites.get(i)).append("#");
                        buffer.append(websites.get(j)).append("#");
                    }
                    buffer.setLength(0);
                    buffer.append(websites.get(i)).append("#");
                }
            }
            for (String item : set) {
                sequenceMap.put(item, sequenceMap.getOrDefault(item, 0) + 1);
                if (sequenceMap.get(item) > max) {
                    max = sequenceMap.get(item);
                    result = item;
                } else if (sequenceMap.get(item) == max && item.compareTo(result) < 0) {
                    result = item;
                }
            }
        }

        List<String> ans = new ArrayList<>();
        String[] array = result.split("#");
        for (String item : array) {
            ans.add(item);
        }
        return ans;

    }
}
