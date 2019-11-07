package com.github.interview.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 11/6/19 10:10
 * @Description:
 */
public class FavoriteGenres {

    public Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        Map<String, List<String>> res = new HashMap<>();
        Map<String, String> songstogenre = new HashMap<>();

        for (String genre : genreMap.keySet()) {
            List<String> songs = genreMap.get(genre);
            for (String song : songs) {
                songstogenre.put(song, genre);
            }
        }

        Map<String, Map<String, Integer>> usergenrecount = new HashMap<>();
        for (String user : userMap.keySet()) {
            if (!usergenrecount.containsKey(user))
                usergenrecount.put(user, new HashMap<>());
            List<String> songs = userMap.get(user);
            for (String song : songs) {
                String genre = songstogenre.get(song);
                int count = usergenrecount.get(user).getOrDefault(genre, 0) + 1;
                usergenrecount.get(user).put(genre, count);
            }
        }

        for (String user : usergenrecount.keySet()) {
            if (!res.containsKey(user))
                res.put(user, new ArrayList<>());
            Map<String, Integer> pair = usergenrecount.get(user);
            int max = 0;
            List<String> favgenre = new ArrayList<>();
            for (String genre : pair.keySet()) {
                if (favgenre.size() == 0) {
                    favgenre.add(genre);
                    max = pair.get(genre);
                } else if (pair.get(genre) > max) {
                    favgenre.clear();
                    favgenre.add(genre);
                    max = pair.get(genre);
                } else if (pair.get(genre) == max)
                    favgenre.add(genre);
            }
            res.put(user, favgenre);
        }
        return res;
    }
}
