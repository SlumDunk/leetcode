package com.github.leetcode.easy;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 11/6/19 00:20
 * @Description:
 */
public class Leetcode937 {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new LinkedList<>();
        List<String> digitLogs = new LinkedList<>();

        for (String log : logs) {
            String word = log.substring(log.lastIndexOf(" ") + 1, log.length());
            boolean flag = true;
            for (char c : word.toCharArray()) {
                if (Character.isLetter(c)) {
                    letterLogs.add(log);
                    flag = false;
                    break;
                } else {
                    continue;
                }
            }
            if (flag) {
                digitLogs.add(log);
            }
        }

        Collections.sort(letterLogs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String identifier1 = a.substring(0, a.indexOf(" "));
                String identifier2 = b.substring(0, b.indexOf(" "));
                a = a.substring(a.indexOf(" ") + 1, a.length());
                b = b.substring(b.indexOf(" ") + 1, b.length());
                int result = a.compareTo(b);
                return result != 0 ? result : identifier1.compareTo(identifier2);
            }
        });
        String[] ans = new String[logs.length];

        int index = 0;

        Iterator<String> iterator = letterLogs.iterator();
        while (iterator.hasNext()) {
            ans[index++] = iterator.next();
        }


        iterator = digitLogs.iterator();
        while (iterator.hasNext()) {
            ans[index++] = iterator.next();
        }

        return ans;
    }
}
