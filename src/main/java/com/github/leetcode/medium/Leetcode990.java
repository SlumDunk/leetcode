package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 6/26/19 08:17
 * @Description: Given an array equations of strings that represent relationships between variables, each string equations[i] has length 4 and takes one of two different forms: "a==b" or "a!=b".  Here, a and b are lowercase letters (not necessarily different) that represent one-letter variable names.
 * <p>
 * Return true if and only if it is possible to assign integers to variable names so as to satisfy all the given equations.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["a==b","b!=a"]
 * Output: false
 * Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.  There is no way to assign the variables to satisfy both equations.
 * Example 2:
 * <p>
 * Input: ["b==a","a==b"]
 * Output: true
 * Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
 * Example 3:
 * <p>
 * Input: ["a==b","b==c","a==c"]
 * Output: true
 * Example 4:
 * <p>
 * Input: ["a==b","b!=c","c==a"]
 * Output: false
 * Example 5:
 * <p>
 * Input: ["c==c","b==d","x!=z"]
 * Output: true
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= equations.length <= 500
 * equations[i].length == 4
 * equations[i][0] and equations[i][3] are lowercase letters
 * equations[i][1] is either '=' or '!'
 * equations[i][2] is '='
 */
public class Leetcode990 {
    private int[] groups = new int[26];

    public boolean equationsPossible(String[] equations) {
        for (int i = 1; i < 26; i++) {
            groups[i] = i;
        }
        for (String s : equations) {
            if (s.charAt(1) == '=') {
                union(s.charAt(0), s.charAt(3));
            }
        }

        for (String s : equations) {
            if (s.charAt(1) == '!') {
                if (find(s.charAt(0) - 'a') == find(s.charAt(3) - 'a')) return false;
            }
        }
        return true;
    }

    /**
     * 合并
     * @param pre
     * @param rear
     */
    private void union(Character pre, Character rear) {
        groups[find(pre - 'a')] = groups[find(rear - 'a')];
    }

    /**
     * 找到最上的祖宗节点
     * @param x
     * @return
     */
    private int find(int x) {
        if (x == groups[x]) {
            return x;
        }
        return groups[x] = find(groups[x]);
    }


    public boolean dfsEquationsPossible(String[] equations) {
        if(equations.length == 0) return true;
        Map<Character, HashSet<Character>> map = new HashMap<>();
        for(String formula : equations) {
            if(formula.charAt(1) == '=') {
                Character pre = formula.charAt(0);
                Character nxt = formula.charAt(3);
                if(!map.containsKey(pre)) map.put(pre, new HashSet<>());
                map.get(pre).add(nxt);
                if(!map.containsKey(nxt)) map.put(nxt, new HashSet<>());
                map.get(nxt).add(pre);
            }
        }

        for(String formula : equations) {
            if(formula.charAt(1) == '!') {
                Character pre = formula.charAt(0);
                Character nxt = formula.charAt(3);
                if(pre == nxt) return false;
                if(!map.containsKey(pre) || !map.containsKey(nxt)) continue;
                if(hasConflict(pre, nxt, map, new HashSet<>())) return false;
            }
        }
        return true;
    }

    private boolean hasConflict(Character pre, Character nxt, Map<Character,
            HashSet<Character>> map, HashSet<Character> set) {
        if(pre == nxt) return true;
        set.add(pre);
        for(Character next : map.get(pre)) {
            if(set.contains(next)) continue;
            if(hasConflict(next, nxt, map, set)) return true;
        }
        return false;
    }
}
