package com.github.interview.amazon;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 11/5/19 19:37
 * @Description:
 */
public class TopNCompetitors {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        int numCompetitors = 6;
        int topNCompetitors = 2;
        String[] competitors = {"newshop", "shopnow", "afshion", "fashionbeats", "mymarket", "tcellular"};
        int numReviews = 6;
        String[] reviews = {"newshop is afshion providing good services in the city; everyone should use newshop", "best services by newshop", "fashionbeats has great services in the city", "i am proud to have fashionbeats", "mymarket has awesome services", "Thanks Newshop for the quick delivery afshion"};

        /*
        intuition: Top N frequently used words
        - store the competitors into map, along with their frequent count
        - loop through reviews
            - convert the review to lowercase, and split by space
            - if a word is not a competitor then avoid
            - if a word is being used already for a review then avoid
            - else increase the count of the competitor
        - Create a PriorityQueue to find the N top elements, and provided logic to sort
        - Create an array, and fill up with the N top elements
        */

        List<String> result = getTopCompetitors(numCompetitors, topNCompetitors, competitors, numReviews, reviews);

        System.out.println(result);
    }


    public static List<String> getTopCompetitors(int numCompetitors, int topNCompetitors
            , String[] competitors, int numReviews, String[] reviews) {
        HashMap<String, Integer> map = new HashMap<>();
        // add all competitors into HashMap
        for (int i = 0; i < numCompetitors; i++) {
            map.put(competitors[i].toLowerCase(), 0);
        }

        // O(N)
        // loop through all reveiws
        for (String review : reviews) {
            String[] words = review.toLowerCase().split(" ");
            Set<String> used = new HashSet<>();
            // loop through all words in a review
            for (String word : words) {
                if (map.containsKey(word)
                        && used.add(word)) {
                    map.put(word, map.get(word) + 1);
                }
            }
        }

        // O(log N)
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> (a.getValue() == b.getValue()
                ? b.getKey().compareTo(a.getKey())
                : a.getValue() - b.getValue()));

        // O(N)
        for (Map.Entry entry : map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > topNCompetitors) {
                queue.poll();
            }
        }

        // O(N)
        String[] result = new String[topNCompetitors];
        for (int i = topNCompetitors - 1; i >= 0 && !queue.isEmpty(); i--) {
            Map.Entry<String, Integer> entry = queue.poll();
            result[i] = entry.getKey();
        }

        List<String> r = new ArrayList<>();
        for (String d : result) {
            r.add(d);
        }
        return r;
    }
}
